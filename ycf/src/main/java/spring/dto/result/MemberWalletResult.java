package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class MemberWalletResult {
    @ApiModelProperty(value = "鱿费")
    private BigDecimal yuanBao;

    @ApiModelProperty(value = "鱿费累计收益")
    private BigDecimal youPrice;

    @ApiModelProperty(value = "现金")
    private BigDecimal price;

    List<GetMemberResult> getMemberResults = new ArrayList<>();
}
