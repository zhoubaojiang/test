package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddressRequest {
    @ApiModelProperty(value = "会员ID")
    private   String userId;
    @ApiModelProperty(value = "地址ID")
    private   String addressId;
    @ApiModelProperty(value = "是否默认")
    private   Integer defaultStatus;
    @ApiModelProperty(value = "删除：0")
    private   Integer isDelete;
}
