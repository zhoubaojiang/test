package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MMemberInterest;
import spring.model.MMemberInterestExample;

public interface MMemberInterestMapper {
    long countByExample(MMemberInterestExample example);

    int deleteByExample(MMemberInterestExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MMemberInterest record);

    int insertSelective(MMemberInterest record);

    List<MMemberInterest> selectByExample(MMemberInterestExample example);

    MMemberInterest selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MMemberInterest record, @Param("example") MMemberInterestExample example);

    int updateByExample(@Param("record") MMemberInterest record, @Param("example") MMemberInterestExample example);

    int updateByPrimaryKeySelective(MMemberInterest record);

    int updateByPrimaryKey(MMemberInterest record);
}