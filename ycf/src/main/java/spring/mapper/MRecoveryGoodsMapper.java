package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MRecoveryGoods;
import spring.model.MRecoveryGoodsExample;

public interface MRecoveryGoodsMapper {
    long countByExample(MRecoveryGoodsExample example);

    int deleteByExample(MRecoveryGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MRecoveryGoods record);

    int insertSelective(MRecoveryGoods record);

    List<MRecoveryGoods> selectByExample(MRecoveryGoodsExample example);

    MRecoveryGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MRecoveryGoods record, @Param("example") MRecoveryGoodsExample example);

    int updateByExample(@Param("record") MRecoveryGoods record, @Param("example") MRecoveryGoodsExample example);

    int updateByPrimaryKeySelective(MRecoveryGoods record);

    int updateByPrimaryKey(MRecoveryGoods record);
}