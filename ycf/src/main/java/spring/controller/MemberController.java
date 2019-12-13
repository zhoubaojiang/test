package spring.controller;

import org.springframework.validation.annotation.Validated;
import spring.dto.BaseCommonResult;
import spring.dto.request.MemberCarListRequest;
import spring.dto.request.MemberCarRequest;
import spring.dto.request.MemberRequest;
import spring.dto.result.BasePage;
import spring.dto.result.MemberCarResult;
import spring.dto.result.MemberLoginResponse;
import spring.member.service.MemberService;
import spring.model.UMemberReceiveAddress;
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

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody BaseCommonResult<MemberLoginResponse>  login(@RequestBody MemberRequest record) {
        return userService.login(record);
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

    @ApiOperation(value = "添加购物车", notes = "添加购物车")
    @RequestMapping(value = "/car/add", method = RequestMethod.POST)
    public BaseCommonResult addCar(@Validated @RequestBody MemberCarRequest request){
        return userService.addCar(request);
    }

    @ApiOperation(value = "删除购物车", notes = "删除购物车")
    @RequestMapping(value = "/car/delete", method = RequestMethod.POST)
    public BaseCommonResult deleteCar(@Validated @RequestBody MemberCarRequest request){
        return userService.deleteCar(request);
    }

    @ApiOperation(value = "查询购物车")
    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public @ResponseBody BaseCommonResult<BasePage<MemberCarResult>>  memberCarList(@Validated @RequestBody MemberCarListRequest request) {
        return userService.memberCarList(request);
    }

}
