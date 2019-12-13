package spring.mapper.cvs;

import org.apache.ibatis.annotations.Param;
import spring.dto.result.MemberCarResult;

import java.util.List;

public interface MemberCarMapper {

    List<MemberCarResult> selectMemberCarList(@Param("memberId")String memberId);
}
