package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MUser implements Serializable {
    private Long userId;

    @ApiModelProperty(value = "账号")
    private String loginAccount;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "手机号码")
    private String telephone;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String passWord;

    @ApiModelProperty(value = "用户权限")
    private String userType;

    @ApiModelProperty(value = "用户状态:0可使用,1不可使用")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "唯一编号")
    private String wfcode;

    @ApiModelProperty(value = "创建人")
    private String createBy;

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getWfcode() {
        return wfcode;
    }

    public void setWfcode(String wfcode) {
        this.wfcode = wfcode;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", loginAccount=").append(loginAccount);
        sb.append(", roleId=").append(roleId);
        sb.append(", telephone=").append(telephone);
        sb.append(", userName=").append(userName);
        sb.append(", passWord=").append(passWord);
        sb.append(", userType=").append(userType);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", wfcode=").append(wfcode);
        sb.append(", createBy=").append(createBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}