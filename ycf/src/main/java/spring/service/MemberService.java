package spring.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Transient;
import spring.dto.BaseCommonResult;
import spring.dto.request.*;
import spring.dto.result.BasePage;
import spring.dto.result.MemberCarResult;
import spring.dto.result.MemberLoginResponse;
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
import spring.wechat.service.WechatService;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @Autowired
    private WechatService wechatService;

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
        String operatorid = null;
        try {
             operatorid = wechatService.getOpenid(record.getAppId());
        } catch (Exception e) {
           log.error("获取微信OPPENID错误:{}",e);
           ResultBuilder.fail("授权失败");
        }
        record.setAppId(operatorid);
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
    //获取会员信息
    public BaseCommonResult getMoney(String code) {
        UUserMemberExample example = new UUserMemberExample();
        example.createCriteria().andAppIdEqualTo(code);
        List<UUserMember> uUserMembers = userMemberMapper.selectByExample(example);
        if (uUserMembers.size()<=0){
            return ResultBuilder.fail("非法请求");
        }
        return ResultBuilder.success(uUserMembers.get(0));
    }
    //添加会员收货地址
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
    //修改会员收货地址
    @Transient
    public BaseCommonResult update(MemberReceiveAddressReq request) {
        if (request.getIsDelete()!= null&&request.getIsDelete()==0){
            memberReceiveAddressMapper.deleteByPrimaryKey(request.getId());
            return ResultBuilder.success();
        }
        //默认地址修改
        if (request.getDefaultStatus()==0){
            UMemberReceiveAddressExample example = new UMemberReceiveAddressExample ();
            example.createCriteria().andMemberIdEqualTo(request.getMemberId()).andDefaultStatusEqualTo(0);
            List<UMemberReceiveAddress> uMemberReceiveAddresses = memberReceiveAddressMapper.selectByExample(example);
            if (uMemberReceiveAddresses.size()>0){
                UMemberReceiveAddress memberReceiveAddress = uMemberReceiveAddresses.get(0);
                UMemberReceiveAddress record = new UMemberReceiveAddress ();
                record.setId(memberReceiveAddress.getId());
                record.setDefaultStatus(1);
                memberReceiveAddressMapper.updateByPrimaryKeySelective(record);
            }
        }

        UMemberReceiveAddress map = dozerMapper.map(request, UMemberReceiveAddress.class);
        memberReceiveAddressMapper.updateByPrimaryKeySelective(map);
        return ResultBuilder.success(request);
    }
    //添加会员购物信息
    @Transient
    public BaseCommonResult addCar(MemberCarRequest request) {
        MMemberCar record = new MMemberCar();
        record.setMemberId(request.getMemberId());
        MMemberCarExample example = new MMemberCarExample();
        example.createCriteria().andMemberIdEqualTo(request.getMemberId());
        List<MMemberCar> mMemberCars = mMemberCarMapper.selectByExample(example);
        if (mMemberCars.size()>0){
            record = mMemberCars.get(0);
        }else {
            record.setCreateTime(new Date());
            mMemberCarMapper.insertSelective(record);
        }
        //插入中间表
        MMemberCarDetail memberCarDetail = new MMemberCarDetail();
        memberCarDetail.setGoodsId(request.getGoodsId());
        memberCarDetail.setMemberCarId(record.getId());
        mMemberCarDetailMapper.insertSelective(memberCarDetail);
        return ResultBuilder.success(record);
    }
    //删除会员购物车
    @Transient
    public BaseCommonResult deleteCar(MemberCarRequest request) {
        log.info("会员购物车删除,请求参数为：{}", request);
        MMemberCarDetailExample example = new MMemberCarDetailExample();
        example.createCriteria().andGoodsIdEqualTo(request.getGoodsId()).andIdEqualTo(request.getMemberCarDetailId());
        int i = mMemberCarDetailMapper.deleteByExample(example);
        log.info("会员购物车删除,成功：{}", i);
        return ResultBuilder.success();
    }
    //查询会员购物车
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
    //查询会员收货地址
    public BaseCommonResult getAddress(AddressRequest addressRequest) {
        UMemberReceiveAddressExample example = new UMemberReceiveAddressExample();
        UMemberReceiveAddressExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(Long.parseLong(addressRequest.getUserId()));
        if (addressRequest.getAddressId() != null){
            criteria.andIdEqualTo(Long.parseLong(addressRequest.getAddressId()));
        }
        if (addressRequest.getDefaultStatus() != null){
            criteria.andDefaultStatusEqualTo(addressRequest.getDefaultStatus());
        }
        List<UMemberReceiveAddress> uMemberReceiveAddresses = memberReceiveAddressMapper.selectByExample(example);
        return ResultBuilder.success(uMemberReceiveAddresses);
    }

    /**
     * 手机号正则表达式
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        String s2="^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";// 验证手机号
        if(StringUtils.isNotBlank(str)){
            p = Pattern.compile(s2);
            m = p.matcher(str);
            b = m.matches();
        }
        return b;
    }
    public BaseCommonResult binding(BinDingPhonRequest request) {
        boolean mobile = isMobile(request.getPhone());
        if (!mobile){
            return  ResultBuilder.fail("手机格式不正确!");
        }
        UUserMember record = new UUserMember ();
        record.setId(request.getMemberId());
        record.setPhone(request.getPhone());
        userMemberMapper.updateByPrimaryKeySelective(record);
        return ResultBuilder.success(record);
    }
}
