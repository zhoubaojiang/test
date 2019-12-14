package spring.goods.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsListRequest {
    @ApiModelProperty(value = "商品ID")
    private Long id;
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    @ApiModelProperty(value = "商品分类ID")
    private Long pmsType;
    @ApiModelProperty(value = "新旧程度:0->全新,1->95新,2->9成新,3->8.5新,4->8成新,5->7成新")
    private Integer freshUsed;
    @ApiModelProperty(value = "商品品牌")
    private String goodsBrand;
    @ApiModelProperty(value = "商品品相：0全新，1优良，2普通，3轻度磨损，4不合格")
    private Integer goodsCondition;
    @ApiModelProperty(value = "商品数量")
    private Integer goodsNumber;
    @ApiModelProperty(value = "商品原价")
    private BigDecimal goodsPrice;
    @ApiModelProperty(value = "折扣")
    private BigDecimal discount;
    @ApiModelProperty(value = "折扣价")
    private BigDecimal discountPrice;
    @ApiModelProperty(value = "元宝折扣")
    private BigDecimal treasureDiscount;
    @ApiModelProperty(value = "元宝折扣价")
    private BigDecimal treasureDiscountPrice;
    @ApiModelProperty(value = "快递费用方案：0包邮，1运费方案")
    private Integer express;
    @ApiModelProperty(value = "服务：0专业消毒，1官方直营，2品牌严选，3超级折扣")
    private String goodsService;
    @ApiModelProperty(value = "内容详情")
    private String contentDetails;
    @ApiModelProperty(value = "商品主图")
    private String masterGraph;
    @ApiModelProperty(value = "轮播图片多张逗号分开")
    private String goodsPicture;
    @ApiModelProperty(value = "商品详情图")
    private String goodsDetailPic;
    @ApiModelProperty(value = "商品状态：0上架，1未上架")
    private Integer goodsState;
    @ApiModelProperty(value = "是否热门：0热门，1不热门")
    private Integer goodsType;
    @ApiModelProperty(value = "是否已出售：0是，1否")
    private Integer goodsNumType;
    @ApiModelProperty(value = "是否删除：0是，1否")
    private Integer isDelete;
}
