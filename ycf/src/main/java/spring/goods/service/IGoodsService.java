package spring.goods.service;

import spring.mapper.PGoodsTypeMapper;
import spring.model.PGoodsType;
import spring.model.PGoodsTypeExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class IGoodsService {

    @Autowired
    private PGoodsTypeMapper goodsTypeMapper;
    /**
     * 获取分类节点记录
     *
     * @date：   2018/3/1 16:51
     * @param：  [currentNodeid] 当前节点id
     * @return： java.util.List<com.wufumall.goods.model.PGoodsType>
     */
    public List<PGoodsType> getPGoodsTypeNodes(Integer currentNodeid){
        return getPGoodsTypeList(currentNodeid);
    }

    /**
     *  获取子节点下的所有记录
     *
     * @author： zhouzhiming
     * @date：   2018/3/1 16:43
     * @param：  [pgoodsTypdId] 商品类型id
     * @return： java.util.List<com.wufumall.goods.model.PGoodsType>
     */
    private List<PGoodsType> getPGoodsTypeList(Integer pgoodsTypdId){
        List<PGoodsType> allChildList = new ArrayList<>();
        PGoodsType pGoodsType;
        //循环获取父类目录
        do{
            pGoodsType= getPGoodsType(pgoodsTypdId);
            if(pGoodsType!=null){
                pgoodsTypdId=pGoodsType.getPid();
                allChildList.add(pGoodsType);
            }
        }while (pGoodsType!=null && pGoodsType.getPid()>0);

        if(allChildList.isEmpty())
            log.info("获取子节点下的所有记录：结果为空pgoodsTypdId={0}.",pgoodsTypdId);

        return allChildList;
    }

    /**
     * 获取PGoodsType记录
     *
     * @author： zhouzhiming
     * @date：   2018/3/2 17:35
     * @param：  [pgoodsTypdId]
     * @return： com.wufumall.goods.model.PGoodsType
     */
    private PGoodsType getPGoodsType(Integer pgoodsTypdId){
        PGoodsTypeExample pGoodsTypeExample=new PGoodsTypeExample();
        pGoodsTypeExample.createCriteria().andIdEqualTo(pgoodsTypdId)
                .andIsdeleteEqualTo(new Byte("0"));
        List<PGoodsType> pGoodsTypeList = goodsTypeMapper.selectByExample(pGoodsTypeExample);
        if(pGoodsTypeList!=null && !pGoodsTypeList.isEmpty() && pGoodsTypeList.size()>0){
            return pGoodsTypeList.get(0);
        }
        return null;
    }
}
