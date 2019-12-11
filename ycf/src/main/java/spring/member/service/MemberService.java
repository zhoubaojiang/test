package spring.member.service;

import spring.dto.BaseCommonResult;
import spring.dto.request.MemberRequest;
import spring.dto.request.UserLoginDto;
import spring.dto.result.UserLoginResponse;
import spring.mapper.UUserMemberMapper;
import spring.model.MUserManual;
import spring.model.UUserMember;
import spring.model.UUserMemberExample;
import spring.utils.Constants;
import spring.utils.ResultBuilder;
import spring.utils.TonKenUtile;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MemberService {
    @Autowired
    private UUserMemberMapper userMemberMapper;
    @Autowired
    private DozerBeanMapper dozerMapper;
    @Transient
    public BaseCommonResult<UUserMember> register(MemberRequest record) {
        log.info("会员注册请求参数:{}",record);
        UUserMember map = dozerMapper.map(record, UUserMember.class);
        map.setCreateTime(new Date());
        int i = userMemberMapper.insertSelective(map);
        log.info("会员注册注册成功:{}",map);
        return ResultBuilder.success(map);
    }

    public BaseCommonResult<UserLoginResponse> login(String code) {
        UserLoginResponse result = new UserLoginResponse();
        UUserMemberExample example = new UUserMemberExample();
        example.createCriteria().andAppIdEqualTo(code);
        List<UUserMember> userMembers = userMemberMapper.selectByExample(example);
        UUserMember userMember = userMembers.get(0);
        if(userMember == null){
            ResultBuilder.fail("会员不存在");
        }
        UserLoginDto loginDto = new UserLoginDto();
        loginDto.setChannelId(Constants.CHANNELID_XCX);
        loginDto.setUserType(Constants.USER_TYPE_MEMBER);
        MUserManual member = new MUserManual();
        member.setWfcode(userMember.getAppId());
        TonKenUtile.setResultToken(result, loginDto, member);
        result.setLoginAccount(userMember.getAppId());
        result.setLoginId(String.valueOf(userMember.getId()));
        result.setUserName(userMember.getUserName());
        return ResultBuilder.success(result);
    }

    public BaseCommonResult loginOut(String code) {
        TonKenUtile.loginOut(code,Constants.USER_TYPE_MEMBER,Constants.CHANNELID_XCX);
        return ResultBuilder.success();
    }

    public BaseCommonResult getMoney(String code) {
        UUserMemberExample example = new UUserMemberExample();
        example.createCriteria().andAppIdEqualTo(code);
        List<UUserMember> uUserMembers = userMemberMapper.selectByExample(example);
        if (uUserMembers.size()<=0){
            return ResultBuilder.fail("非法请求");
        }
        return ResultBuilder.success(uUserMembers.get(0));
    }
}
