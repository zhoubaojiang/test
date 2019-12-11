package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.UUserMember;
import spring.model.UUserMemberExample;

public interface UUserMemberMapper {
    long countByExample(UUserMemberExample example);

    int deleteByExample(UUserMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UUserMember record);

    int insertSelective(UUserMember record);

    List<UUserMember> selectByExample(UUserMemberExample example);

    UUserMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UUserMember record, @Param("example") UUserMemberExample example);

    int updateByExample(@Param("record") UUserMember record, @Param("example") UUserMemberExample example);

    int updateByPrimaryKeySelective(UUserMember record);

    int updateByPrimaryKey(UUserMember record);
}