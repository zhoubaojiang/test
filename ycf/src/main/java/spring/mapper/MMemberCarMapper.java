package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.MMemberCar;
import spring.model.MMemberCarExample;

public interface MMemberCarMapper {
    long countByExample(MMemberCarExample example);

    int deleteByExample(MMemberCarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MMemberCar record);

    int insertSelective(MMemberCar record);

    List<MMemberCar> selectByExample(MMemberCarExample example);

    MMemberCar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MMemberCar record, @Param("example") MMemberCarExample example);

    int updateByExample(@Param("record") MMemberCar record, @Param("example") MMemberCarExample example);

    int updateByPrimaryKeySelective(MMemberCar record);

    int updateByPrimaryKey(MMemberCar record);
}