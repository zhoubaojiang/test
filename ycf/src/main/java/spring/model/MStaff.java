package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MStaff implements Serializable {
    @ApiModelProperty(value = "员工ID")
    private Long staffId;

    @ApiModelProperty(value = "用户账号")
    private String account;

    private String staffcode;

    @ApiModelProperty(value = "商家ID")
    private Long supplierId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "角色")
    private String roleName;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", staffId=").append(staffId);
        sb.append(", account=").append(account);
        sb.append(", staffcode=").append(staffcode);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", roleId=").append(roleId);
        sb.append(", userName=").append(userName);
        sb.append(", mobile=").append(mobile);
        sb.append(", roleName=").append(roleName);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}