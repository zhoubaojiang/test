package spring.mapper;

import spring.model.MUser;
import spring.model.MUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MUserMapper {
    long countByExample(MUserExample example);

    int deleteByExample(MUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(MUser record);

    int insertSelective(MUser record);

    List<MUser> selectByExample(MUserExample example);

    MUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") MUser record, @Param("example") MUserExample example);

    int updateByExample(@Param("record") MUser record, @Param("example") MUserExample example);

    int updateByPrimaryKeySelective(MUser record);

    int updateByPrimaryKey(MUser record);
}