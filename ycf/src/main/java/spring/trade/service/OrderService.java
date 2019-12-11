package spring.trade.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Transient;
import spring.dto.BaseCommonResult;
import spring.dto.result.BasePage;
import spring.exception.GoodsException;
import spring.mapper.PGoodsMapper;
import spring.mapper.POrdersDetailsMapper;
import spring.mapper.POrdersMapper;
import spring.mapper.UMemberReceiveAddressMapper;
import spring.mapper.cvs.TradeAdminMapper;
import spring.model.*;
import spring.trade.dto.request.AdminOrderReq;
import spring.trade.dto.request.MemberOrderReq;
import spring.trade.dto.request.OrdersRes;
import spring.trade.dto.result.AdminTradeDetailsResult;
import spring.trade.dto.result.AdminTradeResult;
import spring.trade.dto.result.OrderGoodsListResult;
import spring.utils.DateUtil;
import spring.utils.ResultBuilder;
import spring.wechat.dto.requset.PayReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OrderService  {
    @Autowired
    private PGoodsMapper pGoodsMapper;
    @Autowired
    private POrdersMapper pOrdersMapper;
    @Autowired
    private UMemberReceiveAddressMapper memberReceiveAddressMapper;
    @Autowired
    private POrdersDetailsMapper pOrdersDetailsMapper;
    @Autowired
    private TradeAdminMapper tradeAdminMapper;
    /**
     * 创建订单
     * @param ordersRes
     * @return
     */
    @Transient
    public BaseCommonResult<POrders> createOrder(OrdersRes ordersRes) {
        PGoods goods = pGoodsMapper.selectByPrimaryKey(ordersRes.getGoodsId());
        if (goods == null){
            return  ResultBuilder.fail("查无此商品");
        }
        UMemberReceiveAddressExample example = new UMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(ordersRes.getGoodsId()).andDefaultStatusEqualTo(0);
        List<UMemberReceiveAddress> memberReceiveAddresses = memberReceiveAddressMapper.selectByExample(example);
        if (memberReceiveAddresses.size()<0){
            return  ResultBuilder.fail("请添加收货地址");
        }
        UMemberReceiveAddress memberReceiveAddress = memberReceiveAddresses.get(0);
        POrders pOreders = new POrders();
        pOreders.setUserId(ordersRes.getUserId());
        pOreders.setCreateTime(new Date());
        pOreders.setGoodsNum(1);
        pOreders.setTotalPrice(goods.getGoodsPrice());
        pOreders.setOrderNo(DateUtil.getOrderNumber());
        if(ordersRes.getOrderType()==0){//支付方式;0现金，1鱿费
            pOreders.setTotalPrice(goods.getGoodsPrice());
        }else {
            pOreders.setOrderPrice(goods.getTreasureDiscountPrice());
        }
        //订单
        pOreders.setOrderState("0");
        pOreders.setReceivedName(memberReceiveAddress.getName());
        pOreders.setPhone(memberReceiveAddress.getPhone());
        pOreders.setProvince(memberReceiveAddress.getProvince());
        pOreders.setCity(memberReceiveAddress.getCity());
        pOreders.setArea(memberReceiveAddress.getArea());
        pOreders.setAddress(memberReceiveAddress.getDetailAddress());
        int i = pOrdersMapper.insertSelective(pOreders);
        //订单明细
        POrdersDetails pOredersDetails = new POrdersDetails();
        pOredersDetails.setOrderNo(pOreders.getId());
        pOredersDetails.setGoodsId(ordersRes.getGoodsId());
        pOredersDetails.setGoodsPrice(goods.getGoodsPrice());//商品原价
        pOredersDetails.setGoodsName(goods.getGoodsName());
        pOredersDetails.setGoodsNum(1);
        pOredersDetails.setGoodsCondition(goods.getGoodsCondition());//商品品相
        if(ordersRes.getOrderType()==0){//支付方式;0现金，1鱿费
            pOredersDetails.setDiscountPrice(goods.getDiscountPrice());
            pOredersDetails.setOrderPrice(goods.getDiscountPrice());
        }else {
            pOredersDetails.setYouPricce(goods.getTreasureDiscountPrice());
            pOredersDetails.setOrderPrice(goods.getDiscountPrice());
        }
        pOredersDetails.setGoodsPicture(goods.getMasterGraph());//商品主图
        pOrdersDetailsMapper.insertSelective(pOredersDetails);

        return ResultBuilder.success(pOreders);
    }


    public POrders getOrder(PayReq req) {
        POrders pOrders = pOrdersMapper.selectByPrimaryKey(req.getOrderNo());
        return pOrders;
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @param i
     */
    @Transient
    public void updateOrder(POrders orderInfo, String i) {
        POrders record = new POrders();
        record.setId(orderInfo.getId());
        record.setOrderState(i);
        pOrdersMapper.updateByPrimaryKeySelective( record);
    }

    public BaseCommonResult<BasePage<POrders>> getMemberOrder(MemberOrderReq request) {
        BasePage<POrders> pageResult = new BasePage();
        log.info("会员订单分页查询商品列表,请求参数为：{}", request);
        try {
            PageHelper.startPage(request.getPage(), request.getPageSize());
            POrdersExample example = new POrdersExample();
            POrdersExample.Criteria criteria = example.createCriteria();
            if(request.getOrderState()!=null){
                criteria.andOrderStateEqualTo(request.getOrderState());
            }
            criteria.andUserIdEqualTo(request.getUserId());
            example.setOrderByClause("create_time desc");
            List<POrders> list = pOrdersMapper.selectByExample(example);
            PageInfo<POrders> pageInfo = new PageInfo<>(list);
            pageResult.setList(list);
            pageResult.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal());
        }catch (GoodsException e) {
            log.info("会员订单分页查询商品列表异常，异常信息为：{}", e);
            ResultBuilder.fail("系统异常");
        }
        log.info("会员订单分页查询商品列表接口结束");
        return ResultBuilder.success(pageResult);
    }

    /**
     * 后台管理查询订单
     * @param request
     * @return
     */
    public BaseCommonResult<BasePage<AdminTradeResult>> getAdminOrder(AdminOrderReq request) {
        BasePage<AdminTradeResult> pageResult = new BasePage();
        log.info("后台管理订单分页查询商品列表,请求参数为：{}", request);
        try {
            PageHelper.startPage(request.getPage(), request.getPageSize());
            List<AdminTradeResult> list = tradeAdminMapper.selectOrderList(request);
            PageInfo<AdminTradeResult> pageInfo = new PageInfo<>(list);
            pageResult.setList(list);
            pageResult.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal());
        }catch (GoodsException e) {
            log.info("后台管理订单分页查询商品列表异常，异常信息为：{}", e);
            ResultBuilder.fail("系统异常");
        }
        log.info("后台管理订单分页查询商品列表接口结束");
        return ResultBuilder.success(pageResult);
    }

    /**
     * 管理后台订单详情
     * @param orderId
     * @return
     */
    public BaseCommonResult<AdminTradeDetailsResult> getAdminOrderDetails(Long orderId) {
        AdminTradeDetailsResult adminTradeDetailsResult = tradeAdminMapper.selectAdminOrderDetails(orderId);
        List<OrderGoodsListResult> orderGoodsListResults = tradeAdminMapper.selectOrderGoodsListResult(orderId);
        adminTradeDetailsResult.setOrderGoodsListResults(orderGoodsListResults);
        return ResultBuilder.success(adminTradeDetailsResult);
    }
}
