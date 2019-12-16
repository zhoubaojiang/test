package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class POrders implements Serializable {
    @ApiModelProperty(value = "ID主键")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "商品总数数量")
    private Integer goodsNum;

    @ApiModelProperty(value = "实付金额")
    private BigDecimal orderPrice;

    @ApiModelProperty(value = "购买人ID")
    private Long payUserId;

    @ApiModelProperty(value = "商品总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "订单状态:0待支付,1支付成功,2支付失败,3待发货,4已发货,5确认收货,6订单完成,7申请退款,8退款中,9退款完成,10拒绝退款,11取消订单,12订单关闭")
    private String orderState;

    @ApiModelProperty(value = "取消订单原因:0:我不想买了,1信息填写错误,2重新下单,3其他原因")
    private Integer type;

    @ApiModelProperty(value = "是否隐藏:0是,1否")
    private Integer state;

    @ApiModelProperty(value = "付款方式:0现金,1现金+元宝(鱿费)")
    private Integer orderType;

    @ApiModelProperty(value = "收件人姓名")
    private String receivedName;

    @ApiModelProperty(value = "收件人手机号码")
    private String phone;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "详情地址")
    private String address;

    @ApiModelProperty(value = "省市区详情地址")
    private String detailedAddress;

    @ApiModelProperty(value = "物流单号")
    private Long addressNo;

    @ApiModelProperty(value = "订单备注")
    private String remarks;

    @ApiModelProperty(value = "发货时间")
    private Date sendTime;

    @ApiModelProperty(value = "运费")
    private BigDecimal freight;

    @ApiModelProperty(value = "总鱿费抵扣")
    private BigDecimal youPrice;

    @ApiModelProperty(value = "0:发错货,1质量问题,2材质与商品描述不符,3收到商品少件或破损,4不喜欢/效果差,5其它")
    private String refundState;

    @ApiModelProperty(value = "退货原因备注")
    private String refundRemarks;

    @ApiModelProperty(value = "退货图片")
    private String refundPic;

    @ApiModelProperty(value = "退货金额")
    private BigDecimal refundPrice;

    @ApiModelProperty(value = "退货物流单号")
    private String refundAddressNo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Long getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(Long payUserId) {
        this.payUserId = payUserId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getReceivedName() {
        return receivedName;
    }

    public void setReceivedName(String receivedName) {
        this.receivedName = receivedName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Long getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(Long addressNo) {
        this.addressNo = addressNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getYouPrice() {
        return youPrice;
    }

    public void setYouPrice(BigDecimal youPrice) {
        this.youPrice = youPrice;
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState;
    }

    public String getRefundRemarks() {
        return refundRemarks;
    }

    public void setRefundRemarks(String refundRemarks) {
        this.refundRemarks = refundRemarks;
    }

    public String getRefundPic() {
        return refundPic;
    }

    public void setRefundPic(String refundPic) {
        this.refundPic = refundPic;
    }

    public BigDecimal getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(BigDecimal refundPrice) {
        this.refundPrice = refundPrice;
    }

    public String getRefundAddressNo() {
        return refundAddressNo;
    }

    public void setRefundAddressNo(String refundAddressNo) {
        this.refundAddressNo = refundAddressNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", payUserId=").append(payUserId);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", orderState=").append(orderState);
        sb.append(", type=").append(type);
        sb.append(", state=").append(state);
        sb.append(", orderType=").append(orderType);
        sb.append(", receivedName=").append(receivedName);
        sb.append(", phone=").append(phone);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", address=").append(address);
        sb.append(", detailedAddress=").append(detailedAddress);
        sb.append(", addressNo=").append(addressNo);
        sb.append(", remarks=").append(remarks);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", freight=").append(freight);
        sb.append(", youPrice=").append(youPrice);
        sb.append(", refundState=").append(refundState);
        sb.append(", refundRemarks=").append(refundRemarks);
        sb.append(", refundPic=").append(refundPic);
        sb.append(", refundPrice=").append(refundPrice);
        sb.append(", refundAddressNo=").append(refundAddressNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}