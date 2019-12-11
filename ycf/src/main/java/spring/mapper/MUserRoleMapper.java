package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MUserRole;
import spring.model.MUserRoleExample;

public interface MUserRoleMapper {
    long countByExample(MUserRoleExample example);

    int deleteByExample(MUserRoleExample example);

    int deleteByPrimaryKey(Long userRoleId);

    int insert(MUserRole record);

    int insertSelective(MUserRole record);

    List<MUserRole> selectByExample(MUserRoleExample example);

    MUserRole selectByPrimaryKey(Long userRoleId);

    int updateByExampleSelective(@Param("record") MUserRole record, @Param("example") MUserRoleExample example);

    int updateByExample(@Param("record") MUserRole record, @Param("example") MUserRoleExample example);

    int updateByPrimaryKeySelective(MUserRole record);

    int updateByPrimaryKey(MUserRole record);
}