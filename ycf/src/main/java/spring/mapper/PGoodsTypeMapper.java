package spring.mapper;

import spring.model.PGoodsType;
import spring.model.PGoodsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PGoodsTypeMapper {
    long countByExample(PGoodsTypeExample example);

    int deleteByExample(PGoodsTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PGoodsType record);

    int insertSelective(PGoodsType record);

    List<PGoodsType> selectByExample(PGoodsTypeExample example);

    PGoodsType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PGoodsType record, @Param("example") PGoodsTypeExample example);

    int updateByExample(@Param("record") PGoodsType record, @Param("example") PGoodsTypeExample example);

    int updateByPrimaryKeySelective(PGoodsType record);

    int updateByPrimaryKey(PGoodsType record);
}