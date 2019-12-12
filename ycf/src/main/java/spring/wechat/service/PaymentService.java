package spring.wechat.service;

import java.math.BigDecimal;
import java.util.Map;

public interface PaymentService {

    Map<String,Object> xcxPayment(String orderNo, BigDecimal money, String openId,String orderState) throws Exception;

    int xcxNotify(Map<String, Object> map) throws Exception;
}
