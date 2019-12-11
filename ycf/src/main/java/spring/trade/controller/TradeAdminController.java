package spring.trade.controller;

import spring.dto.BaseCommonResult;
import spring.model.POrders;
import spring.trade.dto.request.OrdersRes;
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
     * 功能描述:商品列表
     * @author: xiongkun
     * @date: 2017年11月27日 下午4:36:51
     * @param request
     * @return
     */
    @ApiOperation(value = "创建订单", httpMethod = "POST")
    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public BaseCommonResult<POrders> createOrder(@Validated @RequestBody OrdersRes request) {
        return pOrderService.createOrder(request);
    }



}
