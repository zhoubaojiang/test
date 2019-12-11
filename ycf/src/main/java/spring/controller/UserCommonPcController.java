package spring.controller;

import spring.dto.BaseCommonResult;
import spring.dto.request.UserAccountRequest;
import spring.dto.request.UserLoginDto;
import spring.dto.result.UserLoginResponse;
import spring.service.UserCommonRegistryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员、商家 、代理商注册接口
 */
@Api(tags = "PC ==> 后台管理信息",basePath = "/userCenter/pc/users")
@RequestMapping("/userCenter/pc/users")
@RestController
public class UserCommonPcController {
    @Autowired
    private UserCommonRegistryService userCommonRegistryService;


    @ApiOperation(value = "管理添加", notes = "管理添加")
    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    public BaseCommonResult createAccount(@Validated @RequestBody UserAccountRequest request){
        return userCommonRegistryService.createAccount(request);
    }
    @ApiOperation(value = "管理员登录", notes = "管理员登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseCommonResult<UserLoginResponse> userLogin(@Validated @RequestBody UserLoginDto loginDto) {
        return userCommonRegistryService.userLogin(loginDto);
    }

    @ApiOperation(value = "管理员登出", notes = "管理员登出")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public BaseCommonResult<UserLoginResponse> userLogout(@Validated @RequestBody UserLoginDto loginDto) {
        return userCommonRegistryService.userLogout(loginDto);
    }

    @ApiOperation(value = "管理修改", notes = "管理修改")
    @RequestMapping(value = "/update/user", method = RequestMethod.POST)
    public BaseCommonResult updateAccount(@Validated @RequestBody UserAccountRequest request){
        return userCommonRegistryService.updateAccount(request);
    }
}
