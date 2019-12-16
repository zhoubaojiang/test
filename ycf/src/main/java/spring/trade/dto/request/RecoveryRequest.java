package spring.trade.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import spring.goods.dto.request.PageBeanUtile;

@Data
public class RecoveryRequest extends PageBeanUtile {
    @ApiModelProperty("用户ID")
    private Long memberId;

    @ApiModelProperty("0:提交回收订单—>1:待确认—>2:已报价—>3:确认回收价格—>4:上门验收—>5:已验收—>6:完成")
    private Integer orderState;
}
