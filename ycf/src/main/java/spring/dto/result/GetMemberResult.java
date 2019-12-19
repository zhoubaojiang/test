package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GetMemberResult {
    @ApiModelProperty("来源名称")
    private String name;

    @ApiModelProperty("金额")
    private BigDecimal price;

    @ApiModelProperty("时间")
    private Date createTime;

    @ApiModelProperty(value = "1:收益,2扣除")
    private Integer type;

}
