package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.PFirstFicture;
import spring.model.PFirstFictureExample;

public interface PFirstFictureMapper {
    long countByExample(PFirstFictureExample example);

    int deleteByExample(PFirstFictureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PFirstFicture record);

    int insertSelective(PFirstFicture record);

    List<PFirstFicture> selectByExample(PFirstFictureExample example);

    PFirstFicture selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PFirstFicture record, @Param("example") PFirstFictureExample example);

    int updateByExample(@Param("record") PFirstFicture record, @Param("example") PFirstFictureExample example);

    int updateByPrimaryKeySelective(PFirstFicture record);

    int updateByPrimaryKey(PFirstFicture record);
}