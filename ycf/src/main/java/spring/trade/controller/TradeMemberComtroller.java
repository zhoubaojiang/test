package spring.trade.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.dto.BaseCommonResult;
import spring.dto.request.RecoveryOrderRequest;
import spring.dto.result.BasePage;
import spring.model.MRecoveryGoods;
import spring.model.POrders;
import spring.model.UUserMember;
import spring.trade.dto.request.MemberOrderReq;
import spring.trade.dto.request.OrdersRes;
import spring.trade.dto.request.RecoveryRequest;
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
     * @param request
     * @return
     */
    @ApiOperation(value = "创建订单", httpMethod = "POST")
    @RequestMapping(value = "/create/order", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public BaseCommonResult<POrders> createOrder(@Validated @RequestBody OrdersRes request) {
        return pOrderService.createOrder(request);
    }

    @ApiOperation(value = "取消订单", httpMethod = "GET")
    @RequestMapping(value = "/delete/order/{orderNo}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public BaseCommonResult deleteOrder(@PathVariable Long orderNo) {
        return pOrderService.deleteOrder(orderNo);
    }


    /**
     *
     * 功能描述:添加回收物品
     * @param request
     * @return
     */
    @ApiOperation(value = "会员回收", httpMethod = "POST")
    @RequestMapping(value = "/recovery/order", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public BaseCommonResult<MRecoveryGoods> recoveryOrder(@Validated @RequestBody RecoveryOrderRequest request) {
        return pOrderService.recoveryOrder(request);
    }

    /**
     *
     * 功能描述:添加回收物品
     * @param request
     * @return
     */
    @ApiOperation(value = "会员回收", httpMethod = "POST")
    @RequestMapping(value = "/recovery/orderList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public BaseCommonResult<BasePage<MRecoveryGoods>> recoveryOrderList(@Validated @RequestBody RecoveryRequest request) {
        return pOrderService.recoveryOrderList(request);
    }

    @ApiOperation(value = "回收订单详情", httpMethod = "GET")
    @RequestMapping(value = "/recovery/order/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public BaseCommonResult getRecoveryOrder(@PathVariable Long id) {
        return pOrderService.getRecoveryOrder(id);
    }
}
