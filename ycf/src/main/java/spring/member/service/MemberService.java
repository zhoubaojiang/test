package spring.member.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import spring.dto.BaseCommonResult;
import spring.dto.request.MemberCarListRequest;
import spring.dto.request.MemberCarRequest;
import spring.dto.request.MemberRequest;
import spring.dto.request.UserLoginDto;
import spring.dto.result.BasePage;
import spring.dto.result.MemberCarResult;
import spring.dto.result.MemberLoginResponse;
import spring.dto.result.UserLoginResponse;
import spring.exception.GoodsException;
import spring.mapper.MMemberCarDetailMapper;
import spring.mapper.MMemberCarMapper;
import spring.mapper.UMemberReceiveAddressMapper;
import spring.mapper.UUserMemberMapper;
import spring.mapper.cvs.MemberCarMapper;
import spring.model.*;
import spring.utils.Constants;
import spring.utils.ResultBuilder;
import spring.utils.TonKenUtile;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MemberService {
    @Autowired
    private UUserMemberMapper userMemberMapper;
    @Autowired
    private UMemberReceiveAddressMapper memberReceiveAddressMapper;
    @Autowired
    private DozerBeanMapper dozerMapper;
    @Autowired
    private MMemberCarMapper mMemberCarMapper;
    @Autowired
    private MMemberCarDetailMapper mMemberCarDetailMapper;
    @Autowired
    private MemberCarMapper memberCarMapper;


    @Transient
    public BaseCommonResult<UUserMember> register(MemberRequest record) {
        log.info("会员注册请求参数:{}",record);
        UUserMember map = dozerMapper.map(record, UUserMember.class);
        map.setCreateTime(new Date());
        UUserMemberExample example = new UUserMemberExample();
        example.createCriteria().andAppIdEqualTo(record.getAppId());
        List<UUserMember> uUserMembers = userMemberMapper.selectByExample(example);
        if (uUserMembers.size()>0){
            return ResultBuilder.fail("用户已注册");
        }
        int i = userMemberMapper.insertSelective(map);
        log.info("会员注册注册成功:{}",map);
        return ResultBuilder.success(map);
    }

    public BaseCommonResult<MemberLoginResponse> login(MemberRequest record) {
        MemberLoginResponse result = new MemberLoginResponse();
        UUserMemberExample example = new UUserMemberExample();
        example.createCriteria().andAppIdEqualTo(record.getAppId());
        List<UUserMember> userMembers = userMemberMapper.selectByExample(example);
        UUserMember userMember = new UUserMember();
        if(userMembers.size() == 0){
            userMember.setCreateTime(new Date());
            userMember.setUserName(record.getUserName());
            userMember.setAppId(record.getAppId());
            userMember.setPicUrl(record.getPicUrl());
            userMemberMapper.insertSelective(userMember);
        }else{
            userMember = userMembers.get(0);
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
            result.setYuanBao(userMember.getYuanBao());
            result.setPrice(userMember.getPrice());
            result.setPicUrl(userMember.getPicUrl());
            result.setGold(userMember.getGold());
            result.setUserType(Constants.USER_TYPE_MEMBER);
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
    @Transient
    public BaseCommonResult add(UMemberReceiveAddress request) {
        UMemberReceiveAddressExample example = new UMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(request.getMemberId()).andDefaultStatusEqualTo(0);
        List<UMemberReceiveAddress> uMemberReceiveAddresses = memberReceiveAddressMapper.selectByExample(example);
        if (uMemberReceiveAddresses.size()>0){
            UMemberReceiveAddress memberReceiveAddress = uMemberReceiveAddresses.get(0);
            if (request.getDefaultStatus()==0){
                memberReceiveAddress.setDefaultStatus(1);
                memberReceiveAddressMapper.updateByPrimaryKeySelective(memberReceiveAddress);
            }
        }else {
            //没有默认地址设置为默认
            request.setDefaultStatus(0);
        }
        int i = memberReceiveAddressMapper.insertSelective(request);
        return ResultBuilder.success(request);
    }
    @Transient
    public BaseCommonResult update(UMemberReceiveAddress request) {
        memberReceiveAddressMapper.updateByPrimaryKeySelective(request);
        return ResultBuilder.success(request);
    }
    @Transient
    public BaseCommonResult addCar(MemberCarRequest request) {
        MMemberCar record = new MMemberCar();
        record.setMemberId(request.getMemberId());
        record.setCreateTime(new Date());
        mMemberCarMapper.insertSelective(record);

        MMemberCarDetail memberCarDetail = new MMemberCarDetail();
        memberCarDetail.setGoodsId(request.getGoodsId());
        memberCarDetail.setMemberCarId(record.getId());
        mMemberCarDetailMapper.insertSelective(memberCarDetail);
        return ResultBuilder.success(record);
    }
    @Transient
    public BaseCommonResult deleteCar(MemberCarRequest request) {
        log.info("会员购物车删除,请求参数为：{}", request);
        MMemberCarDetailExample example = new MMemberCarDetailExample();
        example.createCriteria().andGoodsIdEqualTo(request.getGoodsId()).andIdEqualTo(request.getMemberCarDetailId());
        int i = mMemberCarDetailMapper.deleteByExample(example);
        log.info("会员购物车删除,成功：{}", i);
        return ResultBuilder.success();
    }

    public BaseCommonResult<BasePage<MemberCarResult>> memberCarList(MemberCarListRequest request) {
        BasePage<MemberCarResult> pageResult = new BasePage();
        log.info("会员购物车列表,请求参数为：{}", request);
        try {
            PageHelper.startPage(request.getPage(), request.getPageSize());
            List<MemberCarResult> list= memberCarMapper.selectMemberCarList(request.getMemberId());
            PageInfo<MemberCarResult> pageInfo = new PageInfo<>(list);
            pageResult.setList(list);
            pageResult.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal());
        }catch (GoodsException e) {
            log.info("会员购物车列表异常，异常信息为：{}", e);
            ResultBuilder.fail("系统异常");
        }
        log.info("会员购物车列表接口结束");
        return ResultBuilder.success(pageResult);
    }
}
