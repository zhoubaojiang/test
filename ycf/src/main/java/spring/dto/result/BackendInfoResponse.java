package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 
* 功能描述: 运营后台登录返回结果
* @author: xiongkun
* @date: 2018年8月22日 上午10:38:52
 */
@Data
public class BackendInfoResponse extends UserLoginResponse{
    @ApiModelProperty(value="可访问路径")
    private List<String> accessibleList;
    @ApiModelProperty(value="全部可访问权限")
    private List<PermissionResponse> permissionInfo;
}
