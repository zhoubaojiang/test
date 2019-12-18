package spring.trade.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import spring.goods.dto.request.PageBeanUtile;

@Data
public class MemberOrderReq extends PageBeanUtile {
    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty(value = "订单状态:0待支付,1支付成功,2支付失败,3待发货,4已发货,5确认收货,6订单完成,7申请退款,8退款中,9退款完成,10拒绝退款,11取消订单,12订单关闭")
    private String orderState;
    @ApiModelProperty("订单ID")
    private Long orderNo;
    @ApiModelProperty("订单状态：，分割")
    private String ids;
}
