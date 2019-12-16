package spring.trade.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import spring.goods.dto.request.PageBeanUtile;
@Data
public class AdminRecoveryRequest extends PageBeanUtile {

    @ApiModelProperty("提交回收订单—>0:待确认—>1:已报价—>2确认回收价格—>3:上门验收—>4:已验收—>5:完成->6取消->7拒绝")
    private Integer orderState;

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("用户姓名")
    private String memberName;

    @ApiModelProperty("商品品相：0全新，1优良，2普通，3轻度磨损，4不合格")
    private Integer goodsCondition;

    @ApiModelProperty("开始时间")
    private Long startTime;

    @ApiModelProperty("结束时间")
    private Long endTime;
}
