package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MPermissionMxpand implements Serializable {
    private Long permissionId;

    @ApiModelProperty(value = "权限表父标签")
    private Long parentId;

    private Long userType;

    @ApiModelProperty(value = "权限名称")
    private String permissionName;

    @ApiModelProperty(value = "权限描述")
    private String permissionDesc;

    @ApiModelProperty(value = "权限KEY")
    private String permissionKey;

    @ApiModelProperty(value = "权限链接")
    private String permissionUrl;

    @ApiModelProperty(value = "权限类型")
    private Integer permissionType;

    @ApiModelProperty(value = "状态:0可使用,1不可使用")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", permissionId=").append(permissionId);
        sb.append(", parentId=").append(parentId);
        sb.append(", userType=").append(userType);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", permissionDesc=").append(permissionDesc);
        sb.append(", permissionKey=").append(permissionKey);
        sb.append(", permissionUrl=").append(permissionUrl);
        sb.append(", permissionType=").append(permissionType);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}