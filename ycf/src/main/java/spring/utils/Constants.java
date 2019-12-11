package spring.utils;
public class Constants {
  
  
  /**常量int类型0**/
  public static final int CONSTANT_ZERO_INT = 0;
	/**常量int类型1**/
	public static final int CONSTANT_INT_ONE = 1;
	/**常量int类型0 **/
	public static final int CONSTANT_INT_ZERO = 0;
	/**常量int类型2  **/
	public static final int CONSTANT_INT_TWO = 2;
	/**常量int类型2  **/
	public static final int CONSTANT_INT_FIVE = 5;
	/** 常量int类型11 **/
	public static final int CONSTANT_INT_ELEVEN = 11;
	/** 常量int类型100 **/
	public static final  int CONSTANT_INT_HUNDRED = 100;

	/** 常量字符串类型1 **/
	public static final String CONSTANT_STR_ONE = "1";
	/** 常量字符串类型2**/
	public static final String CONSTANT_STR_TWO = "2";
	/** 常量字符串类型3**/
	public static final String CONSTANT_STR_THREE = "3";
	/**常量Long类型0L **/
	public static final Long CONSTANT_LONG_ZERO = Long.valueOf(0L);
	/**常量Long类型1L **/
	public static final Long CONSTANT_LONG_ONE = 1L;
	/**常量Long类型300000L **/
	public static final Long CONSTANT_FIVEMINUTE = 5*60*1000L;
	/**缓存过期时间一个月**/
	public static final int REDIS_ONEMONTH = 60*60*24*30 ;
	/**缓存过期时间一天**/
	public static final int REDIS_ONEDAY = 60*60*24 ;
	/**缓存过期时间半天**/
	public static final int REDIS_HALFDAY = 60*60*12;
	/**缓存过期时间十天**/
	public static final int REDIS_TENDAY = 60*60*24*10;
	/**缓存过期时间十分钟**/
	public static final int REDIS_TENMINUTE = 60*10;
	/**缓存过期时间三小时**/
	public static final int REDIS_THREEHOUR = 60*60*3;
	/**缓存过期时间一小时**/
	public static final int REDIS_ONEHOUR = 60*60;
	/**缓存过期时间半小时**/
	public static final int REDIS_HALFHOUR = 60*30;
	/**缓存过期时间3秒**/
	public static final int REDIS_THREESECOND = 3;
	/**缓存过期时间半分钟**/
	public static final int REDIS_HALFMINUTE = 30;
	/** 缓存过期时间一分钟 */
	public static final int REDIS_ONEMINUTE = 60;
	/**缓存过期时间90秒**/
	public static final int REDIS_NINETY = 90;
	/** 3000毫秒 */
	public static final int REDIS_THREE_THOUSAND = 3000;

	/**无效的int**/
	public static final int CONSTANT_INT_INVALID = -1;
	
	/**编码字符集常量**/
	public static final String ENCODE_UTF8 = "UTF-8";
	public static final String ENCODE_GBK = "GBK";
	public static final String ENCODE_GB2312 = "GB2312";
	public static final String ENCODE_ISO8859_1 = "ISO-8859-1";
	
	/**常用的Content-Type**/
	public static final String CONTENT_TYPE_TEXT_UTF8 = "text/html;charset=UTF-8";
	
	public static final String SEPARATOR_COMMA=",";
	
	/**列表分页默认值:1 **/
	public static final Integer DEFAULT_PAGE = 1; // 页数 
	/**列表分页条数默认值:20 **/
	public static final Integer DEFAULT_PAGE_SIZE = 20;// 行数
	/**分页参数名称常量 当前显示第几页，默认：1*/
	public static final String PAGE_PARAMETER_PAGE_NAME = "page";
	/**分页参数名称常量 每页显示记录结果数，默认查询记录：20条*/
	public static final String PAGE_PARAMETER_PAGESIZE_NAME = "pageSize";
	/**分页参数名称常量 查询数据结果分页总页数*/
	public static final String PAGE_PARAMETER_PAGECOUNT_NAME = "pageCount";
	/**分页参数名称常量 查询数据结果订单总条数*/
	public static final String PAGE_PARAMETER_LISTCOUNT_NAME = "listCount";
	
	/**请求ID**/
	public static final String FRONT_REQUEST_ID = "requestId"; //前端请求ID
	public static final String BACK_REQUEST_ID = "backRequestId"; //后端请求ID
	
	/** OSS的STS凭证过期时间*/
	public static final long MEMBER_OSS_STS_OVERTIME = 3600L;
	
	/**
	 * 用户redis前缀
    */
	public static final String USER_REDIS_PREFIX = "user";
	
	/***请求header参数**/
	public static final String HEADER_TOKEN = "token";
	public static final String HEADER_TIMESTAMP = "timestamp";
	public static final String HEADER_REQUESTID = "requestid";
	public static final String HEADER_LOGINID = "loginid";
	public static final String HEADER_SIGN = "sign";
	public static final String HEADER_CHANNELID = "channelid";  //ios android pc 
	public static final String HEADER_USER_TYPE = "usertype";  //backend  agent  member  supplier	
	public static final String HEADER_USER_TYPE_IS_SIGN = "userTypeIsSign";  //user是否参与签名   0：表示不参与， java自己使用，前端不要传，用于兼容性
	
