package spring.trade.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RefundOrderReequest {
    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("订单ID")
    private Long orderNo;

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
}
