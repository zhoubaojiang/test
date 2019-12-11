package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MUserManual;
import spring.model.MUserManualExample;

public interface MUserManualMapper {
    long countByExample(MUserManualExample example);

    int deleteByExample(MUserManualExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(MUserManual record);

    int insertSelective(MUserManual record);

    List<MUserManual> selectByExample(MUserManualExample example);

    MUserManual selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") MUserManual record, @Param("example") MUserManualExample example);

    int updateByExample(@Param("record") MUserManual record, @Param("example") MUserManualExample example);

    int updateByPrimaryKeySelective(MUserManual record);

    int updateByPrimaryKey(MUserManual record);
}