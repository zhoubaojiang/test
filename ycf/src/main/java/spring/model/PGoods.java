package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PGoods implements Serializable {
    @ApiModelProperty(value = "商品ID")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品分类ID:pms_product_category")
    private Long pmsType;

    @ApiModelProperty(value = "商品品牌")
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

    @ApiModelProperty(value = "快递费用方案：0包邮，1运费方案")
    private Integer express;

    @ApiModelProperty(value = "快递ID")
    private Long expressId;

    @ApiModelProperty(value = "快递名称")
    private String expressName;

    @ApiModelProperty(value = "服务：0专业消毒，1官方直营，2品牌严选，3超级折扣")
    private String goodsService;

    @ApiModelProperty(value = "内容详情")
    private String contentDetails;

    @ApiModelProperty(value = "商品主图")
    private String masterGraph;

    @ApiModelProperty(value = "轮播图片多张逗号分开")
    private String goodsPicture;

    @ApiModelProperty(value = "商品状态：0上架，1未上架")
    private Integer goodsState;

    @ApiModelProperty(value = "是否热门：0热门，1不热门")
    private Integer goodsType;

    @ApiModelProperty(value = "是否已出售：0是，1否")
    private Integer goodsNumType;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "是否删除：0是，1否")
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getPmsType() {
        return pmsType;
    }

    public void setPmsType(Long pmsType) {
        this.pmsType = pmsType;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public Integer getGoodsCondition() {
        return goodsCondition;
    }

    public void setGoodsCondition(Integer goodsCondition) {
        this.goodsCondition = goodsCondition;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getFreshUsed() {
        return freshUsed;
    }

    public void setFreshUsed(Integer freshUsed) {
        this.freshUsed = freshUsed;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Long getTreasureDiscount() {
        return treasureDiscount;
    }

    public void setTreasureDiscount(Long treasureDiscount) {
        this.treasureDiscount = treasureDiscount;
    }

    public BigDecimal getTreasureDiscountPrice() {
        return treasureDiscountPrice;
    }

    public void setTreasureDiscountPrice(BigDecimal treasureDiscountPrice) {
        this.treasureDiscountPrice = treasureDiscountPrice;
    }

    public Integer getExpress() {
        return express;
    }

    public void setExpress(Integer express) {
        this.express = express;
    }

    public Long getExpressId() {
        return expressId;
    }

    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(String goodsService) {
        this.goodsService = goodsService;
    }

    public String getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(String contentDetails) {
        this.contentDetails = contentDetails;
    }

    public String getMasterGraph() {
        return masterGraph;
    }

    public void setMasterGraph(String masterGraph) {
        this.masterGraph = masterGraph;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsNumType() {
        return goodsNumType;
    }

    public void setGoodsNumType(Integer goodsNumType) {
        this.goodsNumType = goodsNumType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", pmsType=").append(pmsType);
        sb.append(", goodsBrand=").append(goodsBrand);
        sb.append(", goodsCondition=").append(goodsCondition);
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", freshUsed=").append(freshUsed);
        sb.append(", discount=").append(discount);
        sb.append(", discountPrice=").append(discountPrice);
        sb.append(", treasureDiscount=").append(treasureDiscount);
        sb.append(", treasureDiscountPrice=").append(treasureDiscountPrice);
        sb.append(", express=").append(express);
        sb.append(", expressId=").append(expressId);
        sb.append(", expressName=").append(expressName);
        sb.append(", goodsService=").append(goodsService);
        sb.append(", contentDetails=").append(contentDetails);
        sb.append(", masterGraph=").append(masterGraph);
        sb.append(", goodsPicture=").append(goodsPicture);
        sb.append(", goodsState=").append(goodsState);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", goodsNumType=").append(goodsNumType);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}