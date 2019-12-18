package spring.wechat.service.impl;

import spring.exception.GoodsException;
import spring.goods.service.GoodsService;
import spring.mapper.cvs.GoodsMapper;
import spring.wechat.commom.*;
import spring.wechat.config.*;
import spring.wechat.dto.result.PayOrderGoodsNumRes;
import spring.wechat.service.PaymentService;
import spring.wechat.utils.BeanUtil;
import spring.wechat.utils.HttpUtils;
import spring.wechat.utils.PayUtil;
import spring.wechat.utils.WechatMsgUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    private static Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
    @Autowired
    private WechatProperty wechatProperty;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsService goodsService;

    @Override
    public Map<String, Object> xcxPayment(String orderNum, BigDecimal money, String openId,String orderState) throws Exception {
        LOGGER.info("【小程序支付】 统一下单开始, 订单编号="+orderNum);
        SortedMap<String, Object> resultMap = new TreeMap<String, Object>();
        //生成支付金额，开发环境处理支付金额数到0.01、0.02、0.03元
        //添加或更新支付记录(参数跟进自己业务需求添加)
        int flag = 0;
        try{
            flag = this.addOrUpdatePaymentRecord(orderNum, money,orderState);
        }catch (GoodsException e){
            resultMap.put("code", e.getResponseCode());
            resultMap.put("msg", e.getMessage());
        }
        if(flag == 0){
            resultMap.put("returnCode", "FAIL");
            resultMap.put("returnMsg", "此订单已支付！");
            LOGGER.info("【小程序支付】 此订单已支付！");
        }else if(flag == 1){
            resultMap.put("returnCode", "FAIL");
            resultMap.put("returnMsg", "支付记录生成或更新失败！");
            LOGGER.info("【小程序支付】 支付记录生成或更新失败！");
        }else{
            //生成微信支付
            Map<String,Object> resMap = this.xcxUnifieldOrder(orderNum, PayConfig.TRADE_TYPE_JSAPI, money,openId);
            if(PayConstant.SUCCESS.equals(resMap.get("return_code")) && PayConstant.SUCCESS.equals(resMap.get("result_code"))){
                resultMap.put("appId", wechatProperty.getAppId());
                resultMap.put("timeStamp", PayUtil.getCurrentTimeStamp());
                resultMap.put("nonceStr", PayUtil.makeUUID(32));
                resultMap.put("package", "prepay_id="+resMap.get("prepay_id"));
                resultMap.put("signType", "MD5");
                resultMap.put("sign", WechatMsgUtil.getSignKey(resultMap, wechatProperty.getMchKey(), "UTF-8"));
                resultMap.put("returnCode", "SUCCESS");
                resultMap.put("returnMsg", "OK");
                LOGGER.info("【小程序支付】统一下单成功，返回参数:"+resultMap);
                goodsService.updateGoodsNnumType(orderNum);
            }else{
                resultMap.put("returnCode", resMap.get("return_code"));
                resultMap.put("returnMsg", resMap.get("return_msg"));
                LOGGER.info("【小程序支付】统一下单失败，失败原因:"+resMap.get("return_msg"));
            }
        }

        return resultMap;
    }

    /**
     * 小程序支付统一下单
     */
    private Map<String,Object> xcxUnifieldOrder(String orderNum,String tradeType, BigDecimal payAmount,String openid) throws Exception{
        //封装参数
        SortedMap<String,Object> paramMap = new TreeMap<String,Object>();
        paramMap.put("appid", wechatProperty.getAppId());
        paramMap.put("mch_id", wechatProperty.getMchId());
        paramMap.put("nonce_str", WechatMsgUtil.getNonceStr());
        paramMap.put("body", BaseConstants.PLATFORM_COMPANY_NAME);
        paramMap.put("out_trade_no", orderNum);
        paramMap.put("total_fee", PayUtil.moneyToIntegerStr(payAmount));
        paramMap.put("spbill_create_ip", PayUtil.getLocalIp());
        paramMap.put("notify_url", this.getNotifyUrl());
        paramMap.put("trade_type", tradeType);
        paramMap.put("openid",openid);
        String sign = WechatMsgUtil.getSignKey(paramMap, wechatProperty.getMchKey(), "UTF-8");
//        paramMap.put("sign", PayUtil.createSign(paramMap,wechatProperty.getMchKey()));
        paramMap.put("sign", sign);
        //请求微信后台，获取预支付ID
        String xmlData = WechatMsgUtil.Map2XML(paramMap, true);
        String resXml = HttpUtils.queryJsonData(PayConfig.WX_PAY_UNIFIED_ORDER, xmlData);
        LOGGER.info("【小程序支付】 统一下单响应：\n"+resXml);
        return BeanUtil.xmlToMap(resXml);
    }


    private String getNotifyUrl(){
        //服务域名
        return PayConfig.PRO_SERVER_DOMAIN + "/payment/xcxNotify";
    }

    /**
     * 添加或更新支付记录
     */
    public int addOrUpdatePaymentRecord(String orderNo, BigDecimal payAmount,String orderState) {
        //订单状态:0待支付,1支付成功,2支付失败,3待发货,4已发货,5确认收货,6订单完成,7申请退款,8退款中,9退款完成,10拒绝退款,11取消订单,12订单关闭
        int[] orderStateList = {1,3,4,5,6,7,8,9,10,11,12};
        if ( ArrayUtils.contains(orderStateList,Integer.parseInt(orderState))){
            return 0;//此订单已支付
        }
        List<PayOrderGoodsNumRes> payOrderGoodsNumRes = goodsMapper.selectOrderGoodsNum(orderNo);
        for (PayOrderGoodsNumRes payOrderGoodsNumRes1 :payOrderGoodsNumRes) {
            if (payOrderGoodsNumRes1.getGoodsNumType()==0){//已售出
                throw  new GoodsException(99999,"此商品"+payOrderGoodsNumRes1.getGoodsName()+"已售出");
            }
        }
        return 2;
    }

    @Override
    @Transactional(readOnly=false,rollbackFor={Exception.class})
    public int xcxNotify(Map<String,Object> map) throws Exception{
        int flag = 0;
        //支付订单编号
        String orderNo = (String)map.get("out_trade_no");
        //检验是否需要再次回调刷新数据
        //TODO 微信后台回调，刷新订单支付状态等相关业务

        return flag;
    }
    /**
     * 统一下单接口
     * @return
     * @throws Exception
     */
//    public Map<String, Object> unifiedorder(Map<String, Object> request) throws Exception {
//        String reqXml = getRequestString(request);
//
//        String resXml = this.post("https://api.mch.weixin.qq.com/pay/unifiedorder", reqXml);
//
//        return BeanUtil.xmlToMap(resXml);
//    }

    public String post(String url, String xmlParam) {

        HttpRequest request = HttpRequest.post(url).body(xmlParam);

        String responseString = this.getResponseString(request.send());

       log.info("\n【请求地址】: {}\n【请求参数】：{}\n【响应数据】：{}", url, xmlParam, responseString);

        return responseString;
    }

    private String getResponseString(HttpResponse response) {
        this.log.debug("【微信服务器响应头信息】：\n{}", response.toString(false));

        String responseString = response.bodyText();

        if (StringUtils.isBlank(response.charset())) {
            try {
                responseString = new String(response.bodyText().getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return responseString;
    }




}