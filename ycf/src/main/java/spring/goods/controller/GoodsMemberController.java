package spring.goods.controller;

import spring.dto.BaseCommonResult;
import spring.dto.result.BasePage;
import spring.goods.dto.request.GoodsListReq;
import spring.goods.dto.request.GoodsListRequest;
import spring.goods.dto.request.GoodsMemberRequset;
import spring.goods.dto.request.RecommendedRequest;
import spring.goods.dto.response.GoodsDetailsResponse;
import spring.goods.dto.response.GoodsMemberResponse;
import spring.goods.dto.response.RecommendedResponse;
import spring.goods.service.GoodsService;
import spring.model.PFirstFicture;
import spring.model.PGoods;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description = "会员商品信息相关接口列表", basePath = "/goodsCenter/member/goods")
@RestController
@RequestMapping("/goodsCenter/member/goods")
public class GoodsMemberController {

    @Autowired
    private GoodsService goodsService;

    /**
     *
     * 功能描述:商品列表
     * @return
     */
    @ApiOperation(value = "分页查询新品推荐商品列表", httpMethod = "GET")
    @RequestMapping(value = "/good", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody BaseCommonResult<BasePage<GoodsMemberResponse>> list(GoodsMemberRequset requset) {
        return goodsService.goodsMemberGoods(requset);
    }

    /**
     *
     * 功能描述:商品列表
     * @return
     */
    @ApiOperation(value = "分页查询底部推荐栏列表", httpMethod = "GET")
    @RequestMapping(value = "/recommended/good", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody BaseCommonResult<BasePage<RecommendedResponse>> recommendedlist(RecommendedRequest requset) {
        return goodsService.recommendedlist(requset);
    }
    /**
     *
     * 功能描述:商品列表
     * @return
     */
    @ApiOperation(value = "分页查询底部推荐栏列表", httpMethod = "GET")
    @RequestMapping(value = "/search/good", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody BaseCommonResult<BasePage<RecommendedResponse>> searchlist(RecommendedRequest requset) {
        return goodsService.searchlist(requset);
    }

    /**
     *
     * 功能描述:商品详情
     * @return
     */
    @ApiOperation(value = "商品详情", httpMethod = "GET")
    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody BaseCommonResult<GoodsDetailsResponse> goodsDetails(@RequestParam(name="id") Long id) {
        return goodsService.goodsDetails(id);
    }

    /**
     *
     * 功能描述:商品详情
     * @return
     */
    @ApiOperation(value = "多个商品详情", httpMethod = "GET")
    @RequestMapping(value = "/ids/detail", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody BaseCommonResult<List<GoodsDetailsResponse>> goodsIdsDetails(@RequestParam(name="ids") String ids) {
        return goodsService.goodsIdsDetails(ids);
    }

    /**
     *
     * 功能描述:商品详情
     * @return
     */
    @ApiOperation(value = "小程序首页图", httpMethod = "GET")
    @RequestMapping(value = "/picList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody BaseCommonResult<List<PFirstFicture>> picList() {
        return goodsService.picList();
    }
}
