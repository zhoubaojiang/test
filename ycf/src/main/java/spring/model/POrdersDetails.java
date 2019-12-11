package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class POrdersDetails implements Serializable {
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "订单号")
    private Long orderNo;

    @ApiModelProperty(value = "商品ID")
    private Long goodsId;

    @ApiModelProperty(value = "商品售价(商品原价)")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "折扣价")
    private BigDecimal discountPrice;

    @ApiModelProperty(value = "抵扣鱿费数")
    private BigDecimal youPricce;

    @ApiModelProperty(value = "实际付款")
    private BigDecimal orderPrice;

    @ApiModelProperty(value = "商品主图片")
    private String goodsPicture;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品数量")
    private Integer goodsNum;

    @ApiModelProperty(value = "商品品相：0全新，1优良，2普通，3轻度磨损，4不合格")
    private Integer goodsCondition;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public BigDecimal getYouPricce() {
        return youPricce;
    }

    public void setYouPricce(BigDecimal youPricce) {
        this.youPricce = youPricce;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getGoodsCondition() {
        return goodsCondition;
    }

    public void setGoodsCondition(Integer goodsCondition) {
        this.goodsCondition = goodsCondition;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", discountPrice=").append(discountPrice);
        sb.append(", youPricce=").append(youPricce);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", goodsPicture=").append(goodsPicture);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", goodsCondition=").append(goodsCondition);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}