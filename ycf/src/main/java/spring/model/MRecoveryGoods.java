package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MRecoveryGoods implements Serializable {
    private Long id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "会员姓名")
    private String memberName;

    @ApiModelProperty(value = "宝贝标题")
    private String title;

    @ApiModelProperty(value = "提交回收订单—>0:待确认—>1:已报价—>2确认回收价格—>3:上门验收—>4:已验收—>5:完成->6取消->7拒绝")
    private Integer orderState;

    @ApiModelProperty(value = "商品图片")
    private String zPic;

    @ApiModelProperty(value = "详情图")
    private String xPic;

    @ApiModelProperty(value = "价格凭证")
    private String pPic;

    @ApiModelProperty(value = "商品品牌")
    private String goodsBrand;

    @ApiModelProperty(value = "商品品相：0全新，1优良，2普通，3轻度磨损，4不合格")
    private Integer goodsCondition;

    @ApiModelProperty(value = "新旧程度:0->全新,1->95新,2->9成新,3->8.5新,4->8成新,5->7成新")
    private Integer freshUsed;

    @ApiModelProperty(value = "商品原价")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "鱿费")
    private BigDecimal youPrice;

    @ApiModelProperty(value = "现金")
    private BigDecimal price;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "拒绝理由")
    private String deRemarks;

    @ApiModelProperty(value = "新旧程度:0->全新,1->95新,2->9成新,3->8.5新,4->8成新,5->7成新(后台选择)")
    private Integer mFreshUsed;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getzPic() {
        return zPic;
    }

    public void setzPic(String zPic) {
        this.zPic = zPic;
    }

    public String getxPic() {
        return xPic;
    }

    public void setxPic(String xPic) {
        this.xPic = xPic;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public Integer getGoodsCondition() {
        return goodsCondition;
    }

    public void setGoodsCondition(Integer goodsCondition) {
        this.goodsCondition = goodsCondition;
    }

    public Integer getFreshUsed() {
        return freshUsed;
    }

    public void setFreshUsed(Integer freshUsed) {
        this.freshUsed = freshUsed;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getYouPrice() {
        return youPrice;
    }

    public void setYouPrice(BigDecimal youPrice) {
        this.youPrice = youPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDeRemarks() {
        return deRemarks;
    }

    public void setDeRemarks(String deRemarks) {
        this.deRemarks = deRemarks;
    }

    public Integer getmFreshUsed() {
        return mFreshUsed;
    }

    public void setmFreshUsed(Integer mFreshUsed) {
        this.mFreshUsed = mFreshUsed;
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
        sb.append(", orderNo=").append(orderNo);
        sb.append(", memberId=").append(memberId);
        sb.append(", memberName=").append(memberName);
        sb.append(", title=").append(title);
        sb.append(", orderState=").append(orderState);
        sb.append(", zPic=").append(zPic);
        sb.append(", xPic=").append(xPic);
        sb.append(", pPic=").append(pPic);
        sb.append(", goodsBrand=").append(goodsBrand);
        sb.append(", goodsCondition=").append(goodsCondition);
        sb.append(", freshUsed=").append(freshUsed);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", youPrice=").append(youPrice);
        sb.append(", price=").append(price);
        sb.append(", remarks=").append(remarks);
        sb.append(", deRemarks=").append(deRemarks);
        sb.append(", mFreshUsed=").append(mFreshUsed);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}