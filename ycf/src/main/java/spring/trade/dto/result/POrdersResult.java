package spring.trade.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class POrdersResult {

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品总数数量")
    private Integer goodsNum;

    @ApiModelProperty(value = "实付金额")
    private BigDecimal discountPrice;

    @ApiModelProperty(value = "商品原价")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "商品图片")
    private String goodsPicture;

}
