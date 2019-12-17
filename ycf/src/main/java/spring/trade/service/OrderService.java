package spring.trade.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.data.annotation.Transient;
import spring.dto.BaseCommonResult;
import spring.dto.request.RecoveryOrderRequest;
import spring.dto.result.BasePage;
import spring.exception.GoodsException;
import spring.mapper.*;
import spring.mapper.cvs.TradeAdminMapper;
import spring.model.*;
import spring.trade.dto.request.*;
import spring.trade.dto.result.AdminTradeDetailsResult;
import spring.trade.dto.result.AdminTradeResult;
import spring.trade.dto.result.OrderGoodsListResult;
import spring.utils.DateUtil;
import spring.utils.ResultBuilder;
import spring.wechat.dto.requset.PayReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private MRecoveryGoodsMapper mRecoveryGoodsMapper;
    @Autowired
    private UUserMemberMapper uUserMemberMapper;
    @Autowired
    private DozerBeanMapper dozer;
    /**
     * 创建订单
     * @param ordersRes
     * @return
     */
    @Transient
    public BaseCommonResult<POrders> createOrder(OrdersRes ordersRes) {
        PGoodsExample goodsExample = new PGoodsExample();
        String[] split = ordersRes.getIds().split(",");
        for (String id:split) {
            goodsExample.createCriteria().andIdEqualTo(Long.parseLong(id)).andIsDeleteEqualTo(1).andGoodsNumTypeEqualTo(1);
            List<PGoods> goodsList = pGoodsMapper.selectByExample(goodsExample);
            if (goodsList.size() <= 0){
                return  ResultBuilder.fail("商品已售出");
            }
        }

        UMemberReceiveAddress memberReceiveAddress = memberReceiveAddressMapper.selectByPrimaryKey(ordersRes.getAddressId());
        POrders pOreders = new POrders();
        pOreders.setUserId(ordersRes.getUserId());
        pOreders.setCreateTime(new Date());
        pOreders.setGoodsNum(ordersRes.getGoodsNum());
        //生成订单号时间戳加随机数
        pOreders.setOrderNo(DateUtil.getOrderNumber());
        pOreders.setOrderType(ordersRes.getOrderType());
        //支付金额
        pOreders.setTotalPrice(ordersRes.getTotalPrice());
        pOreders.setOrderPrice(ordersRes.getOrderPrice());
        //订单
        pOreders.setOrderState("0");
        //收货人
        pOreders.setReceivedName(memberReceiveAddress.getName());
        pOreders.setPhone(memberReceiveAddress.getPhone());
        //设置收货地址
        pOreders.setProvince(memberReceiveAddress.getProvince());
        pOreders.setCity(memberReceiveAddress.getCity());
        pOreders.setArea(memberReceiveAddress.getArea());
        pOreders.setAddress(memberReceiveAddress.getDetailAddress());
        //省市区详细地址
        pOreders.setDetailedAddress(memberReceiveAddress.getProvince()+memberReceiveAddress.getCity()+memberReceiveAddress.getArea()+memberReceiveAddress.getDetailAddress());
        int i = pOrdersMapper.insertSelective(pOreders);

        for (String id:split) {
            PGoods goods = pGoodsMapper.selectByPrimaryKey(Long.parseLong(id));
            //订单明细
            POrdersDetails pOredersDetails = new POrdersDetails();
            pOredersDetails.setOrderNo(pOreders.getId());
            pOredersDetails.setGoodsId(goods.getId());
            pOredersDetails.setGoodsPrice(goods.getGoodsPrice());//商品原价
            pOredersDetails.setGoodsName(goods.getGoodsName());
            pOredersDetails.setGoodsNum(1);
            pOredersDetails.setGoodsCondition(goods.getGoodsCondition());//商品品相
            pOredersDetails.setOrderPrice(goods.getDiscountPrice());
            if(ordersRes.getOrderType()==0){//支付方式;0现金，1鱿费
                pOredersDetails.setDiscountPrice(goods.getDiscountPrice());
            }else {
                pOredersDetails.setYouPricce(goods.getTreasureDiscountPrice());
            }
            pOredersDetails.setGoodsPicture(goods.getMasterGraph());//商品主图
            pOrdersDetailsMapper.insertSelective(pOredersDetails);
        }
        return ResultBuilder.success(pOreders);
    }


    public List<POrders> getOrder(PayReq req) {
        POrdersExample example = new POrdersExample();
        example.createCriteria().andOrderNoEqualTo(req.getOrderNo());
        List<POrders> pOrders = pOrdersMapper.selectByExample(example);
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
            POrdersDetailsExample example = new POrdersDetailsExample();
            example.createCriteria().andOrderNoEqualTo(orderInfo.getId());
            List<POrdersDetails> pOrdersDetails = pOrdersDetailsMapper.selectByExample(example);
            for (POrdersDetails details:pOrdersDetails) {
                PGoods pGoods = pGoodsMapper.selectByPrimaryKey(details.getGoodsId());
                if (i.equals("1")){
                    pGoods.setGoodsNumType(0);
                }else {
                    pGoods.setGoodsNumType(1);
                }
                pGoodsMapper.updateByPrimaryKeySelective(pGoods);
            }
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

    /**
     * 取消订单
     * @param orderNo
     * @return
     */
    @Transient
    public BaseCommonResult deleteOrder(Long orderNo,Integer type) {

        POrders pOrders = pOrdersMapper.selectByPrimaryKey(orderNo);
        if (pOrders!=null){
            pOrders.setOrderState("11");
            if (type!= null){
                pOrders.setType(type);
            }
            pOrdersMapper.updateByPrimaryKeySelective(pOrders);
        }
        return ResultBuilder.success(pOrders);
    }

    /**
     * 会员商品回收
     * @param request
     * @return
     */
    @Transient
    public BaseCommonResult<MRecoveryGoods> recoveryOrder(RecoveryOrderRequest request) {
        MRecoveryGoods record = dozer.map(request, MRecoveryGoods.class);
        record.setOrderNo(DateUtil.getOrderNumber());
        record.setMemberId(request.getMemberId());
        UUserMember uUserMember = uUserMemberMapper.selectByPrimaryKey(request.getMemberId());
        record.setMemberName(uUserMember.getUserName());
        record.setCreateTime(new Date());
        mRecoveryGoodsMapper.insertSelective(record);
        return ResultBuilder.success(record);
    }

    /**
     * 会员回收商品查询
     * @param request
     * @return
     */
    public BaseCommonResult<BasePage<MRecoveryGoods>> recoveryOrderList(RecoveryRequest request) {
        BasePage<MRecoveryGoods> pageResult = new BasePage();
        log.info("会员回收商品查询商品列表,请求参数为：{}", request);
        try {
            PageHelper.startPage(request.getPage(), request.getPageSize());
            MRecoveryGoodsExample example = new MRecoveryGoodsExample ();
            MRecoveryGoodsExample.Criteria criteria = example.createCriteria();
            criteria.andMemberIdEqualTo(request.getMemberId());
            if (request.getOrderState()!=null){
                criteria.andOrderStateEqualTo(request.getOrderState());
            }
            List<MRecoveryGoods> list = mRecoveryGoodsMapper.selectByExample(example);
            PageInfo<MRecoveryGoods> pageInfo = new PageInfo<>(list);
            pageResult.setList(list);
            pageResult.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal());
        }catch (GoodsException e) {
            log.info("会员回收商品查询商品列表异常，异常信息为：{}", e);
            ResultBuilder.fail("系统异常");
        }
        log.info("会员回收商品查询商品列表接口结束");
        return ResultBuilder.success(pageResult);
    }

    public BaseCommonResult getRecoveryOrder(Long id) {
        log.info("会员回收商品查询商品详情接口请求参数:{}",id);
        return ResultBuilder.success(mRecoveryGoodsMapper.selectByPrimaryKey(id));
    }

    public BaseCommonResult<BasePage<MRecoveryGoods>> adminRecoveryOrderList(AdminRecoveryRequest request) {
        BasePage<MRecoveryGoods> pageResult = new BasePage();
        log.info("后台管理会员回收商品查询商品列表,请求参数为：{}", request);
        try {
            PageHelper.startPage(request.getPage(), request.getPageSize());
            List<MRecoveryGoods> list = tradeAdminMapper.selectAdminRecoveryOrderList(request);
            PageInfo<MRecoveryGoods> pageInfo = new PageInfo<>(list);
            pageResult.setList(list);
            pageResult.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal());
        }catch (GoodsException e) {
            log.info("后台管理会员回收商品查询商品列表异常，异常信息为：{}", e);
            ResultBuilder.fail("系统异常");
        }
        log.info("后台管理会员回收商品查询商品列表接口结束");
        return ResultBuilder.success(pageResult);
    }

    /**
     * 关闭回收
     * @param orderNo
     * @return
     */
    public BaseCommonResult deleteRecoveryOrder(Long orderNo) {
        MRecoveryGoods mRecoveryGoods = new MRecoveryGoods();
        mRecoveryGoods.setId(orderNo);
        mRecoveryGoods.setOrderState(6);
        mRecoveryGoodsMapper.updateByPrimaryKeySelective(mRecoveryGoods);
        log.info("后台管理会员回收商品订单关闭接口结束:{}",mRecoveryGoods);
        return ResultBuilder.success(mRecoveryGoods);
    }

    /**
     * 确认回收
     * @param orderNo
     * @return
     */
    public BaseCommonResult updateRecoveryOrder(Long orderNo) {
        MRecoveryGoods mRecoveryGoods = new MRecoveryGoods();
        mRecoveryGoods.setId(orderNo);
        mRecoveryGoods.setOrderState(5);
        mRecoveryGoodsMapper.updateByPrimaryKeySelective(mRecoveryGoods);
        log.info("后台管理会员回收商品订单确认接口结束:{}",mRecoveryGoods);
        return ResultBuilder.success(mRecoveryGoods);
    }

    /**
     * 回收订单详细
     * @param orderNo
     * @return
     */
    public BaseCommonResult<MRecoveryGoods> detailedRecoveryOrder(Long orderNo) {
        return ResultBuilder.success(mRecoveryGoodsMapper.selectByPrimaryKey(orderNo));
    }

    /**
     * 后台管理回收商品
     * @param request
     * @return
     */
    @Transient
    public BaseCommonResult<MRecoveryGoods> recoveryOffer(RecoveryOfferRequest request) {
        log.info("后台管理回收商品审核报价:{}",request);
        MRecoveryGoods mRecoveryGoods = new MRecoveryGoods();
        mRecoveryGoods.setId(request.getOrderNo());
        mRecoveryGoods.setmFreshUsed(request.getMFreshUsed());
        mRecoveryGoods.setYouPrice(request.getYouPrice());
        mRecoveryGoods.setPrice(request.getPrice());
        mRecoveryGoods.setDeRemarks(request.getDeRemarks());
        mRecoveryGoods.setGoodsCondition(request.getGoodsCondition());
        mRecoveryGoods.setOrderState(request.getOrderState());
        mRecoveryGoodsMapper.updateByPrimaryKeySelective(mRecoveryGoods);
        return ResultBuilder.success(mRecoveryGoods);
    }

    /**
     * 用户确认回收
     * @param id
     * @return
     */
    public BaseCommonResult getRecoveryOrderState(Long id) {
        log.info("后台管理回收商品审核报价:{}",id);
        MRecoveryGoods mRecoveryGoods = new MRecoveryGoods();
        mRecoveryGoods.setId(id);
        mRecoveryGoods.setOrderState(2);
        mRecoveryGoodsMapper.updateByPrimaryKeySelective(mRecoveryGoods);
        return ResultBuilder.success(mRecoveryGoods);
    }

    /**
     * 会员退货
     * @param request
     * @return
     */
    public BaseCommonResult<POrders> refundOrder(RefundOrderReequest request) {
        POrdersExample example = new POrdersExample ();
        example.createCriteria().andIdEqualTo(request.getOrderNo()).andUserIdEqualTo(request.getUserId());
        List<POrders> pOrders = pOrdersMapper.selectByExample(example);
        if (pOrders.size()<=0){
            ResultBuilder.fail("订单不存在");
        }
        POrders orders = pOrders.get(0);
        orders.setRefundState(request.getRefundState());
        orders.setRefundRemarks(request.getRefundRemarks());
        orders.setRefundPic(request.getRefundPic());
        orders.setRefundPrice(request.getRefundPrice());
        orders.setOrderState("7");
        pOrdersMapper.updateByPrimaryKeySelective(orders);
        return ResultBuilder.success(orders);
    }
}
