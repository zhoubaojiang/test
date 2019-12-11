package spring.wechat.dto.requset;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PayReq {

    @ApiModelProperty("订单号")
    private Long orderNo;
    @ApiModelProperty("微信唯一标识AppID")
    private String openId;

}
