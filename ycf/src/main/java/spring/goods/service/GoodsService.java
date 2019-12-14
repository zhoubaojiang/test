package spring.goods.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Transient;
import spring.dto.BaseCommonResult;
import spring.dto.result.BasePage;
import spring.exception.GoodsException;
import spring.goods.dto.request.GoodsListReq;
import spring.goods.dto.request.GoodsListRequest;
import spring.goods.dto.request.GoodsMemberRequset;
import spring.goods.dto.request.RecommendedRequest;
import spring.goods.dto.response.GoodsDetailsResponse;
import spring.goods.dto.response.GoodsMemberResponse;
import spring.goods.dto.response.GoodsStateResponse;
import spring.goods.dto.response.RecommendedResponse;
import spring.mapper.PFirstFictureMapper;
import spring.mapper.cvs.GoodsMapper;
import spring.mapper.PGoodsMapper;
import spring.model.PFirstFicture;
import spring.model.PFirstFictureExample;
import spring.model.PGoods;
import spring.model.PGoodsExample;
import spring.utils.ResultBuilder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class GoodsService {

    @Autowired
    private DozerBeanMapper dozer;
    @Autowired
    private PGoodsMapper pGoodsMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Value("${ycf.picUrl}")
    private String picUrl;
    @Autowired
    private PFirstFictureMapper pFirstFictureMapper;

    /**
     * 添加商品
     * @param request
     * @return
     */
    @Transient
    public BaseCommonResult<PGoods> createGoods(GoodsListRequest request) {
        log.info("请求参数:{}",request);
        request.setIsDelete(1);
        request.setGoodsNumType(1);
        request.setGoodsState(1);
        request.setGoodsType(0);
        PGoods map = dozer.map(request, PGoods.class);
        map.setCreateTime(new Date());
        int i = pGoodsMapper.insertSelective(map);
        log.info("返回参数:{}",map);
        return ResultBuilder.success(map);
    }

    /**
     * 修改商品
     * @param request
     * @return
     */
    @Transient
    public BaseCommonResult<PGoods>
    update( GoodsListRequest request) {
        log.info("请求参数:{}",request);
        PGoods map = dozer.map(request, PGoods.class);
        int i = pGoodsMapper.updateByPrimaryKeySelective(map);
        log.info("返回参数:{}",map);
        return ResultBuilder.success(map);
    }

    /**
     * 查询列表
     * @param request
     * @return
     */
    public BaseCommonResult<BasePage<PGoods>> list(GoodsListReq request) {
        BasePage<PGoods> pageResult = new BasePage();
        log.info("分页查询商品列表,请求参数为：{}", request);
        try {
            PageHelper.startPage(request.getPage(), request.getPageSize());
            List<PGoods> list = goodsMapper.selectGoodsList(request);
//            for (PGoods goods:list) {
//                if (goods.getMasterGraph()!= null){
//                    goods.setMasterGraph(picUrl+goods.getMasterGraph());
//                }
//                if (goods.getGoodsPicture()!=null){
//                    goods.setGoodsPicture(split(goods.getGoodsPicture().split(",")));
//                }
//            }
            PageInfo<PGoods> pageInfo = new PageInfo<>(list);
            pageResult.setList(list);
            pageResult.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal());
        }catch (GoodsException e) {
            log.info("分页查询商品列表异常，异常信息为：{}", e);
            ResultBuilder.fail("系统异常");
        }
        log.info("分页查询商品列表接口结束");
        return ResultBuilder.success(pageResult);
    }
    //图片拼接URL
    public String split(String[] split){
        String pic = null;
        int i = 0;
        for ( String s :split) {
            pic = picUrl +s;
            i++;
            if (i != 0){
                pic =pic + ","+ picUrl +s;
            }
        }
        return pic;
    }
    /**
     * 新品推荐
     * @param requset
     * @return
     */
    public BaseCommonResult<BasePage<GoodsMemberResponse>> goodsMemberGoods(GoodsMemberRequset requset) {
        BasePage<GoodsMemberResponse> pageResult = new BasePage();
        log.info("会员新品分页查询商品列表,请求参数为：{}", requset);
        try {
            PageHelper.startPage(requset.getPage(), requset.getPageSize());
            PGoodsExample example = new PGoodsExample();
            example.createCriteria().andGoodsTypeEqualTo(0).andGoodsStateEqualTo(0).andGoodsNumTypeEqualTo(1);
            example.setOrderByClause("create_time desc");
            List<PGoods> list = pGoodsMapper.selectByExample(example);
            for (PGoods goods:list ) {
                if (goods.getMasterGraph()!= null){
                    goods.setMasterGraph(goods.getMasterGraph());
                }
                if (goods.getGoodsPicture()!=null){
                    goods.setGoodsPicture(split(goods.getGoodsPicture().split(",")));
                }
            }
          List<GoodsMemberResponse> goodsMemberResponseList = new ArrayList<>();
            if (list.size()>0){
                for (PGoods  goods:list) {
                    GoodsMemberResponse map = dozer.map(goods, GoodsMemberResponse.class);
                    goodsMemberResponseList.add(map);
                }
            }
            PageInfo<GoodsMemberResponse> pageInfo = new PageInfo<>(goodsMemberResponseList);
            pageResult.setList(goodsMemberResponseList);
            pageResult.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal());
        }catch (GoodsException e) {
            log.info("会员新品分页查询商品列表异常，异常信息为：{}", e);
            ResultBuilder.fail("系统异常");
        }
        log.info("会员新品分页查询商品列表接口结束");
        return ResultBuilder.success(pageResult);
    }

    /**
     * 底部推荐
     * @param requset
     * @return
     */
    public BaseCommonResult<BasePage<RecommendedResponse>> recommendedlist(RecommendedRequest requset) {
        BasePage<RecommendedResponse> pageResult = new BasePage();
        log.info("会员底部推荐分页查询商品列表,请求参数为：{}", requset);
        try {
            PageHelper.startPage(requset.getPage(), requset.getPageSize());
            List<RecommendedResponse> list = goodsMapper.selectRecommendedlist(requset);
            for (RecommendedResponse response:list) {
                if (response.getPic()!=null){
                    response.setPic(response.getPic());
                }
            }
            PageInfo<RecommendedResponse> pageInfo = new PageInfo<>(list);
            pageResult.setList(list);
            pageResult.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal());
        }catch (GoodsException e) {
            log.info("会员底部推荐分页查询商品列表异常，异常信息为：{}", e);
            ResultBuilder.fail("系统异常");
        }
        log.info("会员底部推荐分页查询商品列表接口结束");
        return ResultBuilder.success(pageResult);
    }

    /**
     * 搜索栏
     * @param requset
     * @return
     */
    public BaseCommonResult<BasePage<RecommendedResponse>> searchlist(RecommendedRequest requset) {
        BasePage<RecommendedResponse> pageResult = new BasePage();
        log.info("会员底部推荐分页查询商品列表,请求参数为：{}", requset);
        try {
            PageHelper.startPage(requset.getPage(), requset.getPageSize());
            List<RecommendedResponse> list = goodsMapper.searchlist(requset);
            for (RecommendedResponse response:list) {
                if (response.getPic()!=null){
                    response.setPic(response.getPic());
                }
            }
            PageInfo<RecommendedResponse> pageInfo = new PageInfo<>(list);
            pageResult.setList(list);
            pageResult.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal());
        }catch (GoodsException e) {
            log.info("会员底部推荐分页查询商品列表异常，异常信息为：{}", e);
            ResultBuilder.fail("系统异常");
        }
        log.info("会员底部推荐分页查询商品列表接口结束");
        return ResultBuilder.success(pageResult);
    }

    /**
     * 商品详情
     * @param id
     * @return
     */
    public BaseCommonResult<GoodsDetailsResponse> goodsDetails(Long id) {
        log.info("商品详情查询ID: {}",id);
        PGoods goods = pGoodsMapper.selectByPrimaryKey(id);
        GoodsDetailsResponse map = dozer.map(goods, GoodsDetailsResponse.class);
        map.setMasterGraph(map.getMasterGraph());
        log.info("商品详情查询返回: {}",map);
        return ResultBuilder.success(map);
    }

    public BaseCommonResult<GoodsStateResponse> goodsState() {
        PGoodsExample example = new PGoodsExample();
        GoodsStateResponse goodsStateResponse = new GoodsStateResponse();
        goodsStateResponse.setGoodsNumber(pGoodsMapper.countByExample(example));
        example.createCriteria().andGoodsStateEqualTo(0).andIsDeleteEqualTo(1);
        goodsStateResponse.setUpper(pGoodsMapper.countByExample(example));
        example.clear();
        example.createCriteria().andGoodsStateEqualTo(1).andIsDeleteEqualTo(1);
        goodsStateResponse.setLower(pGoodsMapper.countByExample(example));
        example.clear();
        example.createCriteria().andGoodsNumTypeEqualTo(0);
        goodsStateResponse.setSell(pGoodsMapper.countByExample(example));
        return ResultBuilder.success(goodsStateResponse);
    }

    public BaseCommonResult<List<PFirstFicture>> picList() {
        PFirstFictureExample example = new PFirstFictureExample();
        List<PFirstFicture> pFirstFictures = pFirstFictureMapper.selectByExample(example);
        if (pFirstFictures.size()>0){
            for (PFirstFicture pFirstFicture:pFirstFictures) {
                pFirstFicture.setPicUrl(pFirstFicture.getPicUrl());
            }
        }
        return ResultBuilder.success(pFirstFictures);
    }
}
