package spring.mapper.cvs;


import spring.trade.dto.request.AdminOrderReq;
import spring.trade.dto.result.AdminTradeResult;

import java.util.List;

public interface TradeAdminMapper {

    List<AdminTradeResult> selectOrderList(AdminOrderReq request);
}