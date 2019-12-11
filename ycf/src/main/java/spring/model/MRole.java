package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MRole implements Serializable {
    @ApiModelProperty(value = "角色表主键")
    private Long roleId;

    @ApiModelProperty(value = "角色层级")
    private String roleLayer;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "角色序号")
    private Integer roleOrderNum;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleLayer() {
        return roleLayer;
    }

    public void setRoleLayer(String roleLayer) {
        this.roleLayer = roleLayer;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRoleOrderNum() {
        return roleOrderNum;
    }

    public void setRoleOrderNum(Integer roleOrderNum) {
        this.roleOrderNum = roleOrderNum;
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
        sb.append(", roleId=").append(roleId);
        sb.append(", roleLayer=").append(roleLayer);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleDesc=").append(roleDesc);
        sb.append(", status=").append(status);
        sb.append(", roleOrderNum=").append(roleOrderNum);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}