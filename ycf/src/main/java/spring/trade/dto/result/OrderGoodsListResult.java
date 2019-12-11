package spring.trade.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderGoodsListResult {
    @ApiModelProperty(value = "商品图")
    private String goodsPicture;
    @ApiModelProperty(value = "产品名称")
    private String goodsName;
    @ApiModelProperty(value = "产品品相")
    private Integer goodsCondition;
    @ApiModelProperty(value = "售价")
    private BigDecimal goodsPrice;
    @ApiModelProperty(value = "抵扣鱿费数")
    private BigDecimal youPricce;
    @ApiModelProperty(value = "折扣价")
    private BigDecimal discountPrice;
    @ApiModelProperty(value = "实际付款")
    private BigDecimal orderPrice;
}
