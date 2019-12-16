package spring.trade.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RecoveryOfferRequest {
    @ApiModelProperty(value = "回收商品ID")
    private Long orderNo;

    @ApiModelProperty(value = "新旧程度:0->全新,1->95新,2->9成新,3->8.5新,4->8成新,5->7成新(后台选择)")
    private Integer mFreshUsed;

    @ApiModelProperty(value = "鱿费")
    private BigDecimal youPrice;

    @ApiModelProperty(value = "现金")
    private BigDecimal price;

    @ApiModelProperty(value = "拒绝理由")
    private String deRemarks;

    @ApiModelProperty(value = "商品品相：0全新，1优良，2普通，3轻度磨损，4不合格")
    private Integer goodsCondition;

    @ApiModelProperty(value = "提交回收订单—>0:待确认—>1:已报价(报价)—>2确认回收价格—>3:上门验收—>4:已验收—>5:完成->6取消->7拒绝")
    private Integer orderState;

}
