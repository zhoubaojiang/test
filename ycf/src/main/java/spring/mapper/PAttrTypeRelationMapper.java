package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.PAttrTypeRelation;
import spring.model.PAttrTypeRelationExample;

public interface PAttrTypeRelationMapper {
    long countByExample(PAttrTypeRelationExample example);

    int deleteByExample(PAttrTypeRelationExample example);

    int insert(PAttrTypeRelation record);

    int insertSelective(PAttrTypeRelation record);

    List<PAttrTypeRelation> selectByExample(PAttrTypeRelationExample example);

    int updateByExampleSelective(@Param("record") PAttrTypeRelation record, @Param("example") PAttrTypeRelationExample example);

    int updateByExample(@Param("record") PAttrTypeRelation record, @Param("example") PAttrTypeRelationExample example);
}