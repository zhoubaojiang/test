package spring.mapper.cvs;

import spring.dto.result.GetMemberResult;

import java.util.List;

public interface MemberOrderMapper {
    List<GetMemberResult> selectYouFei(Long memberId);

    List<GetMemberResult> selectPrice(Long memberId);
}
