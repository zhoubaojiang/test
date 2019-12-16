package spring.mapper.cvs;


import spring.model.MRecoveryGoods;
import spring.trade.dto.request.AdminOrderReq;
import spring.trade.dto.request.AdminRecoveryRequest;
import spring.trade.dto.result.AdminTradeDetailsResult;
import spring.trade.dto.result.AdminTradeResult;
import spring.trade.dto.result.OrderGoodsListResult;

import java.util.List;

public interface TradeAdminMapper {

    List<AdminTradeResult> selectOrderList(AdminOrderReq request);

    AdminTradeDetailsResult selectAdminOrderDetails(Long orderId);

    List<OrderGoodsListResult> selectOrderGoodsListResult(Long orderId);

    List<MRecoveryGoods> selectAdminRecoveryOrderList(AdminRecoveryRequest request);
}