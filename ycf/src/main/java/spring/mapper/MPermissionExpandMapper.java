package spring.mapper;

import spring.model.MPermissionExpand;
import spring.model.MPermissionExpandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MPermissionExpandMapper {
    long countByExample(MPermissionExpandExample example);

    int deleteByExample(MPermissionExpandExample example);

    int deleteByPrimaryKey(Long permissionId);

    int insert(MPermissionExpand record);

    int insertSelective(MPermissionExpand record);

    List<MPermissionExpand> selectByExample(MPermissionExpandExample example);

    MPermissionExpand selectByPrimaryKey(Long permissionId);

    int updateByExampleSelective(@Param("record") MPermissionExpand record, @Param("example") MPermissionExpandExample example);

    int updateByExample(@Param("record") MPermissionExpand record, @Param("example") MPermissionExpandExample example);

    int updateByPrimaryKeySelective(MPermissionExpand record);

    int updateByPrimaryKey(MPermissionExpand record);
}