package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MPermissionMxpand;
import spring.model.MPermissionMxpandExample;

public interface MPermissionMxpandMapper {
    long countByExample(MPermissionMxpandExample example);

    int deleteByExample(MPermissionMxpandExample example);

    int deleteByPrimaryKey(Long permissionId);

    int insert(MPermissionMxpand record);

    int insertSelective(MPermissionMxpand record);

    List<MPermissionMxpand> selectByExample(MPermissionMxpandExample example);

    MPermissionMxpand selectByPrimaryKey(Long permissionId);

    int updateByExampleSelective(@Param("record") MPermissionMxpand record, @Param("example") MPermissionMxpandExample example);

    int updateByExample(@Param("record") MPermissionMxpand record, @Param("example") MPermissionMxpandExample example);

    int updateByPrimaryKeySelective(MPermissionMxpand record);

    int updateByPrimaryKey(MPermissionMxpand record);
}