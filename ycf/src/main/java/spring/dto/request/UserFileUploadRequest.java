package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangdg
 * @ClassName: UserUploadRequest
 * @Description: 用户文件上传
 * @date 2017/7/5 17:00
 */
@Data
public class UserFileUploadRequest {
    /** 上传的文件 */
    @ApiModelProperty(value = "上传的文件")
    private MultipartFile file;
//    /** 上传的文件类型 */
    @ApiModelProperty(value = "上传的文件类型")
    private Integer type;
    /** 是否需要覆盖上次上传图片 */
    @ApiModelProperty(value = "是否需要覆盖上次上传图片")
    private boolean isRepeatUpload;
    /** 需要覆盖的图片url */
    @ApiModelProperty(value = "需要覆盖的图片url")
    private String imgUrl;

}
