package spring.dto.result;

import lombok.Data;

import java.util.Date;

/**
 * 验证码Redis
 */
@Data
public class UserVerificationCodeVO {

    /**
     * 用户类型:member:会员
     */
    private String userType;

    /**
     * 验证码类型:1:忘记密码找回、2:注册、3:旧手机验证、4:新手机绑定、5:会员福豆转账验证
     */
//    private String type;

    /**
     * 手机号码或邮箱地址
     */
    private String account;

    /**
     * 验证码
     */
    private String code;

    /**
     * 电话区号
     */
//    private String telephoneCode;

    /**
     * 创建时间
     */
    private Date createDate;

}
