package spring.utils;

import spring.config.redis.util.JedisUtils;
import spring.dto.result.BackendInfoResponse;
import spring.dto.result.UserLoginResponse;
import com.alibaba.fastjson.JSON;

import java.util.Collection;
import java.util.Iterator;

/**
 *
* redis后台用户登录后缓存信息工具类：新增、查找、删除
* @author xiongkun
* @date: 2017年12月20日 上午10:50:52
* @version 1.4.0
*
 */
public class UserInfoRedisUtil {



	/**
	 *
	* 功能描述: 新增用户缓存信息<br>
	* @author: xiongkun
	* @date: 2018年8月16日 下午2:48:19
	* @param loginId     用户登录id：用户唯一识别id
	* @param userType    用户类型: Constants.USER_TYPE_***,包括(backend、agent、member、supplier)
	* @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	* @param user        缓存信息: redis中缓存对应用户类型数据信息，json字符串
	* @param seconds     有效时间: 缓存有效时间
	 */
	public static void addUserCache(String loginId, String userType, String channelId, UserLoginResponse user, int seconds) {
		channelId = getChannelId(channelId);
		JedisUtils.getJedisInstance().execSetexToCache(loginId + "-" + userType + "-" + channelId, seconds,
				JSON.toJSONString(user));
	}

	private static String getChannelId(String channelId){
		if(Constants.CHANNELID_IOS.equals(channelId) || Constants.CHANNELID_ANDROID.equals(channelId)){
			channelId = Constants.CHANNELID_APP;
		}
		return channelId;
	}

	/**
	 *
	 * 功能描述:  根据用户登录的logindId删除用户缓存信息<br>
	 * @author: xionkgun
	 * @date: 2018年8月22日 上午10:58:40
	 * @version 1.4.0
	 * @param loginId 	    用户登录id：用户唯一识别id
	 * @param userType    用户类型: Constants.USER_TYPE_***,包括(backend、agent、member、supplier)
	 * @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	 */
	public static void deleteUserCache(String loginId, String userType, String channelId) {
		channelId = getChannelId(channelId);
		JedisUtils.getJedisInstance().execDelToCache(loginId + "-" + userType + "-" + channelId);
	}

