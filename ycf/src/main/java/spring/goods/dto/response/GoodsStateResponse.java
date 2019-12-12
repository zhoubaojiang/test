package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsStateResponse {

    @ApiModelProperty(value = "所有商品")
    private Long goodsNumber;
    @ApiModelProperty(value = "上架")
    private Long upper;
    @ApiModelProperty(value = "未上架")
    private Long lower;
    @ApiModelProperty(value = "已出售")
    private Long sell;

}
