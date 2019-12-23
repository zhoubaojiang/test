package spring.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import spring.mapper.*;
import spring.mapper.cvs.TradeAdminMapper;
import spring.model.*;
import spring.utils.DateUtil;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Component
@Slf4j
public class ScheduledTasks {
        @Autowired
        private POrdersMapper ordersMapper;
         @Autowired
        private POrdersDetailsMapper ordersDetailsMapper;
         @Autowired
         private PGoodsMapper goodsMapper;
        @Autowired
        private TradeAdminMapper tradeAdminMapper;
         @Autowired
        private MMemberInterestMapper interestMapper;
         @Autowired
         private UUserMemberMapper memberMapper;
        @Transient
//	    @Scheduled(cron="0 1 * * * ?")
	    public void reportCurrentTime() {
            POrdersExample example = new POrdersExample ();
            example.createCriteria().andOrderStateEqualTo("0");
            List<POrders> pOrders = ordersMapper.selectByExample(example);
            if (pOrders.size()>0){
                for (POrders orders:pOrders) {
                    Date createTime = orders.getCreateTime();
                    Long minus = DateUtil.minus(new Date(), createTime);
                    if (minus>=15L){
                        log.info("minus 相差:{}分钟",minus);
                        orders.setOrderState("11");
                        ordersMapper.updateByPrimaryKey(orders);
                        POrdersDetailsExample ordersDetailsExample = new POrdersDetailsExample ();
                        ordersDetailsExample.createCriteria().andOrderNoEqualTo(orders.getId());
                        List<POrdersDetails> pOrdersDetails = ordersDetailsMapper.selectByExample(ordersDetailsExample);
                        for (POrdersDetails details:pOrdersDetails) {
                            PGoods record = new PGoods ();
                            record.setId(details.getGoodsId());
                            record.setGoodsNumType(1);
                            goodsMapper.updateByPrimaryKeySelective(record);
                        }
                    }
                }
            }
        }

    /**
     * 每天零时清空累计获取次数
     */
//    @Scheduled(cron="0 1 * * * ?")
    public void updateMember() {
      int i =  tradeAdminMapper.updateMemberCount();
    }

//    @Scheduled(cron="0 0/1 * * * ?")
    @Transient
    public void interestMember() {
        UUserMemberExample example = new UUserMemberExample ();
        List<UUserMember> uUserMembers = memberMapper.selectByExample(example);
        if (uUserMembers.size()>0){
            //获取用户鱿费
            for (UUserMember member:uUserMembers) {
                if (member.getYuanBao().intValue()!= 0){
                    MMemberInterest record = new MMemberInterest ();
                    record.setYouPrice(member.getYuanBao().multiply(new BigDecimal(0.0245)));
                    record.setMemberId(member.getId());
                    record.setCreateTime(new Date());
                    interestMapper.insertSelective(record);
                    //鱿费累计收益
                    member.setYouPrice(member.getYouPrice().add(record.getYouPrice() ));
                    member.setYuanBao(member.getYuanBao().add(record.getYouPrice() ));
                    memberMapper.updateByPrimaryKeySelective(member);
                }
            }
        }
    }

}
