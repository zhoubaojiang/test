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

    @ApiModelProperty(value = "鱿费")
    private BigDecimal yuanBao;

    @ApiModelProperty(value = "鱿费累计收益")
    private BigDecimal youPrice;

    @ApiModelProperty(value = "金币")
    private BigDecimal gold;

    @ApiModelProperty(value = "累计赚取金币")
    private BigDecimal tGold;

    @ApiModelProperty(value = "现金")
    private BigDecimal price;

    @ApiModelProperty(value = "首次卖出物品是否已领取:0是,1否")
    private Integer tType;

    @ApiModelProperty(value = "首次购买物品是否已领取:0是,1否")
    private Integer wType;

    @ApiModelProperty(value = "是否已关注0是 1否")
    private Integer gType;

    @ApiModelProperty(value = "是否首次登录0是1否")
    private Integer cType;

    @ApiModelProperty(value = "鱿费领取金币已领取次数")
    private Integer lType;

    @ApiModelProperty(value = "支付宝授权code")
    private String openId;

    @ApiModelProperty(value = "微信授权code")
    private String appId;

    @ApiModelProperty(value = "用户头像")
    private String picUrl;

    @ApiModelProperty(value = "是否同意0:是1:否")
    private Integer button;

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

    public BigDecimal getYouPrice() {
        return youPrice;
    }

    public void setYouPrice(BigDecimal youPrice) {
        this.youPrice = youPrice;
    }

    public BigDecimal getGold() {
        return gold;
    }

    public void setGold(BigDecimal gold) {
        this.gold = gold;
    }

    public BigDecimal gettGold() {
        return tGold;
    }

    public void settGold(BigDecimal tGold) {
        this.tGold = tGold;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer gettType() {
        return tType;
    }

    public void settType(Integer tType) {
        this.tType = tType;
    }

    public Integer getwType() {
        return wType;
    }

    public void setwType(Integer wType) {
        this.wType = wType;
    }

    public Integer getgType() {
        return gType;
    }

    public void setgType(Integer gType) {
        this.gType = gType;
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public Integer getlType() {
        return lType;
    }

    public void setlType(Integer lType) {
        this.lType = lType;
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

    public Integer getButton() {
        return button;
    }

    public void setButton(Integer button) {
        this.button = button;
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
        sb.append(", youPrice=").append(youPrice);
        sb.append(", gold=").append(gold);
        sb.append(", tGold=").append(tGold);
        sb.append(", price=").append(price);
        sb.append(", tType=").append(tType);
        sb.append(", wType=").append(wType);
        sb.append(", gType=").append(gType);
        sb.append(", cType=").append(cType);
        sb.append(", lType=").append(lType);
        sb.append(", openId=").append(openId);
        sb.append(", appId=").append(appId);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", button=").append(button);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}