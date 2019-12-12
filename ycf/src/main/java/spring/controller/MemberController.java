package spring.controller;

import org.springframework.validation.annotation.Validated;
import spring.dto.BaseCommonResult;
import spring.dto.request.MemberRequest;
import spring.dto.result.MemberLoginResponse;
import spring.member.service.MemberService;
import spring.model.UMemberReceiveAddress;
import spring.model.UUserMember;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Logger
@Api(tags = "/memberCenter/members", description = "会员管理")
@RequestMapping("/memberCenter/members")
public class MemberController {
    @Autowired
    private MemberService userService;

    @ApiOperation("注册用户")
    @RequestMapping(value = "/member", method = RequestMethod.POST)
    public @ResponseBody BaseCommonResult<UUserMember> register(@RequestBody MemberRequest record) {
        return userService.register(record);
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login/{code}", method = RequestMethod.GET)
    public @ResponseBody BaseCommonResult<MemberLoginResponse>  login(@PathVariable String code) {
        return userService.login(code);
    }

    @ApiOperation(value = "登出")
    @RequestMapping(value = "/logout/{code}", method = RequestMethod.GET)
    public @ResponseBody BaseCommonResult loginOut(@PathVariable String code) {
        return userService.loginOut(code);
    }


    @ApiOperation(value = "鱿费查询")
    @RequestMapping(value = "/money/{code}", method = RequestMethod.GET)
    @ResponseBody
    public BaseCommonResult getMoney(@PathVariable String code) {
        return userService.getMoney(code);
    }

    @ApiOperation(value = "会员收货地址添加", notes = "会员收货地址添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseCommonResult add(@Validated @RequestBody UMemberReceiveAddress request){
        return userService.add(request);
    }

    @ApiOperation(value = "会员收货地址修改", notes = "会员收货地址修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody BaseCommonResult update(@Validated @RequestBody UMemberReceiveAddress request){
        return userService.update(request);
    }

}
