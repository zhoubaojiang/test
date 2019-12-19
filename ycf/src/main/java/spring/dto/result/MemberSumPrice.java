package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberSumPrice {
    @ApiModelProperty(value = "鱿费")
    private BigDecimal price;
}
