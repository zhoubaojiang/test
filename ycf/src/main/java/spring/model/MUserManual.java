package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MUserManual implements Serializable {
    @ApiModelProperty(value = "用户表主键")
    private Long userId;

    @ApiModelProperty(value = "登录账号")
    private String loginAccount;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "用户类型")
    private Integer userType;

    @ApiModelProperty(value = "电话号码")
    private String telephone;

    @ApiModelProperty(value = "登录ip")
    private String loginIp;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "唯一编号")
    private String wfcode;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getWfcode() {
        return wfcode;
    }

    public void setWfcode(String wfcode) {
        this.wfcode = wfcode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", loginAccount=").append(loginAccount);
        sb.append(", position=").append(position);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", userType=").append(userType);
        sb.append(", telephone=").append(telephone);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleId=").append(roleId);
        sb.append(", wfcode=").append(wfcode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}