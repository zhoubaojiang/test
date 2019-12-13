package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import spring.goods.dto.request.PageBeanUtile;

@Data
public class MemberCarListRequest extends PageBeanUtile {
    @ApiModelProperty(value = "会员ID")
    private String memberId;
}
