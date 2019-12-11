package spring.exception;
import java.util.HashMap;
import java.util.Map;

/**
 * 
*	公共基础编码：10000、99999，需继承该编码表
 * @author wenwj 
 * @date: 2017年11月15日 上午9:38:53 
* @since 1.0
 */
public class BaseApiCode {

	public static final Map<Integer, String> zhMsgMap = new HashMap<Integer, String>(300);
	
	/** 请求成功 **/
	public static final Integer SUCCESS = 10000;
	/** 失败 **/
	public static final Integer FAIL = 99999;
	/** 必填参数校验失败 */
	public static final Integer PARAM_FAIL =99998;

	/**
	 * 
	 * 功能描述: 获取状态码对应提示信息<br>
	 * @author: wenwj
	 * @date: 2017年11月15日 上午9:40:12 
	 * @param responseCode
	 * @return
	 */
	public static String getZhMsg(Integer responseCode) {
		return zhMsgMap.get(responseCode);
	}

	
	static {
		zhMsgMap.put(SUCCESS, "成功");
		zhMsgMap.put(FAIL, "系统繁忙，请稍后再试");
		zhMsgMap.put(PARAM_FAIL, "必填参数校验失败");
	}
	
}
