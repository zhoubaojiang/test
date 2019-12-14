package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MemberReceiveAddressReq {
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "收货人姓名")
    private String name;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "是否为默认")
    private Integer defaultStatus;

    @ApiModelProperty(value = "省份/直辖市")
    private String province;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "详细地址(街道)")
    private String detailAddress;

    @ApiModelProperty(value = "删除：0")
    private  Integer isDelete;
}
