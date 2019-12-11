package spring.trade.service;

import spring.dto.BaseCommonResult;
import spring.mapper.PGoodsMapper;
import spring.mapper.POrdersDetailsMapper;
import spring.mapper.POrdersMapper;
import spring.mapper.UMemberReceiveAddressMapper;
import spring.model.*;
import spring.trade.dto.request.OrdersRes;
import spring.utils.ResultBuilder;
import spring.wechat.dto.requset.PayReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

@Service
public class OrderService  {
    @Autowired
    private PGoodsMapper pGoodsMapper;
    @Autowired
    private POrdersMapper pOrdersMapper;
    @Autowired
    private UMemberReceiveAddressMapper memberReceiveAddressMapper;
    @Autowired
    private POrdersDetailsMapper pOrdersDetailsMapper;

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
        if(ordersRes.getOrderType()==0){//支付方式;0现金，1鱿费
            pOreders.setTotalPrice(goods.getGoodsPrice());
        }else {
            pOreders.setOrderPrice(goods.getTreasureDiscountPrice());
        }

        pOreders.setOrderState("0");
        pOreders.setReceivedName(memberReceiveAddress.getName());
        pOreders.setPhone(memberReceiveAddress.getPhone());
        pOreders.setProvince(memberReceiveAddress.getProvince());
        pOreders.setCity(memberReceiveAddress.getCity());
        pOreders.setArea(memberReceiveAddress.getArea());
        pOreders.setAddress(memberReceiveAddress.getDetailAddress());
        int i = pOrdersMapper.insertSelective(pOreders);

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
}
