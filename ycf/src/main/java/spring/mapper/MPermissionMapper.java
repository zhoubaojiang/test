package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MPermission;
import spring.model.MPermissionExample;

public interface MPermissionMapper {
    long countByExample(MPermissionExample example);

    int deleteByExample(MPermissionExample example);

    int deleteByPrimaryKey(Long permissionId);

    int insert(MPermission record);

    int insertSelective(MPermission record);

    List<MPermission> selectByExample(MPermissionExample example);

    MPermission selectByPrimaryKey(Long permissionId);

    int updateByExampleSelective(@Param("record") MPermission record, @Param("example") MPermissionExample example);

    int updateByExample(@Param("record") MPermission record, @Param("example") MPermissionExample example);

    int updateByPrimaryKeySelective(MPermission record);

    int updateByPrimaryKey(MPermission record);
}