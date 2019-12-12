package spring.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangdg
 * @Description: 多文件上传请求类
 * @date 2017/8/4 9:44
 */
@Data
public class MultipartUploadRequest {

    /** 多文件的数组 */
    @ApiModelProperty(value = "多文件的数组")
    private MultipartFile[] files;
    /** 文件类型 */
    @ApiModelProperty(value = "文件类型")
    private Integer type;

}
