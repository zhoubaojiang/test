package spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.model.ActorInfo;
import spring.model.ActorInfoExample;

public interface ActorInfoMapper {
    long countByExample(ActorInfoExample example);

    int deleteByExample(ActorInfoExample example);

    int insert(ActorInfo record);

    int insertSelective(ActorInfo record);

    List<ActorInfo> selectByExample(ActorInfoExample example);

    int updateByExampleSelective(@Param("record") ActorInfo record, @Param("example") ActorInfoExample example);

    int updateByExample(@Param("record") ActorInfo record, @Param("example") ActorInfoExample example);
}