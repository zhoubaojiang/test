package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UUserMember implements Serializable {
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String passWord;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "元宝")
    private BigDecimal yuanBao;

    @ApiModelProperty(value = "金币")
    private BigDecimal gold;

    @ApiModelProperty(value = "现金")
    private BigDecimal price;

    @ApiModelProperty(value = "支付宝授权code")
    private String openId;

    @ApiModelProperty(value = "微信授权code")
    private String appId;

    @ApiModelProperty(value = "用户头像")
    private String picUrl;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getYuanBao() {
        return yuanBao;
    }

    public void setYuanBao(BigDecimal yuanBao) {
        this.yuanBao = yuanBao;
    }

    public BigDecimal getGold() {
        return gold;
    }

    public void setGold(BigDecimal gold) {
        this.gold = gold;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", passWord=").append(passWord);
        sb.append(", phone=").append(phone);
        sb.append(", yuanBao=").append(yuanBao);
        sb.append(", gold=").append(gold);
        sb.append(", price=").append(price);
        sb.append(", openId=").append(openId);
        sb.append(", appId=").append(appId);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}