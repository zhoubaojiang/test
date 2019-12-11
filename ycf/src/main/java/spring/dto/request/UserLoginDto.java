package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wangdg
 * @Description: 用户登录参数转化类
 * @date 2018/8/21 10:14
 */
@Data
public class UserLoginDto {

	@ApiModelProperty(value ="登录账号")
	private String account;

	@ApiModelProperty(value ="登录密码")
	private String password;

	//----------------------------------请求头信息--------------------------------------------------

	@ApiModelProperty(value ="channelId")
	private String channelId;

	@ApiModelProperty(value ="userType")
	private String userType;
}
