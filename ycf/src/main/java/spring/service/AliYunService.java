package spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import spring.dto.BaseCommonResult;
import spring.dto.request.UserFileUploadRequest;
import spring.dto.result.UserFileUploadResult;
import spring.enums.UserErrorCodeEnum;
import spring.exception.UserException;
import spring.utils.ThreadPoolManager;
import spring.utils.alioss.OSSClientUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

@Slf4j
@Component
public class AliYunService  {

    @Value("${aliyunOSS.logoFileDir}")
    private String logoFileDir;
    @Autowired
    private OSSClientUtil ossClientUtil;
    /**图片上传 */
    public BaseCommonResult upload(UserFileUploadRequest request) throws UserException, ExecutionException, InterruptedException {
        log.info("图片上传请求参数:{}",request);
        // 文件重复上传
        if(request.isRepeatUpload()){
            boolean b = ossClientUtil.deleteImg(request.getImgUrl());
            if(!b){
                log.error("删除图片失败,请求参数:{}",request);
                throw new UserException(UserErrorCodeEnum.LOGIC_FAIL.getCode(),"删除图片失败");
            }
        }
        FutureTask<UserFileUploadResult> futureTask = new FutureTask<>(new Callable<UserFileUploadResult>() {
            @Override
            public UserFileUploadResult call() throws Exception {
                return uploadFile(request,logoFileDir);
            }
        });
        Future<?> future = ThreadPoolManager.getInstance().addExecuteTask(futureTask);
        BaseCommonResult result = new BaseCommonResult();
        result.setCode(UserErrorCodeEnum.SUCCESS.getCode());
        result.setData(futureTask.get());

        return result;
    }

    public UserFileUploadResult uploadFile(UserFileUploadRequest request, String filedir) throws UserException {
        UserFileUploadResult uploadResult = new UserFileUploadResult();
        try {
            // 上传图片
            MultipartFile file = request.getPicUpload();
            String subString = ossClientUtil.uploadImg(file.getInputStream(),file.getOriginalFilename(), filedir);
            uploadResult.setImgUrl(subString);
        } catch (Exception e) {
            log.error("文件上传出错,异常信息:{}",e);
            log.error("文件上传出错,请求参数:{}",request);
            throw new UserException(UserErrorCodeEnum.UPLOAD_FAIL.getCode(), UserErrorCodeEnum.UPLOAD_FAIL.getMsg());
        }
        return uploadResult;
    }


}
