package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MemberCarRequest {

    @ApiModelProperty(value = "会员ID")
    private String memberId;

    @ApiModelProperty(value = "商品ID")
    private Long goodsId;

    @ApiModelProperty(value = "删除使用参数  购物车商品列表 memberCarDetailId")
    private Long memberCarDetailId;

}