	/**请求头是否需要参数**/
	public static final String USER_TYPE_IS_SIGN_ZERO = "0";
	
	/**请求来源**/
	public static final String CHANNELID_IOS = "ios"; 
	public static final String CHANNELID_ANDROID = "android";  
	public static final String CHANNELID_PC = "pc"; 
	public static final String CHANNELID_APP = "app"; 
	public static final String CHANNELID_H5 = "h5";
	public static final String CHANNELID_PHP = "php";
	public static final String CHANNELID_XCX = "xiaochenxu";

	/**请求用户类型*/
	public static final String USER_TYPE_BACKEND = "backend";  //运营中心
	public static final String USER_TYPE_MEMBER = "member"; //会员
	public static final String USER_TYPE_SUPPLIER_STAFF = "supplierStaff";  //商家员工

	/**请求头参数key **/
	public static final String HEADER_PARAM = "headerParam";
	public static final String ACCESS_BASE_CHECK = "accessBaseCheck";
	//会员存放redis中参数
	public static final String REDIS_MEMVER_TOKEN = "token";
	public static final String REDIS_MEMVER_USER_ID = "userId";
	public static final String REDIS_MEMVER_USER_ACCOUNT = "userAccount";
	public static final String REDIS_MEMVER_LOGIN_ID = "loginId";
	//1.开启日志功能  0.关闭日志功能
	public static final String REDIS_SUPPORT_LOG_SWITCH = "supportLogSwith";
	// 锁
	public static final String REDIS_LOCK_COUPONDISCOUNT="coupon-"; //优惠卷锁
	public static final String REDIS_LOCK_USERSCORE="userscore-";   //用户积分锁
	public static final String REDIS_LOCK_SKU="sku-";			    // 商品库存锁
	public static final String REDIS_LOCK_CANCEL_ORDER = "cancel-";	// 取消订单锁
	public static final String REDIS_LOCK_DELIVERY_GOODS = "deliveryGoods-";	// 确认收货
	public static final String REDIS_LOCK_REFUND_APPLY = "refund-";				// 退款退货申请
	public static final String REDIS_LOCK_REFUND_AUDIT = "refundAudit-";		// 退款退货审核
	public static final String REDIS_LOCK_SALE_STOCK="sstock_%s_%s_%s";// 活动商品库存锁 sstock_saleType_saleId_skuNumber

