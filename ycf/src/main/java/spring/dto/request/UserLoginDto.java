package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wangdg
 * @Description: 用户登录参数转化类
 * @date 2018/8/21 10:14
 */
@ToString
@Getter
@Setter
public class UserLoginDto {

	@ApiModelProperty(value ="登录账号",required = true)
	private String account;

	@ApiModelProperty(value ="登录密码",required = false)
	private String password;



    //----------------------------------APP会员相关字段-------------------------------------------
	@ApiModelProperty(value ="设备类型",required = false)
	private String deviceType;

	@ApiModelProperty(value ="设备id",required = false)
	private String deviceId;


	//----------------------------------请求头信息--------------------------------------------------

	@ApiModelProperty(value ="channelId",required = true)
	private String channelId;

	@ApiModelProperty(value ="userType",required = true)
	private String userType;
}
