package spring.wechat.controller;

import spring.dto.BaseCommonResult;
import spring.exception.GoodsException;
import spring.goods.common.GoodsApiCode;
import spring.model.POrders;
import spring.trade.service.OrderService;
import spring.utils.ResultBuilder;
import spring.wechat.dto.requset.PayReq;
import spring.wechat.service.PaymentService;
//import spring.wechat.service.WechatPayService;
import spring.wechat.service.WechatService;
import spring.wechat.utils.BeanToMap;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lly835.bestpay.model.PayResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Api(description = "微信管理", basePath = "/payment/")
@RestController
@RequestMapping(value = "/payment/")
public class PaymentController {
    private static Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private OrderService orderService;
//    @Autowired
//    private WechatPayService wechatPayService;

    @Autowired
    private WechatService wechatService;
    @ApiOperation(value = "获取微信唯一OPEN_ID", httpMethod = "GET")
    @RequestMapping(value ="/getOperatorIdOrderList/{code}",method = RequestMethod.GET)
    public String getOperatorIdOrderList(@PathVariable String code) throws Exception{
        logger.info("获取微信OPEN_ID请求参数:"+code);
        String operatorid = wechatService.getOpenid(code);
        logger.info("获取微信OPEN_ID返回参数:"+operatorid);
        return new ObjectMapper().writeValueAsString(operatorid);
    }

    /**
     * <p>统一下单入口</p>
     *
     * @throws Exception
     */
    @ApiOperation(value = "下单接口", httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value="toPay", method= RequestMethod.POST)
    public BaseCommonResult toPay(@RequestBody PayReq req) throws Exception {

        POrders orderInfo = orderService.getOrder(req);
        if(orderInfo == null){
            return ResultBuilder.fail("订单不存在！");
        }else if( Integer.parseInt(orderInfo.getOrderState()) > 0){
            //订单状态:0待支付,1支付中,2支付失败,3支付成功,4待发货,5已发货,6确认收货,7订单完成,8申请退款,9退款中,10退款完成,11拒绝退款,12取消订单
            return ResultBuilder.fail("订单已支付或者已取消!");
        }else{
            logger.info("【小程序支付服务】请求订单编号:["+orderInfo.getId()+"]");
            Map<String, Object> resMap = paymentService.xcxPayment(String.valueOf(orderInfo.getId()),orderInfo.getOrderPrice(),req.getOpenId());
            if("SUCCESS".equals(resMap.get("returnCode")) && "OK".equals(resMap.get("returnMsg"))){
                //统一下单成功
                resMap.remove("returnCode");
                resMap.remove("returnMsg");
                logger.info("【小程序支付服务】支付下单成功！");
                return ResultBuilder.success(resMap);
            }else{
                logger.info("【小程序支付服务】支付下单失败！原因:"+resMap.get("returnMsg"));
                Object returnMsg = resMap.get("returnMsg");
                return ResultBuilder.fail(returnMsg.toString());
            }
        }

    }


    /**
     * <p>回调Api</p>
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @ApiOperation(value = "支付回调接口")
    @RequestMapping(value="xcxNotify")
    public void xcxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream =  request.getInputStream();
        //获取请求输入流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len=inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        outputStream.close();
        inputStream.close();
        Map<String,Object> map = BeanToMap.getMapFromXML(new String(outputStream.toByteArray(),"utf-8"));
        logger.info("【小程序支付回调】 回调数据： \n"+map);
        String resXml = "";
        String returnCode = (String) map.get("return_code");
        String orderId = (String) map.get("order_id");
        if ("SUCCESS".equalsIgnoreCase(returnCode)) {
            String returnmsg = (String) map.get("result_code");
            if("SUCCESS".equals(returnmsg)){
                //更新数据
                int result = paymentService.xcxNotify(map);
                if(result > 0){
                    PayReq req = new PayReq();
                    req.setOrderNo(Long.parseLong(orderId));
                    POrders orderInfo = orderService.getOrder(req);
                    orderService.updateOrder(orderInfo,"3");
                    //支付成功
                    resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                            + "<return_msg><![CDATA[OK]]></return_msg>"+"</xml>";
                }
            }else{
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[报文为空]></return_msg>" + "</xml>";
                logger.info("支付失败:"+resXml);
            }
        }else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]></return_msg>" + "</xml>";
            logger.info("【订单支付失败】");
        }

        logger.info("【小程序支付回调响应】 响应内容：\n"+resXml);
        response.getWriter().print(resXml);
    }

}