	/**
	 *
	 * 功能描述:  根据用户登录的logindId删除用户缓存信息<br>
	 * @author: xionkgun
	 * @date: 2018年8月22日 上午10:58:40
	 * @version 1.4.0
	 * @param loginId 	    用户登录id：用户唯一识别id
	 * @param userType    用户类型: Constants.USER_TYPE_***,包括(backend、agent、member、supplier)
	 */
	public static void deleteUserCache(String loginId, String userType) {
		Collection<String> keys = JedisUtils.getJedisInstance().execKeysToCache(loginId + "-" + userType + "-*");
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			String key = it.next();
			JedisUtils.getJedisInstance().execDelToCache(key);
		}
	}

	/**
	 *
	* 功能描述: 获取登录账号
	* @author: xiongkun
	* @date: 2018年8月23日 上午10:03:25
	* @param loginId 	    用户登录id：用户唯一识别id
	* @param userType    用户类型: Constants.USER_TYPE_***,包括(backend、agent、member、supplier,supplierStaff)
	* @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	* @return String     用户账号: 存在，则返回对应用户账号信息（account)，不存在，返回null
	*/
	public static String getLoginAccount(String loginId, String userType, String channelId){
		channelId = getChannelId(channelId);
		String loginInfoStr = JedisUtils.getJedisInstance().execGetFromCache(loginId + "-" + userType + "-" + channelId);
		UserLoginResponse loginInfo = JSON.parseObject(loginInfoStr, UserLoginResponse.class);
		if(loginInfo !=  null){
			return loginInfo.getLoginAccount();
		}
		return null;
	}

	/**
	 *
	* 功能描述: 获取token信息  验证登录要使用
	* @author: xiongkun
	* @date: 2018年8月23日 上午10:03:25
	* @param loginId 	    用户登录id：用户唯一识别id
	* @param userType    用户类型: Constants.USER_TYPE_***,包括(backend、agent、member、supplier)
	* @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	* @return String     用户账号: 存在，则返回对应用户账号信息（account)，不存在，返回null
	*/
	public static String getToken(String loginId, String userType, String channelId){
		channelId = getChannelId(channelId);
		String loginInfoStr = JedisUtils.getJedisInstance().execGetFromCache(loginId + "-" + userType + "-" + channelId);
		UserLoginResponse loginInfo = JSON.parseObject(loginInfoStr, UserLoginResponse.class);
		if(loginInfo !=  null){
			return loginInfo.getToken();
		}
		return null;
	}

	/**
	 *
	 * 功能描述: 获取登录账号
	 * @author: xiongkun
	 * @date: 2018年8月23日 上午10:03:25
	 * @param httpServletRequestUtil		http请求类
	 * @return
	 */
	public static String getLoginAccount(HttpServletRequestUtil httpServletRequestUtil){
		return getLoginAccount(httpServletRequestUtil.getLoginId(),httpServletRequestUtil.getUserType(),httpServletRequestUtil.getChannelId());
	}
	/**
	 *
	* 功能描述: 获取用户名字
	* @author: xiongkun
	* @date: 2018年8月23日 上午10:03:25
	* @param loginId 	    用户登录id：用户唯一识别id
	* @param userType    用户类型: Constants.USER_TYPE_***,包括(backend、agent、member、supplier)
	* @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	* @return String     用户名字: 存在，则返回对应用户名字信息，不存在，返回null
	 */
	public static String getUserName(String loginId, String userType, String channelId){
		channelId = getChannelId(channelId);
		String loginInfoStr = JedisUtils.getJedisInstance().execGetFromCache(loginId + "-" + userType + "-" + channelId);
		UserLoginResponse loginInfo = JSON.parseObject(loginInfoStr, UserLoginResponse.class);
		if(loginInfo !=  null){
			return loginInfo.getUserName();
		}
		return null;
	}
	/**
	 *
	 * 功能描述: 获取用户名字
	 * @author: xiongkun
	 * @date: 2018年8月23日 上午10:03:25
	 * @param httpServletRequestUtil		http请求类
	 * @return
	 */
	public static String getUserName(HttpServletRequestUtil httpServletRequestUtil){
		return getUserName(httpServletRequestUtil.getLoginId(),httpServletRequestUtil.getUserType(),httpServletRequestUtil.getChannelId());
	}

	/**
	 *
	 * 功能描述: 根据用户登录的logindId获取用户缓存信息<br>
	 * @author: xiongkun
	 * @date: 2018年8月22日 上午10:54:16
	 * @version 1.8.1
	 * @param loginId 	    用户登录id：用户唯一识别id
	 * @param userType    用户类型: Constants.USER_TYPE_***,包括(backend、agent、member、supplier,supplierStaff)
	 * @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	 * @return userCache  </br>
	 * 用户缓存信息:</br>
	 * USER_TYPE_AGENT:代理商缓存信息</br>
	 * USER_TYPE_SUPPLIER:商家缓存信息</br>
	 * USER_TYPE_BACKEND:后台管理员缓存信息</br>
	 * USER_TYPE_MEMBER:会员缓存信息</br>
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getUserCache(String loginId, String userType, String channelId) {
		channelId = getChannelId(channelId);
		String loginInfo = JedisUtils.getJedisInstance().execGetFromCache(loginId + "-" + userType + "-" + channelId);
		 if(Constants.USER_TYPE_BACKEND.equals(userType)){
			return (T) JSON.parseObject(loginInfo, BackendInfoResponse.class);
		}else if(Constants.USER_TYPE_MEMBER.equals(userType)){
			return (T) JSON.parseObject(loginInfo, UserLoginResponse.class);
		}
		return null;
	}

	/**
	 *
	 * 功能描述: 根据用户登录的logindId获取用户缓存信息<br>
	 * @author: xiongkun
	 * @date: 2018年8月22日 上午10:54:16
	 * @version 1.8.1
	 * @param httpServletRequestUtil	http请求类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getUserCache(HttpServletRequestUtil httpServletRequestUtil) {
		return  getUserCache(httpServletRequestUtil.getLoginId(),httpServletRequestUtil.getUserType(),httpServletRequestUtil.getChannelId());
	}
	/**
	 *
	* 功能描述: 获取代理商缓存信息
	* @author: xiongkun
	* @date: 2018年8月20日 下午4:04:11
	* @param loginId 	    用户登录id：用户唯一识别id
	* @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	* @return 代理商缓存信息
	*/
