package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberCarResult {
    @ApiModelProperty(value = "商品ID")
    private String goodsId;
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    @ApiModelProperty(value = "售价")
    private BigDecimal discountPrice;
    @ApiModelProperty(value = "会员购物车中间表ID")
    private String memberCarDetailId;
    @ApiModelProperty(value = "是否已出售：0是，1否")
    private String goodsNumType;
}
