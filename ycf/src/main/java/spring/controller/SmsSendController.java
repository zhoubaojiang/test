package spring.controller;

import com.aliyuncs.CommonResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.config.alioss.AliyunSmsUtils;
import spring.config.redis.util.JedisUtils;
import spring.dto.BaseCommonResult;
import spring.dto.request.UserAccountRequest;
import spring.dto.result.UserVerificationCodeVO;
import spring.enums.UserErrorCodeEnum;
import spring.exception.UserConstants;
import spring.utils.GenerateCodeUtil;
import spring.utils.ResultBuilder;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "短信发送",basePath = "/smsCenter/sms")
@RequestMapping("/smsCenter/sms")
@RestController
@Slf4j
public class SmsSendController {

    @ApiOperation(value = "短信发送", notes = "短信发送")
    @RequestMapping(value = "/send/{phone}", method = RequestMethod.GET)
    public BaseCommonResult sendSms(@PathVariable String phone) throws ClientException, ParseException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        JedisUtils obj = JedisUtils.getJedisInstance();
        //获取redis中的验证码
        String redisKey= MessageFormat.format(UserConstants.USER_CODE_REDIS_PREFIX,UserConstants.USER_TYPE_MEMBER,phone);
       String sms = obj.execHgetToCache(redisKey, "code");
       log.info("sms  code 码=========",sms);
       if(sms != null){
         return   ResultBuilder.fail("请五分钟后再获取验证码!");
       }
        //短信参数内容
        String sendCode = this.getVerificationCode(phone, UserConstants.USER_TYPE_MEMBER);
        CommonResponse commonResponse = null;
        try {
             commonResponse = AliyunSmsUtils.sendSmsCode(phone, sendCode);
        }catch (Exception e){
            log.info("短信发送失败:{}",e.getMessage());
            return ResultBuilder.fail("短信发送失败");
        }
        log.info("sendSmsResponse:{}",commonResponse);
        HashMap<String, String> map = new HashMap();
        map.put("code",sendCode);
        log.info("短信验证码:{}",sendCode);
        //redis信息内容
        UserVerificationCodeVO vo=new UserVerificationCodeVO();
        vo.setAccount(phone);
        vo.setCode(sendCode);
        vo.setCreateDate(new Date());         //创建时间
        vo.setUserType(UserConstants.USER_TYPE_MEMBER);             //用户类型:member:会员
        // 保存到Redis中
        insertVerificationCodeRedis(vo);
        return ResultBuilder.success();
    }

    @ApiOperation(value = "短信验证", notes = "短信验证")
    @RequestMapping(value = "/send/{phone}/{code}", method = RequestMethod.GET)
    public BaseCommonResult smsCode(@PathVariable String phone,@PathVariable String code){
        JedisUtils obj = JedisUtils.getJedisInstance();
        String redisKey=MessageFormat.format(UserConstants.USER_CODE_REDIS_PREFIX,UserConstants.USER_TYPE_MEMBER,phone);
        //获取redis中的验证码
        String smscode = obj.execHgetToCache(redisKey, "code");
        log.info("会员手机短信验证code,参数为:{}", smscode);
        //redis中无验证码
        if (StringUtils.isBlank(code)) {
            return ResultBuilder.fail(UserErrorCodeEnum.CODEFAIL.getCode(),UserErrorCodeEnum.CODEFAIL.getMsg());
        }
        if (!smscode.equals(code)){
            return   ResultBuilder.fail("验证码错误!");
        }
      return   ResultBuilder.success();
    }




    private String getVerificationCode(String account,String userType) throws ParseException {
        JedisUtils obj = JedisUtils.getJedisInstance();
        String redisKey=MessageFormat.format(UserConstants.USER_CODE_REDIS_PREFIX,userType,account);
        //获取redis中的验证码
        String code = obj.execHgetToCache(redisKey, "code");
        //redis中无验证码则生成新的验证码
        if (StringUtils.isBlank(code)) {
            return this.generateVerificationCode();
        }
        return code;
    }
    /**
     * 保存验证码到Redis
     */
    public void insertVerificationCodeRedis(UserVerificationCodeVO vo) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        //300=5分钟
        int seconds = 300;
        String redisKey=MessageFormat.format(UserConstants.USER_CODE_REDIS_PREFIX,vo.getUserType(),vo.getAccount());
        Map<String, String> map = Maps.newHashMap();
        if (vo != null) {
            BeanMap beanMap = BeanMap.create(vo);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", ""+beanMap.get(key));
            }
        }
        JedisUtils.getJedisInstance().execHmsetToCache(redisKey, map);
        JedisUtils.getJedisInstance().execExpireToCache(redisKey, seconds);// 设置过期时间
    }
    /**
     * 生成验证码
     */
    private String generateVerificationCode(){
        //验证码长度
        Integer codeLength=4;
        //生成验证码
        String sendCode = GenerateCodeUtil.getVerificationCode(codeLength, false);
        return sendCode;
    }
}
