package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 
* 功能描述: 权限信息
* @author: xiongkun
* @date: 2018年8月29日 上午11:56:40
 */
@Data
public class PermissionResponse {

	@ApiModelProperty(value="权限表主键")
    private Long permissionId;

	@ApiModelProperty(value="权限表父标签")
    private Long parentId;

	@ApiModelProperty(value="权限名称")
    private String permissionName;

	@ApiModelProperty(value="权限描述")
    private String permissionDesc;

	@ApiModelProperty(value="权限key")
    private String permissionKey;

	@ApiModelProperty(value="显示顺序")
    private Integer showOrderNum;

	@ApiModelProperty(value="操作方式")
    private Integer operatorMode;

	@ApiModelProperty(value="权限链接")
    private String permissionUrl;

	@ApiModelProperty(value="权限类型")
    private String permissionType;

	@ApiModelProperty(value="权限链接图片")
    private String permissionImg;

	@ApiModelProperty(value="状态")
    private String status;

    @ApiModelProperty(value="创建时间")
    private Date createDate;

    @ApiModelProperty(value="创建人")
    private String createBy;
}
