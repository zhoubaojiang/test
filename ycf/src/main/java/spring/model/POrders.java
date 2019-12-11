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

    @ApiModelProperty(value = "订单状态:0待支付,1支付中,2支付失败,3支付成功,4待发货,5已发货,6确认收货,7订单完成,8申请退款,9退款中,10退款完成,11拒绝退款,12取消订单,13订单关闭")
    private String orderState;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", payUserId=").append(payUserId);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", orderState=").append(orderState);
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}