package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class GoodsDetailsResponse {
    @ApiModelProperty(value = "商品ID")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品分类ID:pms_product_category")
    private Long pmsType;

    @ApiModelProperty(value = "商品品相")
    private String goodsBrand;

    @ApiModelProperty(value = "商品品相：0全新，1优良，2普通，3轻度磨损，4不合格")
    private Integer goodsCondition;

    @ApiModelProperty(value = "商品数量")
    private Integer goodsNumber;

    @ApiModelProperty(value = "商品原价")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "新旧程度:0->全新,1->95新,2->9成新,3->8.5新,4->8成新,5->7成新")
    private Integer freshUsed;

    @ApiModelProperty(value = "折扣")
    private Long discount;

    @ApiModelProperty(value = "折扣价")
    private BigDecimal discountPrice;

    @ApiModelProperty(value = "元宝折扣")
    private Long treasureDiscount;

    @ApiModelProperty(value = "元宝折扣价")
    private BigDecimal treasureDiscountPrice;

    @ApiModelProperty(value = "内容详情")
    private String contentDetails;

    @ApiModelProperty(value = "商品主图")
    private String masterGraph;
}
