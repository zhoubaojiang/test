package spring.mapper.cvs;


import spring.model.MRecoveryGoods;
import spring.trade.dto.request.AdminOrderReq;
import spring.trade.dto.request.AdminRecoveryRequest;
import spring.trade.dto.request.MemberOrderReq;
import spring.trade.dto.result.*;

import java.util.List;

public interface TradeAdminMapper {

    List<AdminTradeResult> selectOrderList(AdminOrderReq request);

    AdminTradeDetailsResult selectAdminOrderDetails(Long orderId);

    List<OrderGoodsListResult> selectOrderGoodsListResult(Long orderId);

    List<MRecoveryGoods> selectAdminRecoveryOrderList(AdminRecoveryRequest request);

    List<POrdersResult> selectMemberOrderList(Long id);

    List<POrdersListResult> selectMemberTradeList(MemberOrderReq request);
}