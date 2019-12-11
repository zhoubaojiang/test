package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author wangdg
 * @ClassName: UserFileUploadResult
 * @Description: 用户文件上传结果集
 * @date 2017/7/5 17:24
 */
@Setter@Getter
public class UserFileUploadResult implements Serializable{

    /** 截取后的url*/
    @ApiModelProperty(value = "截取后的url")
    private String imgUrl;
}
