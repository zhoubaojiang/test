package spring.mapper;

import spring.model.MRolePermission;
import spring.model.MRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MRolePermissionMapper {
    long countByExample(MRolePermissionExample example);

    int deleteByExample(MRolePermissionExample example);

    int deleteByPrimaryKey(Long rolePermissionId);

    int insert(MRolePermission record);

    int insertSelective(MRolePermission record);

    List<MRolePermission> selectByExample(MRolePermissionExample example);

    MRolePermission selectByPrimaryKey(Long rolePermissionId);

    int updateByExampleSelective(@Param("record") MRolePermission record, @Param("example") MRolePermissionExample example);

    int updateByExample(@Param("record") MRolePermission record, @Param("example") MRolePermissionExample example);

    int updateByPrimaryKeySelective(MRolePermission record);

    int updateByPrimaryKey(MRolePermission record);
}