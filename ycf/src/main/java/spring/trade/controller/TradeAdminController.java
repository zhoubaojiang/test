package spring.trade.controller;

import spring.dto.BaseCommonResult;
import spring.dto.result.BasePage;
import spring.trade.dto.request.AdminOrderReq;
import spring.trade.dto.result.AdminTradeDetailsResult;
import spring.trade.dto.result.AdminTradeResult;
import spring.trade.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(description = "订单相关接口列表", basePath = "/goods")
@RestController
@RequestMapping("/ordersCenter/admin/orders")
public class TradeAdminController {

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
    public BaseCommonResult<BasePage<AdminTradeResult>> getAdminOrder(@Validated @RequestBody AdminOrderReq request) {
        return pOrderService.getAdminOrder(request);
    }

    /**
     *
     * 功能描述:查询会员订单
     * @param orderId
     * @return
     */
    @ApiOperation(value = "订单详情", httpMethod = "GET")
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public BaseCommonResult<AdminTradeDetailsResult> getAdminOrderDetails(@PathVariable Long orderId) {
        return pOrderService.getAdminOrderDetails(orderId);
    }

}
