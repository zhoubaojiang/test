package spring.exception;

import lombok.Getter;
import spring.enums.UserErrorCodeEnum;

/**
 * @ClassName: MemberException
 * @Description:  会员异常
 */
public class MemberException extends RuntimeException{
    @Getter
    private Integer errorCode;
    @Getter
    private String errorReason;

    /**
     * 构造器
     * @param errorCode 错误码
     * @param errorReason 错误原因
     */
    public MemberException(Integer errorCode, String errorReason){
        super("["+errorCode+"]"+errorReason);
        this.errorCode = errorCode;
        this.errorReason = errorReason;
    }

    /**
     * 构造器
     * @param errorCodeEnum 错误码枚举
     */
    public MemberException(UserErrorCodeEnum errorCodeEnum){
        super("["+errorCodeEnum.getCode()+"]"+errorCodeEnum.getMsg());
        this.errorCode = errorCodeEnum.getCode();
        this.errorReason = errorCodeEnum.getMsg();
    }

    /**构造器
     * @param msg 错误信息描述
     */
    public MemberException(String msg){
        super("["+UserErrorCodeEnum.FAIL.getCode()+"]"+msg);
        this.errorCode = UserErrorCodeEnum.FAIL.getCode();
        this.errorReason = msg;
    }
}
