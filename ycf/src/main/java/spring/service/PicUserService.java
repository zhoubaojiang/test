package spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.dto.BaseCommonResult;
import spring.dto.request.MultipartUploadRequest;
import spring.dto.request.UserFileUploadRequest;
import spring.enums.UserErrorCodeEnum;
import spring.exception.UserException;

@Slf4j
@Service
public class PicUserService {
    @Autowired
    private  AliYunService aliYunService;

    public BaseCommonResult upload(UserFileUploadRequest request) throws Exception {
        log.info("用户文件上传,请求参数为：{}", request);
        BaseCommonResult result = new BaseCommonResult();
        MultipartFile file = request.getPicUpload();
        long size = file.getSize();
        if (size > 5242880) {
            throw new UserException(UserErrorCodeEnum.FAIL.getCode(), "文件上传失败,文件大小不能超过:5M");
        }
        try {
            result = aliYunService.upload(request);
        } catch (UserException u) {
            result.setCode(u.getErrorCode());
            result.setMsg(u.getErrorReason());
            log.error("用户文件上传，异常信息为：{}", u);
        } catch (Exception e) {
            result.setCode(UserErrorCodeEnum.FAIL.getCode());
            result.setMsg(e.getMessage());
            log.info("用户文件上传,请求参数为：{}", e);
        }
        log.info("用户文件上传,返回结果为：{}", result);
        return result;
    }

}
