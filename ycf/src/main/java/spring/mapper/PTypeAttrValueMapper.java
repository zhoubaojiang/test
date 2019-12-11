package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.PTypeAttrValue;
import spring.model.PTypeAttrValueExample;

public interface PTypeAttrValueMapper {
    long countByExample(PTypeAttrValueExample example);

    int deleteByExample(PTypeAttrValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PTypeAttrValue record);

    int insertSelective(PTypeAttrValue record);

    List<PTypeAttrValue> selectByExample(PTypeAttrValueExample example);

    PTypeAttrValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PTypeAttrValue record, @Param("example") PTypeAttrValueExample example);

    int updateByExample(@Param("record") PTypeAttrValue record, @Param("example") PTypeAttrValueExample example);

    int updateByPrimaryKeySelective(PTypeAttrValue record);

    int updateByPrimaryKey(PTypeAttrValue record);
}