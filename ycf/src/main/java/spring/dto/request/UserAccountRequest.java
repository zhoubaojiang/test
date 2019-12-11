package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAccountRequest {
    @ApiModelProperty(value = "账号")
    private String loginAccount;
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
    @ApiModelProperty(value = "手机号码")
    private String telephone;
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    @ApiModelProperty(value = "用户密码")
    private String passWord;
    @ApiModelProperty(value = "用户权限")
    private String userType;
    @ApiModelProperty(value = "修改用户需要传:userID")
    private Long userId;
    @ApiModelProperty(value = "用户状态:0可使用,1不可使用")
    private Integer status;
}
