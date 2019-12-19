package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import spring.model.UUserMember;

@Data
public class MemberPriceReslut extends UUserMember {
    @ApiModelProperty(value = "首次卖出物品")
    private Long tcount;

    @ApiModelProperty(value = "首次购买物品")
    private Long ycount;

    @ApiModelProperty(value = "满一百鱿费可领取")
    private int lcount;
}
