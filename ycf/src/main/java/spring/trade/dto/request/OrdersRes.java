package spring.trade.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrdersRes {
    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("商品ID")
    private Long goodsId;
    @ApiModelProperty("支付方式;0现金，1鱿费")
    private Integer orderType;
    @ApiModelProperty("收货地址ID")
    private Long addressId;
}
