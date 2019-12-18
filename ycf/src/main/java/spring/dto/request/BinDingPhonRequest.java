package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BinDingPhonRequest {
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

}
