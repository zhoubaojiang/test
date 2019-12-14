package spring.trade.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.dto.BaseCommonResult;
import spring.dto.result.BasePage;
import spring.model.POrders;
import spring.model.UUserMember;
import spring.trade.dto.request.MemberOrderReq;
import spring.trade.dto.request.OrdersRes;
import spring.trade.service.OrderService;

@Api(description = "会员订单相关接口列表", basePath = "/ordersCenter/member/orders")
@RestController
@RequestMapping("/ordersCenter/member/orders")
public class TradeMemberComtroller {

    @Autowired
    private OrderService pOrderService;
    /**
     *
     * 功能描述:查询会员订单
     * @param request
     * @return
     */
    @ApiOperation(value = "查询会员订单", httpMethod = "POST")
    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public BaseCommonResult<BasePage<POrders>> getMemberOrder(@Validated @RequestBody MemberOrderReq request) {
        return pOrderService.getMemberOrder(request);
    }

    /**
     *
     * 功能描述:商品列表
     * @author: xiongkun
     * @date: 2017年11月27日 下午4:36:51
     * @param request
     * @return
     */
    @ApiOperation(value = "创建订单", httpMethod = "POST")
    @RequestMapping(value = "/create/order", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public BaseCommonResult<POrders> createOrder(@Validated @RequestBody OrdersRes request) {
        return pOrderService.createOrder(request);
    }

}
