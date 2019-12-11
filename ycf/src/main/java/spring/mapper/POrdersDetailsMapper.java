package spring.mapper;

import spring.model.POrdersDetails;
import spring.model.POrdersDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface POrdersDetailsMapper {
    long countByExample(POrdersDetailsExample example);

    int deleteByExample(POrdersDetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(POrdersDetails record);

    int insertSelective(POrdersDetails record);

    List<POrdersDetails> selectByExample(POrdersDetailsExample example);

    POrdersDetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") POrdersDetails record, @Param("example") POrdersDetailsExample example);

    int updateByExample(@Param("record") POrdersDetails record, @Param("example") POrdersDetailsExample example);

    int updateByPrimaryKeySelective(POrdersDetails record);

    int updateByPrimaryKey(POrdersDetails record);
}