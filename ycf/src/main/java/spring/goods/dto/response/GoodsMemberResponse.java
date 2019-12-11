package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsMemberResponse {
    @ApiModelProperty(value = "商品ID")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "折扣价")
    private BigDecimal discountPrice;

    @ApiModelProperty(value = "商品主图")
    private String masterGraph;

}
