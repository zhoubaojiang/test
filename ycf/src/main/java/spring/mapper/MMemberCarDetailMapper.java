package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MMemberCarDetail;
import spring.model.MMemberCarDetailExample;

public interface MMemberCarDetailMapper {
    long countByExample(MMemberCarDetailExample example);

    int deleteByExample(MMemberCarDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MMemberCarDetail record);

    int insertSelective(MMemberCarDetail record);

    List<MMemberCarDetail> selectByExample(MMemberCarDetailExample example);

    MMemberCarDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MMemberCarDetail record, @Param("example") MMemberCarDetailExample example);

    int updateByExample(@Param("record") MMemberCarDetail record, @Param("example") MMemberCarDetailExample example);

    int updateByPrimaryKeySelective(MMemberCarDetail record);

    int updateByPrimaryKey(MMemberCarDetail record);
}