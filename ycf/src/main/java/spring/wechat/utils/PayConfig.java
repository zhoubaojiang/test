package spring.wechat.utils;


/**
 * Function: 支付配置 <br/>
 * date: 2018-01-18 <br/>
 *
 * @author att
 * @version 1.0
 * @since JDK1.8
 */
public class PayConfig {

    //JSAPI--公众号支付-小程序支付
    public static final String TRADE_TYPE_JSAPI = "JSAPI";

    public static String XCX_KEY;

    //微信支付API
    public static final String WX_PAY_UNIFIED_ORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    public static final String PRO_SERVER_DOMAIN = "http://127.0.0.1:8080/pay/unifiedorder";


}