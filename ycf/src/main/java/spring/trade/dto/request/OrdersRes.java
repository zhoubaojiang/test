package spring.trade.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrdersRes {
    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("支付方式;0现金，1鱿费")
    private Integer orderType;
    @ApiModelProperty("收货地址ID")
    private Long addressId;
    @ApiModelProperty("商品ID")
    private String ids;
    @ApiModelProperty(value = "商品总价")
    private BigDecimal totalPrice;
    @ApiModelProperty(value = "实付金额")
    private BigDecimal orderPrice;
    @ApiModelProperty(value = "商品总数数量")
    private Integer goodsNum;
}
