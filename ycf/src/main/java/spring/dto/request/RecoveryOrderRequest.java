package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RecoveryOrderRequest {
    @ApiModelProperty("用户ID")
    private Long memberId;
    @ApiModelProperty("宝贝图片")
    private String zPic;
    @ApiModelProperty("宝贝描述")
    private String remarks;
    @ApiModelProperty("原价")
    private BigDecimal goodsPrice;
    @ApiModelProperty("品牌")
    private String goodsBrand;
    @ApiModelProperty("价格凭证")
    private String pPic;
    @ApiModelProperty("新旧程度:0->全新,1->95新,2->9成新,3->8.5新,4->8成新,5->7成新")
    private Integer freshUsed;
}
