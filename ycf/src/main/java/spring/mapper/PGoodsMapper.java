package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.PGoods;
import spring.model.PGoodsExample;

public interface PGoodsMapper {
    long countByExample(PGoodsExample example);

    int deleteByExample(PGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PGoods record);

    int insertSelective(PGoods record);

    List<PGoods> selectByExample(PGoodsExample example);

    PGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PGoods record, @Param("example") PGoodsExample example);

    int updateByExample(@Param("record") PGoods record, @Param("example") PGoodsExample example);

    int updateByPrimaryKeySelective(PGoods record);

    int updateByPrimaryKey(PGoods record);
}