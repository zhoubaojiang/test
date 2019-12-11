package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MemberRequest {

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "微信授权code")
    private String appId;

    @ApiModelProperty(value = "用户头像")
    private String picUrl;

    @ApiModelProperty(value ="userType",required = true)
    private String userType;

}
