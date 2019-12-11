package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RecommendedResponse {
    @ApiModelProperty(value = "商品ID")
    private String goodsId;
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    @ApiModelProperty(value = "商品原价")
    private BigDecimal goodsPrice;
    @ApiModelProperty(value = "折扣价")
    private BigDecimal discountPrice;

}