//	public static AgentInfoResponse getAgentInfoCache(String loginId, String channelId) {
//		String loginInfo = JedisUtils.getJedisInstance().execGetFromCache(loginId + "-" + Constants.USER_TYPE_AGENT + "-" + channelId);
//		return JSON.parseObject(loginInfo, AgentInfoResponse.class);
//	}

	/**
	 *
	* 功能描述: 获取商家缓存信息
	* @author: xiongkun
	* @date: 2018年8月20日 下午4:04:11
	* @param loginId 	    用户登录id：用户唯一识别id
	* @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	* @return 商家缓存信息
	 */
//	public static SupplierInfoResponse getSupplierInfoCache(String loginId, String channelId) {
//		String loginInfo = JedisUtils.getJedisInstance().execGetFromCache(loginId + "-" + Constants.USER_TYPE_SUPPLIER + "-" + channelId);
//		return JSON.parseObject(loginInfo, SupplierInfoResponse.class);
//	}

	/**
	 *
	* 功能描述: 获取运营人员缓存信息
	* @author: xiongkun
	* @date: 2018年8月20日 下午4:04:11
	* @param loginId 	    用户登录id：用户唯一识别id
	* @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	* @return 运营后台管理人员缓存信息
	 */
	public static BackendInfoResponse getBackendInfoCache(String loginId, String channelId) {
		String loginInfo = JedisUtils.getJedisInstance().execGetFromCache(loginId + "-" + Constants.USER_TYPE_BACKEND + "-" + channelId);
		return JSON.parseObject(loginInfo, BackendInfoResponse.class);
	}

	/**
	 *
	* 功能描述: 获取会员缓存信息
	* @author: xiongkun
	* @date: 2018年8月20日 下午4:04:11
	* @param loginId 	    用户登录id：用户唯一识别id
	* @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	* @return 会员缓存信息
	 */
	public static UserLoginResponse getMemberInfoCache(String loginId, String channelId) {
		channelId = getChannelId(channelId);
		String loginInfo = JedisUtils.getJedisInstance().execGetFromCache(loginId + "-" + Constants.USER_TYPE_MEMBER + "-" + channelId);
		return JSON.parseObject(loginInfo, UserLoginResponse.class);
	}

	/**
	 *
	* 功能描述: 验证是否存在缓存
	* @author: xiongkun
	* @date: 2018年8月16日 下午2:55:48
	 * @param loginId 	    用户登录id：用户唯一识别id
	 * @param userType    用户类型: Constants.USER_TYPE_***,包括(backend、agent、member、supplier)
	 * @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	* @return 是否存在缓存信息，true，存在，false，不存在
	 */
	public static boolean existsCache(String loginId, String userType, String channelId) {
		channelId = getChannelId(channelId);
		return JedisUtils.getJedisInstance().execExistsFromCache(loginId + "-" + userType + "-" + channelId);
	}

	/**
	 *
	 * 功能描述: 获取用户ID
	 * @author: xiongkun
	 * @date: 2018年8月23日 上午10:03:25
	 * @param loginId 	    用户登录id：用户唯一识别id
	 * @param userType    用户类型: Constants.USER_TYPE_***,包括(backend、agent、member、supplier,supplierStaff)
	 * @param channelId   终端来源: Constants.CHANNELID_***,包括(ios、android、backend、php、pc、app、h5)
	 * @return backendUserId/agentId/userId/supplierId     用户id: 存在，则返回对应用户id，不存在，返回null
	 */
	public static Long getUserId(String loginId, String userType, String channelId){
		channelId = getChannelId(channelId);
		String loginInfoStr = JedisUtils.getJedisInstance().execGetFromCache(loginId + "-" + userType + "-" + channelId);
		UserLoginResponse loginInfo = JSON.parseObject(loginInfoStr, UserLoginResponse.class);
		if(loginInfo !=  null){
			return Long.parseLong(loginInfo.getUserId());
		}
		return null;
	}
}
