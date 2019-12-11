package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MRolepermissionManual;
import spring.model.MRolepermissionManualExample;

public interface MRolepermissionManualMapper {
    long countByExample(MRolepermissionManualExample example);

    int deleteByExample(MRolepermissionManualExample example);

    int deleteByPrimaryKey(Long rolePermissionId);

    int insert(MRolepermissionManual record);

    int insertSelective(MRolepermissionManual record);

    List<MRolepermissionManual> selectByExample(MRolepermissionManualExample example);

    MRolepermissionManual selectByPrimaryKey(Long rolePermissionId);

    int updateByExampleSelective(@Param("record") MRolepermissionManual record, @Param("example") MRolepermissionManualExample example);

    int updateByExample(@Param("record") MRolepermissionManual record, @Param("example") MRolepermissionManualExample example);

    int updateByPrimaryKeySelective(MRolepermissionManual record);

    int updateByPrimaryKey(MRolepermissionManual record);
}