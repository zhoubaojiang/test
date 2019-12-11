package spring.config.redis.util;

import spring.config.redis.util.spring.AppContextLauncher;
import spring.utils.Constants;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class JedisUtils {

    // volatile: 增加多线程下可见性; 防止指令重排带来的null
    private static volatile JedisUtils jedisUtils = new JedisUtils();

    private StringRedisTemplate stringRedisTemplate = null;


    private static DefaultRedisScript<String> redisScript;

    private static RedisSerializer stringSerializer;

    private JedisUtils() {
        redisScript = new DefaultRedisScript<String>();
        redisScript.setResultType(String.class);
        stringSerializer = new StringRedisSerializer();
        stringRedisTemplate = AppContextLauncher.getBean("stringRedisTemplate", StringRedisTemplate.class);
    }

    public static JedisUtils getJedisInstance() {
        return jedisUtils;
    }


    /**
     * 功能描述: 得到从缓冲中自增num的值
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:38:45
     *
     * @param cacheKey
     * @param num
     * @return Long
     */
    public Long execIncrByToCache(final String cacheKey, final int num) {

        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.incrBy(cacheKey, num);
            }
        });
    }


    /**
     * 功能描述: 得到从缓冲中自增1的值
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:38:58
     *
     * @param cacheKey
     * @return Long
     */
    public Long execIncrToCache(final String cacheKey) {

        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.incr(cacheKey);
            }
        });
    }


    /**
     * 功能描述:  得到从缓冲中自减1的值
     * Author: 陈建宇
     * Date:   2016年12月29日 下午2:36:16
     * return  Long
     */
    public Long execDecrToCache(final String cacheKey) {

        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.decr(cacheKey);
            }
        });
    }

    /**
     * 功能描述:  得到从缓冲中自减num的值
     * Author: 陈建宇
     * Date:   2016年12月29日 下午2:37:04
     * return  Long
     */
    public Long execDecrByToCache(final String cacheKey, final int num) {

        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.decrBy(cacheKey, num);
            }
        });
    }


    /**
     * 功能描述: 删除缓存
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:39:23
     *
     * @param cacheKey
     * @return boolean
     */
    public boolean execDelToCache(final String cacheKey) {
        return stringRedisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.del(cacheKey) == Constants.CONSTANT_INT_ZERO ? false : true;
            }
        });
    }


    /**
     * 功能描述: 存入缓存值 LRU
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:39:38
     *
     * @param cacheKey
     * @param value
     */
    public void execSetToCache(final String cacheKey, final String value) {

        stringRedisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                stringRedisConn.set(cacheKey, value);
                return null;
            }
        });
    }

    /**
     * 功能描述: 设置key value  seconds
     * Author: 陈建宇
     * Date:   2016年12月29日 下午2:34:46
     * return  void
     */
    public void execSetexToCache(final String cacheKey, final int seconds, final String value) {
        stringRedisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                stringRedisConn.setEx(cacheKey, seconds, value);
                return null;
            }
        });
    }

    /**
     * 功能描述:  通过key获取value
     * Author: 陈建宇
     * Date:   2017年4月25日 下午4:41:44
     * param   cacheKey
     * return  String
     */
    public String execGetFromCache(final String cacheKey) {

        return stringRedisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.get(cacheKey);
            }
        });
    }

    /**
     * 功能描述: 是否已经缓存
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:40:16
     *
     * @param cacheKey
     * @return Boolean
     */
    public Boolean execExistsFromCache(final String cacheKey) {

        return stringRedisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.exists(cacheKey);
            }
        });
    }

    /**
     * 功能描述: 设置过期时间
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:40:29
     *
     * @param cacheKey
     * @param seconds
     * @return Long
     */
    public Boolean execExpireToCache(final String cacheKey, final int seconds) {
        return stringRedisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.expire(cacheKey, seconds);
            }
        });
    }


    /**
     * 功能描述:  SETNX actually means "SET if Not eXists"
     * Author: 陈建宇
     * Date:   2016年12月29日 下午2:37:49
     * return  Long
     */
    public Boolean execSetnxToCache(final String cacheKey, final String value) {
        return stringRedisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.setNX(cacheKey, value);
            }
        });
    }


    /**
     * 功能描述: hash操作 存放
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:41:12
     *
     * @param cacheKey
     * @param hash
     * @return String
     */
    public Void execHmsetToCache(final String cacheKey, final Map<String, String> hash) {
        return stringRedisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                stringRedisConn.hMSet(cacheKey, hash);
                return null;
            }
        });
    }


    /**
     * 功能描述: 返回哈希表 key 中给定域 field 的值。
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:41:40
     *
     * @param cacheKey
     * @param field
     * @return String
     */
    public String execHgetToCache(final String cacheKey, final String field) {

        return stringRedisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.hGet(cacheKey, field);
            }
        });
    }


    /**
     * 功能描述: 将哈希表 key中的域 field的值设为value
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:42:07
     *
     * @param cacheKey
     * @param field
     * @param value
     * @return Boolean
     */
    public Boolean execHsetToCache(final String cacheKey, final String field, final String value) {
        return stringRedisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.hSet(cacheKey, field, value);
            }
        });
    }

    /**
     * 功能描述: 为哈希表中的字段值加上指定增量值。
     * Author: DG
     * Date:   2018/11/30 17:11
     *
     * @param cacheKey
     * @param field
     * @param incrNum
     * @return Long
     */
    public long execHincrbyToCache(final String cacheKey, final String field, final long incrNum) {
        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.hIncrBy(cacheKey, field, incrNum);
            }
        });
    }

    /**
     * 功能描述: 返回哈希表 key中,所有的域和值。
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:42:22
     *
     * @param cacheKey
     * @return Map
     */
    public Map<String, String> execHgetAllToCache(final String cacheKey) {

        return stringRedisTemplate.execute(new RedisCallback<Map<String, String>>() {
            @Override
            public Map<String, String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.hGetAll(cacheKey);
            }
        });
    }


    /**
     * 功能描述: 设置到什么时候过期
     * Author: 陈建宇
     * Date:   2016年12月14日 上午9:42:35
     *
     * @param cacheKey
     * @param unixTime
     * @return Boolean
     */
    public Boolean execExpireAtTimeToCache(final String cacheKey, final Long unixTime) {
        return stringRedisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.expireAt(cacheKey, unixTime);
            }
        });
    }

    /**
     * 功能描述: 删除和获取列表中的第一个元素，或阻塞直到有可用
     *
     * @param timeout
     * @param key
     * @return
     * @author: chenjy
     * @date: 2017年8月2日 下午3:45:01
     */
    public List<String> execBlpopToCache(final int timeout, final String... key) {

        return stringRedisTemplate.execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.bLPop(timeout, key);
            }
        });
    }

    /**
     * @param
     * @return
     * @Description:
     * @author wangdg
     * @date 2018/5/26 15:43
     */
    public String execLpopToCache(String key) {
        return stringRedisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.lPop(key);
            }
        });
    }

    /**
     * 功能描述: list尾部插入所有指定的值
     *
     * @param key
     * @param strings
     * @return
     * @author: chenjy
     * @date: 2017年8月2日 下午3:49:19
     */
    public Long execRpushToCache(final String key, final String... strings) {
        return stringRedisTemplate.execute(new RedisCallback<Long>() {

            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.rPush(key, strings);
            }
        });
    }


    /**
     * 功能描述: 返回存储在key列表的长度
     *
     * @param key
     * @return
     * @author: chenjy
     * @date: 2017年8月2日 下午4:27:53
     */
    public Long execLlenToCache(final String key) {
        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.lLen(key);
            }
        });
    }


    /**
     * 功能描述: 根据key模糊匹配
     *
     * @param keys
     * @return
     * @author: chenjy
     * @date: 2017年11月6日 上午9:05:26
     */
    public Collection<String> execKeysToCache(final String keys) {
        return stringRedisTemplate.execute(new RedisCallback<Collection<String>>() {
            @Override
            public Collection<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.keys(keys);
            }
        });
    }


    /**
     * 功能描述: 管道批量操作
     *
     * @param action
     * @return
     * @author: chenjy
     * @date: 2017年8月28日 下午4:56:41
     */
    public List<Object> executePipeline(RedisCallback<?> action) {
        return stringRedisTemplate.executePipelined(action);
    }

    /**
     * @param key   Set 集合的key
     * @param value 是否重复的元素
     * @return
     * @Description: 判断成员元素是否是集合的成员。
     * @author DG
     * @date 2018/11/8 13:57
     */
    public Boolean execSismember(String key, String value) {
        return stringRedisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.sIsMember(key, value);
            }
        });
    }

    /**
     * @param key Set集合对应的key
     * @return
     * @Description: 返回集合中元素的数量。
     * @author DG
     * @date 2018/11/8 14:05
     */
    public Long execSetCount(String key) {
        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.sCard(key);
            }
        });
    }


    /**
     * @param key    Set集合对应的key
     * @param values values 添加成员元素
     * @return
     * @Description: 将一个或多个成员元素加入到集合中，已经存在于集合的成员元素将被忽略
     * @author DG
     * @date 2018/11/8 14:05
     */
    public Long execSetAdd(String key, String... values) {
        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.sAdd(key, values);
            }
        });
    }

    /**
     * @return
     * @Description: 获取 Redis 时间
     * @author DG
     * @date 2018/11/8 14:05
     */
    public Long execTime() {
        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.time();
            }
        });
    }

    /**
     * @param key 缓存key
     * @return
     * @Description: 查询超时时间
     * @author DG
     * @date 2018/12/10 9:40
     */
    public long execTTL(String key) {
        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.ttl(key);
            }
        });
    }

    /**
     * @param pattern 匹配key
     * @return
     * @Description: 匹配符合 pattern 规则的key
     * @author DG
     * @date 2018/12/10 9:40
     */
    public Collection<String> execKeys(String pattern) {
        return stringRedisTemplate.execute(new RedisCallback<Collection>() {
            @Override
            public Collection doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.keys(pattern);
            }
        });
    }

    /**
     * @param keys key数组
     * @return
     * @Description: 获取所有(一个或多个)给定 key 的值
     * @author DG
     * @date 2018/12/10 9:40
     */
    public List<String> execMGet(String... keys) {
        return stringRedisTemplate.execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.mGet(keys);
            }
        });
    }

    /**
     * @Description: 执行lua脚本
     * @param script            lua脚本
     * @param lockKeys          lua脚本keys集合
     * @param clz               返回值类型
     * @param args              lua脚本参数
     * @return
     * @author DG
     * @date 2019/1/24 14:59
     */
    public <T> T execEval(String script,List<String> lockKeys,Class<T> clz,String ...args){
        stringRedisTemplate.setKeySerializer(stringSerializer);
        stringRedisTemplate.setValueSerializer(stringSerializer);
        stringRedisTemplate.setHashKeySerializer(stringSerializer);
        stringRedisTemplate.setHashValueSerializer(stringSerializer);
        DefaultRedisScript defaultRedisScript = new DefaultRedisScript(script,clz);
        T result =  (T)stringRedisTemplate.execute(defaultRedisScript, stringSerializer, stringSerializer, lockKeys, args);
        //spring-data-redis不支持null映射为false，非null映射成true，所以使用String替代。
        //哪怕clazzs为String类型，但是result也会自动转为Long类型。
        return (clz.equals(String.class) && result != null) ? (T) result.toString() : result;
    }


    /**
     * @Description: 将一个元素加入到集合中，已经存在于集合的成员元素将被覆盖score值
     * @param key		SortedSet集合对应的key
     * @param score	元素的double值
     * @param value   元素的value值
     * @return
     * @author SongWei
     * @date 2019/1/23 14:05
     */
    public Boolean execSortedSetAdd(String key,double score,String value){
        return stringRedisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zAdd(key,score,value);
            }
        });
    }

    /**
     * @Description: 将一个或多个成员元素在集合中删除
     * @param key
     * @param values
     * @author SongWei
     * @date 2019/1/23 14:05
     * @return
     */
    public Long execSortedSetDel(String key,String... values){
        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zRem(key,values);
            }
        });
    }

    /**
     * @Description: 在集合中查询start到end个元素，多用于分页
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> execSortedSetZRange(String key,long start,long end){
        return stringRedisTemplate.execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zRange(key,start,end);
            }
        });
    }

    /**
     * @Description: 在集合中倒序查询start到end个元素，多用于分页,该结果无序，如果需要顺序的结果集用bytep[]作为参数
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> execSortedSetZRevRange(String key,long start,long end){
        return stringRedisTemplate.execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zRevRange(key,start,end);
            }
        });
    }

    /**
     * @Description: 在集合中倒序查询start到end个元素，多用于分页
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<byte[]> execSortedSetZRevRange(byte[] key,long start,long end){
        return stringRedisTemplate.execute(new RedisCallback<Set<byte[]>>() {
            @Override
            public Set<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zRevRange(key,start,end);
            }
        });
    }

    /**
     * @Description: 返回有序集合中指定成员的索引
     * @param key
     * @param value
     * @return
     */
    public Long execSortedSetZRank(String key,String value){
        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zRank(key,value);
            }
        });
    }

    /**
     * @Description: 通过分数返回有序集合指定区间内的成员
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<String> execSortedSetZRangeByScore(String key,String min,String max){
        return stringRedisTemplate.execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zRangeByScore(key, min, max);
            }
        });
    }

    /**
     * @Description: 通过分数返回有序集合指定区间内的成员
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public Set<String> execSortedSetZRangeByScore(String key,String min,String max,Long offset,Long count){
        return stringRedisTemplate.execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zRangeByScore(key,min,max,offset,count);
            }
        });
    }

    /**
     * @Description: 返回有序集中，成员的分数值
     * @param key
     * @param value
     * @return
     */
    public Double execSortedSetZScore(String key,String value){
        return stringRedisTemplate.execute(new RedisCallback<Double>() {
            @Override
            public Double doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zScore(key,value);
            }
        });
    }

    /**
     * @Description: 移除有序集合中的一个或多个成员
     * @param key
     * @param values
     * @return
     */
    public Long execSortedSetZRem(String key,String... values){
        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zRem(key,values);
            }
        });
    }

    /**
     * @Description: 移除有序集合中给定的分数区间的所有成员
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long execSortedSetZRemRangeByScore(String key,double min,double max){
        return stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.zRemRangeByScore(key,min,max);
            }
        });
    }

}
