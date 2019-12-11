package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

/**
 * 
* 功能描述:  用户登录redis返回结果
* @author: xiongkun
* @date: 2018年8月22日 上午10:38:52
 */

public class UserLoginResponse {
	
	@ApiModelProperty(value="token")
    private String token;
    @ApiModelProperty(value="上次登录token")
    private String oldToken;
    @ApiModelProperty(value="登录账号")
    private String loginAccount = "";
    @ApiModelProperty(value="登录Id")
    private String loginId = "";
    @ApiModelProperty(value="用户Id(运营人员:user_id,会员：user_id)")
    private String userId = "";
    @ApiModelProperty(value="用户Id( 运营人员:user_id,会员：user_id)")
    private String uid = "";
    @ApiModelProperty(value="用户名称")
    private String userName = "";
    @ApiModelProperty(value="用户类型 0:会员 1:后台人员")
    private String userType = "";
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOldToken() {
		return oldToken;
	}
	public void setOldToken(String oldToken) {
		this.oldToken = oldToken;
	}
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUid() {
		return this.userId;
	}
	public void setUid(String uid) {
		if(StringUtils.isNotBlank(uid)){
			this.uid = uid;
		}else{
			this.uid = userId;
		}

	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}



}
