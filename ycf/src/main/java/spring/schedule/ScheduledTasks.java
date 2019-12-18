package spring.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import spring.mapper.PGoodsMapper;
import spring.mapper.POrdersDetailsMapper;
import spring.mapper.POrdersMapper;
import spring.model.*;
import spring.utils.DateUtil;

import java.beans.Transient;
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
}
