package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MRolepermissionManual implements Serializable {
    @ApiModelProperty(value = "角色权限关系表主键")
    private Long rolePermissionId;

    @ApiModelProperty(value = "角色表主键")
    private Long roleId;

    @ApiModelProperty(value = "权限表主键")
    private Long permissionId;

    private static final long serialVersionUID = 1L;

    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rolePermissionId=").append(rolePermissionId);
        sb.append(", roleId=").append(roleId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}