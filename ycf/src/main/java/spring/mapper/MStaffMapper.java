package spring.mapper;

import spring.model.MStaff;
import spring.model.MStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MStaffMapper {
    long countByExample(MStaffExample example);

    int deleteByExample(MStaffExample example);

    int deleteByPrimaryKey(Long staffId);

    int insert(MStaff record);

    int insertSelective(MStaff record);

    List<MStaff> selectByExample(MStaffExample example);

    MStaff selectByPrimaryKey(Long staffId);

    int updateByExampleSelective(@Param("record") MStaff record, @Param("example") MStaffExample example);

    int updateByExample(@Param("record") MStaff record, @Param("example") MStaffExample example);

    int updateByPrimaryKeySelective(MStaff record);

    int updateByPrimaryKey(MStaff record);
}