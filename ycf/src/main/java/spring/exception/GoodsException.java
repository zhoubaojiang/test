package spring.exception;


import java.io.Serializable;

/**交易异常
 * Created by jiangzf on 2017/6/13.
 */
public class GoodsException extends BaseServiceException implements Serializable{

	private static final long serialVersionUID = 8279565169607633172L;

	public GoodsException(Integer responseCode, String responseMsg) {
		super(responseCode, responseMsg);
	}

	public GoodsException(Integer responseCode) {
		super(responseCode);
	}
}
