package spring.trade.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class AdminTradeDetailsResult {
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "付款方式")
    private Integer orderType;
    @ApiModelProperty(value = "买家")
    private String memberName;
    @ApiModelProperty(value = "收件人")
    private String receivedName;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "物流单号")
    private String addressNo;
    @ApiModelProperty(value = "备注")
    private String remarks;
    @ApiModelProperty(value = "时间")
    private Date createTime;
    @ApiModelProperty(value = "订单状态:0待支付,1支付中,2支付失败,3支付成功,4待发货,5已发货,6确认收货,7订单完成,8申请退款,9退款中,10退款完成,11拒绝退款,12取消订单,13订单关闭")
    private String orderState;

    List<OrderGoodsListResult> orderGoodsListResults = new ArrayList<>();
}