	public static String redisLockSku(String skuNumber){ return REDIS_LOCK_SKU+skuNumber; }
	public static String redisLockSaleStock(int saleType,int saleId,String skuNumber){
		return String.format(REDIS_LOCK_SALE_STOCK,saleType,saleId, skuNumber);}
    //会员资金流水明细类型
	public static final String BEAN_DETAIL_TYPE_RECHARGE = "recharge";                                    // 充值
	public static final String BEAN_DETAIL_TYPE_ORDER_GENERATE = "order_generate";                        // 下单(抵扣)
	public static final String BEAN_DETAIL_TYPE_ORDER_FAIL = "order_fail";                                // 下单失败(抵扣返还)
	public static final String BEAN_DETAIL_TYPE_ORDER_CLOSE = "order_close";                              // 订单关闭(抵扣退还)
	public static final String BEAN_DETAIL_TYPE_ORDER_CANCEL = "order_cancel";                            // 订单取消(抵扣退还)
	public static final String BEAN_DETAIL_TYPE_ORDER_TIMEOUT = "order_timeout";                          // 订单超时(抵扣退还)
	public static final String BEAN_DETAIL_TYPE_ORDER_REFUND = "order_refund";                            // 订单退款(抵扣退还)
	public static final String BEAN_DETAIL_TYPE_ORDER_PROFIT_FREEZE = "order_profit_freeze";              // 订单分润(冻结)
	public static final String BEAN_DETAIL_TYPE_ORDER_PROFIT_REFUND = "order_profit_refund";              // 订单分润(退还)
	public static final String BEAN_DETAIL_TYPE_ORDER_PROFIT_FINISH = "order_profit_finish";              // 订单分润(解冻)
	public static final String BEAN_DETAIL_TYPE_HOTEL_ORDER_PROFIT_FREEZE = "hotel_order_profit_freeze";   // 公寓订单分润(冻结)
	public static final String BEAN_DETAIL_TYPE_HOTEL_ORDER_PROFIT_REFUND = "hotel_order_profit_refund";  // 公寓订单分润(退还)
	public static final String BEAN_DETAIL_TYPE_HOTEL_ORDER_PROFIT_FINISH = "hotel_order_profit_finish";   // 公寓订单分润(解冻)
	public static final String BEAN_DETAIL_TYPE_EVALUATE_FREEZE = "order_evaluate_freeze";                // 评价(冻结)
	public static final String BEAN_DETAIL_TYPE_EVALUATE_REFUND = "order_evaluate_refund";                // 评价(退还)
	public static final String BEAN_DETAIL_TYPE_EVALUATE_FINISH = "order_evaluate_finish";                // 评价(解冻)
	public static final String BEAN_DETAIL_TYPE_OFFLINE_ORDER_PAY = "offline_order_pay";                  // 线下扫码订单支付(抵扣)
	public static final String BEAN_DETAIL_TYPE_OFFLINE_PROFIT_FREEZE = "offline_order_profit_freeze";    // 线下扫码订单分润(冻结)
	public static final String BEAN_DETAIL_TYPE_OFFLINE_PROFIT_FINISH = "offline_order_profit_finish";    // 线下扫码订单分润(解冻)
	public static final String BEAN_DETAIL_TYPE_OFFLINE_EVALUATE_FREEZE = "offline_order_evaluate_freeze";// 线下扫码订单评价(冻结)
	public static final String BEAN_DETAIL_TYPE_OFFLINE_EVALUATE_FINISH = "offline_order_evaluate_finish";// 线下扫码订单评价(冻结)
	public static final String BEAN_DETAIL_TYPE_TRANSFER_OUT = "transfer_out";                            // 转账(转出)
	public static final String BEAN_DETAIL_TYPE_TRANSFER_IN = "transfer_in";                              // 转账(转入)
	public static final String BEAN_DETAIL_TYPE_HC_TRANSFER_IN = "hc_transfer_in";                              // 代理康养卡账户转账(转入)
	public static final String BEAN_DETAIL_TYPE_SIGN_IN = "sign_in";                                      // 签到奖励
	public static final String BEAN_DETAIL_TYPE_LUCKY_DRAW = "lucky_draw";                                // 抽奖奖励
	public static final String BEAN_DETAIL_TYPE_REPAIR_SIGN = "repair_sign";                              // 补签
	public static final String BEAN_DETAIL_TYPE_WITHDRAW_FUND_APPLY = "withdraw_funds_apply";             // 提现(申请)
	public static final String BEAN_DETAIL_TYPE_WITHDRAW_FUND_FAIL = "withdraw_funds_fail";               // 提现(失败)
	public static final String BEAN_DETAIL_TYPE_WITHDRAW_FUND_SUCCESS = "withdraw_funds_success";         // 提现(成功)
	public static final String BEAN_DETAIL_TYPE_WITHDRAW_SERVICE_CHARGE = "withdraw_service_charge";         // 提现(成功)
	public static final String BEAN_DETAIL_TYPE_MEMBER_REGISTER = "member_register";                      // 会员注册
    public static final String BEAN_DETAIL_TYPE_CARD_ACTIVE_PROFIT = "card_active_profit";                // 信用卡激活分润
    public static final String BEAN_DETAIL_TYPE_CARD_FIRST_BRUSH_PROFIT = "card_first_brush_profit";      // 信用卡首刷分润
	public static final String BEAN_DETAIL_TYPE_HEALTH_CARD_GIVE = "health_card_give";      // 康养卡赠送
	public static final String BEAN_DETAIL_TYPE_HEALTH_CARD_UPGRADE = "health_card_upgrade";      // 康养卡升级
	public static final String BEAN_DETAIL_TYPE_HEALTH_CARD_PROFIT = "health_card_profit";//康养卡分润
    public static final String HEALTH_CARD_USE_BALANCE = "health_card_use_balance";                       // 康养卡订单抵扣余额
    public static final String HEALTH_CARD_THAW_BALANCE = "health_card_thaw_balance";                     // 康养卡订单对账成功(解冻抵扣余额)

	//会员资金流水收支类型
	public static final Byte MEMBER_BEAN_INCOME_TYPE_IN = 1;  //收入
	public static final Byte MEMBER_BEAN_INCOME_TYPE_OUT = 2; //支出
	//会员资金流水平台类型
	public static final Byte MEMBER_BEAN_PLATFORM_TYPE_HQDASC = 1; //环球大爱商城
	public static final Byte MEMBER_BEAN_PLATFORM_TYPE_SXYSC = 2;  //商学院商城
	//会员资金冻结表操作类型
	public static final Byte MEMBER_BEAN_OPERATE_TYPE_IN_FREEZE = 1;    //冻结入账
	public static final Byte MEMBER_BEAN_OPERATE_TYPE_IN_RFUND = 2;     //冻结入账退还
	public static final Byte MEMBER_BEAN_OPERATE_TYPE_IN_UNFREEZE = 3;  //解冻入账
	public static final Byte MEMBER_BEAN_OPERATE_TYPE_OUT_FREEZE = 4;   //冻结出账
	public static final Byte MEMBER_BEAN_OPERATE_TYPE_OUT_RFUND = 5;    //冻结出账退还
	public static final Byte MEMBER_BEAN_OPERATE_TYPE_OUT_UNFREEZE = 6; //解冻出账
}
