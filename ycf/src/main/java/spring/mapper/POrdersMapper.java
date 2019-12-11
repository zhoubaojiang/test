package spring.mapper;

import spring.model.POrders;
import spring.model.POrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface POrdersMapper {
    long countByExample(POrdersExample example);

    int deleteByExample(POrdersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(POrders record);

    int insertSelective(POrders record);

    List<POrders> selectByExample(POrdersExample example);

    POrders selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") POrders record, @Param("example") POrdersExample example);

    int updateByExample(@Param("record") POrders record, @Param("example") POrdersExample example);

    int updateByPrimaryKeySelective(POrders record);

    int updateByPrimaryKey(POrders record);
}