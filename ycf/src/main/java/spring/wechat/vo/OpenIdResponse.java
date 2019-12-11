package spring.wechat.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OpenIdResponse implements Serializable{

	/**
	 * @Description
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String errcode;
	
	private String errmsg;
	
	private String openid;
	
	private String session_key;

}
