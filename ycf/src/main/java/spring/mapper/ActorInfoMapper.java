package spring.mapper;

import spring.model.ActorInfo;
import spring.model.ActorInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActorInfoMapper {
    long countByExample(ActorInfoExample example);

    int deleteByExample(ActorInfoExample example);

    int insert(ActorInfo record);

    int insertSelective(ActorInfo record);

    List<ActorInfo> selectByExample(ActorInfoExample example);

    int updateByExampleSelective(@Param("record") ActorInfo record, @Param("example") ActorInfoExample example);

    int updateByExample(@Param("record") ActorInfo record, @Param("example") ActorInfoExample example);
}