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
    @ApiModelProperty(value = "订单状态:0待支付,1支付中,2支付失败,3支付成功,4待发货,5已发货,6确认收货,7订单完成,8申请退款,9退款中,10退款完成,11拒绝退款,12取消订单,13订单关闭")
    private String orderState;
}
