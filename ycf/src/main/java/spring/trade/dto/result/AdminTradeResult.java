package spring.trade.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AdminTradeResult {
   @ApiModelProperty(value = "ID")
   private String id;
   @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "商品主图片")
    private String goodsPicture;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "商品总价")
    private BigDecimal totalPrice;
    @ApiModelProperty(value = "商品总数数量")
    private Integer goodsNum;
    @ApiModelProperty(value = "买家")
    private String memberName;
    @ApiModelProperty(value = "实付金额")
    private BigDecimal orderPrice;
    @ApiModelProperty(value = "订单状态:0待支付,1支付成功,2支付失败,3待发货,4已发货,5确认收货,6订单完成,7申请退款,8退款中,9退款完成,10拒绝退款,11取消订单,12订单关闭")
    private String orderState;
}
