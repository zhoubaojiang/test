package spring.exception;

import lombok.Getter;
import spring.enums.UserErrorCodeEnum;

/** 异常处理
 */
public class UserException extends BaseServiceException {
    @Getter
    private Integer errorCode;
    @Getter
    private String errorReason;

    /**
     * 构造器
     * @param errorCode 错误码
     * @param errorReason 错误原因
     */
    public UserException(Integer errorCode,String errorReason){
        super(errorCode,errorReason);
        this.errorCode = errorCode;
        this.errorReason = errorReason;
    }

    /**
     * 构造器
     * @param errorCodeEnum 错误码枚举
     */
    public UserException(UserErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getCode(),errorCodeEnum.getMsg());
        this.errorCode = errorCodeEnum.getCode();
        this.errorReason = errorCodeEnum.getMsg();
    }

    /**构造器
     * @param msg 错误信息描述
     */
    public UserException(String msg){
        super(UserErrorCodeEnum.FAIL.getCode(),msg);
    }

}
