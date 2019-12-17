package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import spring.dto.BaseCommonResult;
import spring.dto.request.UserFileUploadRequest;
import spring.service.AliYunService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Api(tags = "图片上传",basePath = "/picCenter/pic")
@RequestMapping("/picCenter/pic")
@RestController
@Slf4j
public class PicUploadController {
    @Autowired
    private AliYunService aliYunService;
    /**  图片上传 */
    @ApiOperation(value = "图片上传", notes = "图片上传")
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    @ResponseBody
    public BaseCommonResult upload( UserFileUploadRequest request)throws Exception {
        return aliYunService.upload(request);
    }

    @RequestMapping(value = "/weChat/uploadImage", method = { RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BaseCommonResult uploadImage(HttpServletRequest request, HttpServletResponse response) throws IOException, ExecutionException, InterruptedException {
        log.info("图片上传开始");
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        log.info("图片上传开始:{}",req);
        MultipartFile multipartFile =  req.getFile("file");
        log.info("图片上传:{}",multipartFile);

        UserFileUploadRequest r = new UserFileUploadRequest();
        r.setPicUpload(multipartFile);
        return aliYunService.upload(r);
    }

}
