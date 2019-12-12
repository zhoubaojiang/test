package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.dto.BaseCommonResult;
import spring.dto.request.UserFileUploadRequest;
import spring.service.AliYunService;

@Api(tags = "图片上传",basePath = "/picCenter/pic")
@RequestMapping("/picCenter/pic")
@RestController
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

}
