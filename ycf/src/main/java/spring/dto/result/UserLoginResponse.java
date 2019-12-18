package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 *
* 功能描述:  用户登录redis返回结果
* @author: xiongkun
* @date: 2018年8月22日 上午10:38:52
 */
@Data
public class UserLoginResponse {

	@ApiModelProperty(value="token")
    private String token;
    @ApiModelProperty(value="上次登录token")
    private String oldToken;
    @ApiModelProperty(value="登录账号")
    private String loginAccount = "";
    @ApiModelProperty(value="登录Id")
    private String loginId = "";
    @ApiModelProperty(value="用户名称")
    private String userName = "";
    @ApiModelProperty(value="用户类型 0:会员 1:后台人员")
    private String userType = "";
    @ApiModelProperty(value="用户手机号")
    private String phone;
}
