package spring.config.redis.util;

import spring.config.redis.exception.RedisLockException;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class RedisLockUtil {

    private static Logger logger = LoggerFactory.getLogger(RedisLockUtil.class);

    /**
     * 加锁标志
     **/
    public static final String LOCKED = "TRUE";
    /**
     * 锁的超时时间（秒），过期删除
     **/
    public static final int EXPIRE = 60;
    /**
     * 1毫秒对应的纳秒时间
     **/
    public static final long ONE_MILLI_NANOS = 1000000L;
    /**
     * 默认超时时间（毫秒）
     **/
    public static final long DEFAULT_TIME_OUT = 2000;
    /**
     * 随机数
     **/
    public static final Random random = new Random();

    // 获取锁lua脚本
    private static String mulLockScript =
            "local a=0 " +
                    "for i=1,ARGV[1] do " +
                    "    if redis.call('setNx',KEYS[i],ARGV[i+2]) then " +
                    "         if redis.call('get',KEYS[i])==ARGV[i+2] then " +
                    "             a=a+redis.call('pexpire',KEYS[i],ARGV[2]) " +
                    "        end " +
                    "    end " +
                    "end " +
                    "if a<tonumber(ARGV[1]) then " +
                    "    for i=1,ARGV[1] do " +
                    "        if redis.call('get', KEYS[i])==ARGV[i+2] then " +
                    "            redis.call('del', KEYS[i]) " +
                    "        end " +
                    "    end " +
                    "end " +
                    "return a ";
    // 释放锁lua脚本
    private static String mulUnLockScript =
            "local a = 0 " +
                    "for i=1,ARGV[1] do " +
                    "    if redis.call('get', KEYS[i])==ARGV[i+1] then " +
                    "        redis.call('del', KEYS[i]) " +
                    "        a = a+1 " +
                    "    end " +
                    "end " +
                    "return a ";

    /**
     * 加锁 保证原子性
     *
     * @param operator     处理逻辑
     * @param lockCacheKey 锁的cache key
     * @param milliTimeout 毫秒数    	 获取锁的超时时间
     * @return
     */
    public static <T> T executeSynchOperate(MainOperator<T> operator,
                                            String lockCacheKey, long milliTimeout) {
        Boolean locked = false;
        long startNaros = System.nanoTime();
        long nanoTimeOut = milliTimeout * 1000000L;
        T resultObj = null;
        try {
            while (System.nanoTime() - startNaros < nanoTimeOut) {
                if (JedisUtils.getJedisInstance().execSetnxToCache(lockCacheKey, LOCKED)) {
                    JedisUtils.getJedisInstance().execExpireToCache(lockCacheKey, EXPIRE);
                    locked = true;
                    break;
                }
                Thread.sleep(30, random.nextInt(500));
            }
            resultObj = operator.executeInvokeLogic(locked);
        } catch (InterruptedException ex) {
            throw new RedisLockException(ex);
        } finally {
            if (locked) {
                releaseRedisLock(lockCacheKey);
            }
        }
        return resultObj;
    }


    /**
     * 针对锁提前过期后，客户端A还没执行完，然后客户端B获取到了锁，
     * 这时候客户端A执行完了，会不会在删锁的时候把B的锁给删掉
     * 加锁 保证原子性
     *
     * @param operator     处理逻辑
     * @param lockCacheKey 锁的cache key
     * @param milliTimeout 毫秒数      获取锁的超时时间
     * @return
     */
    public static <T> T synchOperate(MainOperator<T> operator,
                                     String lockCacheKey, long milliTimeout) {

        Boolean locked = false;
        long startNaros = System.nanoTime();
        String value = UUID.randomUUID().toString();
        long nanoTimeOut = milliTimeout * 1000000L;
        T resultObj = null;
        try {
            while (System.nanoTime() - startNaros < nanoTimeOut) {
                if (JedisUtils.getJedisInstance().execSetnxToCache(lockCacheKey, value)) {
                    JedisUtils.getJedisInstance().execExpireToCache(lockCacheKey, EXPIRE);
                    locked = true;
                    break;
                }
                Thread.sleep(30, random.nextInt(500));
            }
            resultObj = operator.executeInvokeLogic(locked);
        } catch (InterruptedException ex) {
            throw new RedisLockException(ex);
        } finally {
            if (locked && StringUtils.equals(JedisUtils.getJedisInstance().execGetFromCache(lockCacheKey), value)) {
                releaseRedisLock(lockCacheKey);
            }
        }
        return resultObj;
    }


    /**
     * 加锁多个锁 保证原子性
     *
     * @param operator     处理逻辑
     * @param lockKeys     锁的cache key
     * @param milliTimeout 毫秒数      获取锁的超时时间
     * @return
     */
    public static <T> T synchOperateMulLock(MainOperator<T> operator, List<String> lockKeys, long milliTimeout) {
        Boolean locked = false;
        long startNaros = System.nanoTime();
        long nanoTimeOut = milliTimeout * 1000000L;
        // lua脚本参数
        Object[] uuids = Stream.generate(() -> UUID.randomUUID().toString()).limit(lockKeys.size()).toArray();
        String[] args = {lockKeys.size() + "", milliTimeout + ""};
        int argsLength = args.length;
        args = Arrays.copyOf(args, args.length + uuids.length);
        System.arraycopy(uuids, 0, args, argsLength, uuids.length);
        T resultObj = null;
        JedisUtils jedis = JedisUtils.getJedisInstance();
        try {
            while (System.nanoTime() - startNaros < nanoTimeOut) {
                // 获取redis锁
                Long lockNum = jedis.execEval(mulLockScript, lockKeys, Long.class, args);
                // 如果获取不到锁,需要把获取到的锁释放掉
                if (lockNum == lockKeys.size()) {
                    locked = true;
                    break;
                }
                Thread.sleep(30, random.nextInt(500));
            }
            resultObj = operator.executeInvokeLogic(locked);
        } catch (InterruptedException ex) {
            throw new RedisLockException(ex);
        } finally {
            Long lockNum = jedis.execEval(mulUnLockScript, lockKeys, Long.class, args);
        }
        return resultObj;
    }

    /**
     * 操作本身实现的逻辑
     *
     * @param <T>
     */
    public abstract interface MainOperator<T> {
        public abstract T executeInvokeLogic(boolean result);
    }

    /**
     * 释放锁
     *
     * @param cacheKey
     */
    private static void releaseRedisLock(final String cacheKey) {
        JedisUtils.getJedisInstance().execDelToCache(cacheKey);
    }

    /**
     * 可重入锁信息
     */
    @Setter
    @Getter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ReentrantInfo {
        private String uuid;
        private AtomicInteger count;
    }
}
