package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.Address;
import spring.model.AddressExample;

public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Short addressId);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExampleWithBLOBs(AddressExample example);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Short addressId);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExampleWithBLOBs(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKeyWithBLOBs(Address record);

    int updateByPrimaryKey(Address record);
}