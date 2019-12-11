package spring.mapper;

import spring.model.PTypeAttr;
import spring.model.PTypeAttrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PTypeAttrMapper {
    long countByExample(PTypeAttrExample example);

    int deleteByExample(PTypeAttrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PTypeAttr record);

    int insertSelective(PTypeAttr record);

    List<PTypeAttr> selectByExample(PTypeAttrExample example);

    PTypeAttr selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PTypeAttr record, @Param("example") PTypeAttrExample example);

    int updateByExample(@Param("record") PTypeAttr record, @Param("example") PTypeAttrExample example);

    int updateByPrimaryKeySelective(PTypeAttr record);

    int updateByPrimaryKey(PTypeAttr record);
}