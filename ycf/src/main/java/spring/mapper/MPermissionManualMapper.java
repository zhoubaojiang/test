package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MPermissionManual;
import spring.model.MPermissionManualExample;

public interface MPermissionManualMapper {
    long countByExample(MPermissionManualExample example);

    int deleteByExample(MPermissionManualExample example);

    int deleteByPrimaryKey(Long permissionId);

    int insert(MPermissionManual record);

    int insertSelective(MPermissionManual record);

    List<MPermissionManual> selectByExample(MPermissionManualExample example);

    MPermissionManual selectByPrimaryKey(Long permissionId);

    int updateByExampleSelective(@Param("record") MPermissionManual record, @Param("example") MPermissionManualExample example);

    int updateByExample(@Param("record") MPermissionManual record, @Param("example") MPermissionManualExample example);

    int updateByPrimaryKeySelective(MPermissionManual record);

    int updateByPrimaryKey(MPermissionManual record);
}