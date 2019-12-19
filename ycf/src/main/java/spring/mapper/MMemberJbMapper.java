package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MMemberJb;
import spring.model.MMemberJbExample;

public interface MMemberJbMapper {
    long countByExample(MMemberJbExample example);

    int deleteByExample(MMemberJbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MMemberJb record);

    int insertSelective(MMemberJb record);

    List<MMemberJb> selectByExample(MMemberJbExample example);

    MMemberJb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MMemberJb record, @Param("example") MMemberJbExample example);

    int updateByExample(@Param("record") MMemberJb record, @Param("example") MMemberJbExample example);

    int updateByPrimaryKeySelective(MMemberJb record);

    int updateByPrimaryKey(MMemberJb record);
}