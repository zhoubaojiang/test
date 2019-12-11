package spring.exception;

import lombok.Getter;

/**
 *  基础自定义异常类，自定义继承该异常类
*
 * @author wenwj 
 * @date: 2017年11月15日 上午10:05:12 
* @since 1.0
 */
public class BaseServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 4172573415632244679L;
    @Getter
    private  Integer responseCode;
    @Getter
    private  String responseMsg;

    /**
     * 构造器
     * @param responseCode 状态返回码
     * @param responseMsg 状态返回信息
     */
    public BaseServiceException(Integer responseCode, String responseMsg){
        super("["+responseCode+"]"+responseMsg);
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    /**
     * 构造器
     * @param responseCode 状态返回码
     */
	public BaseServiceException(Integer responseCode) {
		 super("["+responseCode+"]"+BaseApiCode.getZhMsg(responseCode));
	     this.responseCode = responseCode;
	     this.responseMsg  = BaseApiCode.getZhMsg(responseCode);
	}
    
}
