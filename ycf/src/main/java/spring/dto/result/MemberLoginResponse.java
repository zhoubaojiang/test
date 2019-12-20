package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class MemberLoginResponse extends UserLoginResponse{

    @ApiModelProperty(value = "元宝")
    private BigDecimal yuanBao;

    @ApiModelProperty(value = "金币")
    private BigDecimal gold;

    @ApiModelProperty(value = "现金")
    private BigDecimal price;

    @ApiModelProperty(value = "用户头像")
    private String picUrl;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "是否同意0:是1:否")
    private Integer button;
}
