package spring.wechat.exception;

/**
 * 
 * @Description 业务异常
 * @date: 2018年5月8日 上午10:08:56
 */
public class BusinessException extends RuntimeException{

	/**
	 * @Description
	 */
	private static final long serialVersionUID = 8785414384215222798L;
	
	
	private int code = 0 ;
	
	private String errorMsg;
	
	public BusinessException(int code, String errorMsg) {
		this.code = code;
		this.errorMsg = errorMsg;
	}
	
	public BusinessException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
