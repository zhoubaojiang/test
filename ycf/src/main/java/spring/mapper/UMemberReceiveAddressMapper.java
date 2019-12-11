package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.UMemberReceiveAddress;
import spring.model.UMemberReceiveAddressExample;

public interface UMemberReceiveAddressMapper {
    long countByExample(UMemberReceiveAddressExample example);

    int deleteByExample(UMemberReceiveAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UMemberReceiveAddress record);

    int insertSelective(UMemberReceiveAddress record);

    List<UMemberReceiveAddress> selectByExample(UMemberReceiveAddressExample example);

    UMemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UMemberReceiveAddress record, @Param("example") UMemberReceiveAddressExample example);

    int updateByExample(@Param("record") UMemberReceiveAddress record, @Param("example") UMemberReceiveAddressExample example);

    int updateByPrimaryKeySelective(UMemberReceiveAddress record);

    int updateByPrimaryKey(UMemberReceiveAddress record);
}