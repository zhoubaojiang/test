package spring.goods.service;

import spring.dto.BaseCommonResult;
import spring.exception.GoodsException;
import spring.goods.common.GoodsApiCode;
import spring.goods.common.GoodsConstants;
import spring.goods.dto.request.GoodsTypeAddRequest;
import spring.goods.dto.request.GoodsTypeAllListRequest;
import spring.goods.dto.request.GoodsTypeListRequest;
import spring.goods.dto.request.GoodsTypeUpdateRequest;
import spring.goods.dto.response.*;
import spring.mapper.PAttrTypeRelationMapper;
import spring.mapper.PGoodsTypeManualMapper;
import spring.mapper.PGoodsTypeMapper;
import spring.model.PAttrTypeRelation;
import spring.model.PAttrTypeRelationExample;
import spring.model.PGoodsType;
import spring.model.PGoodsTypeExample;
import spring.utils.GoodsUrlUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GoodsTypeService {
    @Autowired
    private DozerBeanMapper dozer;
    @Autowired
    PGoodsTypeMapper goodsTypeMapper;
    @Autowired
    private PAttrTypeRelationMapper attrTypeRelationMapper;
    @Autowired
    private PGoodsTypeManualMapper goodsTypeManualMapper;
    @Autowired
    IGoodsService iGoodsService;



    @Transactional
    public BaseCommonResult<Void> add(GoodsTypeAddRequest request) {
        BaseCommonResult<Void> result = new BaseCommonResult<>();
        log.info("商品分类-商品分类新增--开始, 请求信息：{}", request);
        try{
            PGoodsType goodsType = new PGoodsType();
            dozer.map(request, goodsType);
            goodsType.setIsdelete(new Byte("0"));
            Byte level = 1;
            if(goodsType.getPid() == null ||goodsType.getPid() == 0){
                level = GoodsConstants.GOODS_TYPE_LEVEL_ONE;
            }else{
                PGoodsType parentGoodsType = goodsTypeMapper.selectByPrimaryKey(goodsType.getPid());
                if(GoodsConstants.GOODS_TYPE_LEVEL_ONE .equals(parentGoodsType.getLevel())){
                    level = GoodsConstants.GOODS_TYPE_LEVEL_TWO;
                }else if(GoodsConstants.GOODS_TYPE_LEVEL_TWO .equals(parentGoodsType.getLevel())){
                    level = GoodsConstants.GOODS_TYPE_LEVEL_THREE;
                }
            }
            goodsType.setLevel(level);
            goodsTypeMapper.insertSelective(goodsType);
            Integer goodsTypeId = goodsType.getId();
            //关联attr属性
            Integer[] attrIds = request.getAttrIds();
            for(Integer attrId :attrIds){
                PAttrTypeRelation attrTypeRelation =  new PAttrTypeRelation();
                attrTypeRelation.setAttrId(attrId);
                attrTypeRelation.setGoodsTypeId(goodsTypeId);
                attrTypeRelationMapper.insert(attrTypeRelation);
            }
        }catch(GoodsException e){
            log.info("商品分类-商品分类新增--结束, 信息：{}", e.getMessage());
            throw new GoodsException(e.getResponseCode(), e.getResponseMsg());
        }catch(Exception e){
            log.info("商品分类-商品分类新增--结束, 信息：{}", e);
            throw new GoodsException(GoodsApiCode.ADD_GOODS_TYPE,GoodsApiCode.getZhMsg(GoodsApiCode.ADD_GOODS_TYPE));
        }
        log.info("商品分类-商品分类新增--结束, 返回信息：{}", result);
        return result;
    }
    public BaseCommonResult<List<GoodsTypeViewForSupplierResponse>> listForSupplier(GoodsTypeAllListRequest request) {
        BaseCommonResult<List<GoodsTypeViewForSupplierResponse>> result = new BaseCommonResult<>();
        log.info("商品分类-商家获取类目列表--开始");
        try{
            PGoodsTypeExample goodsTypeExample = new PGoodsTypeExample();
            goodsTypeExample.createCriteria().andIsdeleteEqualTo(new Byte("0")).andPidEqualTo(request.getPid());
            List<PGoodsType> list = goodsTypeMapper.selectByExample(goodsTypeExample);
            List<GoodsTypeViewForSupplierResponse> viewResponses = new ArrayList<>();
            if(list != null && list.size() > 0){
                for(PGoodsType type : list){
                    GoodsTypeViewForSupplierResponse goodsTypeViewForSupplierResponse = new GoodsTypeViewForSupplierResponse(type.getId(), type.getName());
                    viewResponses.add(goodsTypeViewForSupplierResponse);
                }
                GoodsTypeViewForSupplierResponse goodsTypeViewForSupplierResponse = new GoodsTypeViewForSupplierResponse(0, "全类目");
                viewResponses.add(goodsTypeViewForSupplierResponse);
            }
            result.setData(viewResponses);
        }catch(GoodsException e){
            log.info("商品分类-商家获取类目列表--异常, 信息：{}", e.getMessage());
            throw new GoodsException(GoodsApiCode.QUERY_GOODS_TYPE_LIST,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_GOODS_TYPE_LIST));
        }catch(Exception e){
            log.info("商品分类-商家获取类目列表--结束, 信息：{}", e);
            throw new GoodsException(GoodsApiCode.QUERY_GOODS_TYPE_LIST,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_GOODS_TYPE_LIST));
        }
        return result;
    }

    @Transactional
    public BaseCommonResult<Void> delete(Integer id) {
        BaseCommonResult<Void> result = new BaseCommonResult<>();
        log.info("商品分类-商品分类删除--开始, 请求信息：{}", id);
        try{
            PGoodsType goodsType = new PGoodsType();
            goodsType.setId(id);
            goodsType.setIsdelete(new Byte("1"));
            goodsTypeMapper.updateByPrimaryKeySelective(goodsType);  //逻辑删除
            Integer goodsTypeId = goodsType.getId();

            //关联attr属性
            PAttrTypeRelationExample attrTypeRelationExample = new PAttrTypeRelationExample();
            attrTypeRelationExample.createCriteria().andGoodsTypeIdEqualTo(goodsTypeId);
            attrTypeRelationMapper.deleteByExample(attrTypeRelationExample);
        }catch(GoodsException e){
            log.info("商品分类-商品分类删除--结束, 信息：{}", e.getMessage());
            throw new GoodsException(e.getResponseCode(), e.getResponseMsg());
        }catch(Exception e){
            log.info("商品分类-商品分类删除--结束, 信息：{}", e);
            throw new GoodsException(GoodsApiCode.DELETE_GOODS_TYPE,GoodsApiCode.getZhMsg(GoodsApiCode.DELETE_GOODS_TYPE));
        }
        log.info("商品分类-商品分类删除--结束, 返回信息：{}", result);
        return result;
    }

    @Transactional
    public BaseCommonResult<Void> update(GoodsTypeUpdateRequest request) {
        BaseCommonResult<Void> result = new BaseCommonResult<>();
        log.info("商品分类-商品分类更新--开始, 请求信息：{}", request);
        try{
            PGoodsType goodsType = new PGoodsType();
            dozer.map(request, goodsType);
            goodsType.setIsdelete(new Byte("0"));
            goodsType.setApphome(new Byte("0"));

            if(goodsType.getPid() == 0){
                goodsType.setLevel(GoodsConstants.GOODS_TYPE_LEVEL_ONE);
            }else{
                PGoodsType parentGoodsType = goodsTypeMapper.selectByPrimaryKey(goodsType.getPid());
                if(GoodsConstants.GOODS_TYPE_LEVEL_ONE .equals(parentGoodsType.getLevel())){
                    goodsType.setLevel(GoodsConstants.GOODS_TYPE_LEVEL_TWO);
                }else if(GoodsConstants.GOODS_TYPE_LEVEL_TWO .equals(parentGoodsType.getLevel())){
                    goodsType.setLevel(GoodsConstants.GOODS_TYPE_LEVEL_THREE);
                }
            }
            goodsTypeMapper.updateByPrimaryKeySelective(goodsType);
            Integer goodsTypeId = request.getId();
            //关联attr属性
            //先删除
            PAttrTypeRelationExample attrExample = new PAttrTypeRelationExample();
            attrExample.createCriteria().andGoodsTypeIdEqualTo(goodsTypeId);
            attrTypeRelationMapper.deleteByExample(attrExample);
            //再新增
            Integer[] attrIds = request.getAttrIds();
            for(Integer attrId :attrIds){
                PAttrTypeRelation attrTypeRelation =  new PAttrTypeRelation();
                attrTypeRelation.setAttrId(attrId);
                attrTypeRelation.setGoodsTypeId(goodsTypeId);
                attrTypeRelationMapper.insert(attrTypeRelation);
            }

        }catch(GoodsException e){
            log.info("商品分类-商品分类更新--结束, 信息：{}", e.getMessage());
            throw new GoodsException(e.getResponseCode(), e.getResponseMsg());
        }catch(Exception e){
            log.info("商品分类-商品分类更新--结束, 信息：{}", e);
            throw new GoodsException(GoodsApiCode.UPDATE_GOODS_TYPE,GoodsApiCode.getZhMsg(GoodsApiCode.UPDATE_GOODS_TYPE));
        }
        log.info("商品分类-商品分类更新--结束, 返回信息：{}", result);
        return result;
    }

    public BaseCommonResult<GoodsTypeDetailsResponse> details(Integer id) {
        BaseCommonResult<GoodsTypeDetailsResponse> result = new BaseCommonResult<>();
        log.info("商品分类-获取商品分类详情--开始, 请求信息：{}", id);
        try{
            PGoodsType goodsType = goodsTypeMapper.selectByPrimaryKey(id);
            GoodsTypeDetailsResponse response = dozer.map(goodsType, GoodsTypeDetailsResponse.class);
            if(StringUtils.isNotBlank(response.getIcon())){
                response.setIcon(GoodsUrlUtil.checkValidPath(response.getIcon()));
            }
            //父级分类
            if(goodsType.getPid() != 0){
                PGoodsType parentGoodsType = goodsTypeMapper.selectByPrimaryKey(goodsType.getPid());
                response.setPName(parentGoodsType.getName());
            }
            //关联attr属性
            List<TypeAttrResponse> typeAttrResponseList = goodsTypeManualMapper.selectAttrByGoodsTypeId(id);
            response.setAttrList(typeAttrResponseList);

            result.setData(response);
        }catch(GoodsException e){
            log.info("商品分类-获取商品分类详情--结束, 信息：{}", e.getMessage());
            throw new GoodsException(GoodsApiCode.QUERY_GOODS_TYPE_DETAILS,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_GOODS_TYPE_DETAILS));
        }catch(Exception e){
            log.info("商品分类-获取商品分类详情--结束, 信息：{}", e);
            throw new GoodsException(GoodsApiCode.QUERY_GOODS_TYPE_DETAILS,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_GOODS_TYPE_DETAILS));
        }
        log.info("商品分类-获取商品分类详情--结束, 返回信息：{}", result);
        return result;
    }


    public BaseCommonResult<List<GoodsTypeResponse>> allList(GoodsTypeAllListRequest request) {
        BaseCommonResult<List<GoodsTypeResponse>> result = new BaseCommonResult<>();
        log.info("商品分类-获取商品分类全部列表--开始, 请求信息：{}", request);
        try{
            PGoodsType goodType = new PGoodsType();
            dozer.map(request, goodType);
            PGoodsTypeExample goodsTypeExample = new PGoodsTypeExample();
            goodsTypeExample.createCriteria().andPidEqualTo(goodType.getPid())
                    .andIsdeleteEqualTo(new Byte("0"));
            List<PGoodsType> list = goodsTypeMapper.selectByExample(goodsTypeExample);

            List<GoodsTypeResponse> responseList = new ArrayList<>();
            for(PGoodsType gt : list ){
                GoodsTypeResponse goodTypeResponse = dozer.map(gt, GoodsTypeResponse.class);
                responseList.add(goodTypeResponse);
            }
            result.setData(responseList);
        }catch(GoodsException e){
            log.info("商品分类-获取商品分类全部列表--结束, 信息：{}", e.getMessage());
            throw new GoodsException(GoodsApiCode.QUERY_GOODS_TYPE_LIST,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_GOODS_TYPE_LIST));
        }catch(Exception e){
            log.info("商品分类-获取商品分类全部列表--结束, 信息：{}", e);
            throw new GoodsException(GoodsApiCode.QUERY_GOODS_TYPE_LIST,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_GOODS_TYPE_LIST));
        }
        log.info("商品分类-获取商品分类全部列表--结束, 返回信息：{}", result);
        return result;
    }

    public BaseCommonResult<GoodsTypeViewListResponse> list(GoodsTypeListRequest req) {
        BaseCommonResult<GoodsTypeViewListResponse> result = new BaseCommonResult<>();
        long startTime = System.currentTimeMillis();
        log.info("商品分类-获取商品分类列表--开始, 请求信息：{}", req);
        try{
            PageHelper.startPage(req.getPage(), req.getPageSize());
            PGoodsType goodType = new PGoodsType();
            dozer.map(req, goodType);
            PGoodsTypeExample goodsTypeExample = new PGoodsTypeExample();
            PGoodsTypeExample.Criteria criteria = goodsTypeExample.createCriteria()
                    .andIsdeleteEqualTo(new Byte("0"));
            if(req.getPid()>0){
                criteria.andPidEqualTo(goodType.getPid());
            }
            if(StringUtils.isNotBlank(req.getName())){
                criteria.andNameLike("%" + goodType.getName() + "%");
            }
            if(goodType.getLevel() != null ){
                criteria.andLevelEqualTo(goodType.getLevel());
            }
            goodsTypeExample.setOrderByClause(" sort desc");
            List<PGoodsType> list = goodsTypeMapper.selectByExample(goodsTypeExample);
            long dbTime = System.currentTimeMillis() - startTime;
            log.info("商品分类-获取商品分类列表查询数据库耗时："+dbTime);

            PageInfo<PGoodsType> pageInfo = new PageInfo<PGoodsType>(list);
            GoodsTypeViewListResponse response = new GoodsTypeViewListResponse();
            response.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(),
                    pageInfo.getTotal());
            log.info("获取分类for循环开始：{}", startTime);
            for(PGoodsType gt : list ){
                GoodsTypeViewResponse goodTypeResponse = dozer.map(gt, GoodsTypeViewResponse.class);
                //分类信息
                if(gt.getId().equals(408)){
                    System.out.println("福转场");
                }
                List<PGoodsType> pGoodsTypesList=iGoodsService.getPGoodsTypeNodes(gt.getId());
                if(pGoodsTypesList!=null && !pGoodsTypesList.isEmpty() && pGoodsTypesList.size()>0){
                    if(pGoodsTypesList.size()>=3 &&pGoodsTypesList.get(2)!=null && !StringUtils.isEmpty(pGoodsTypesList.get(2).getName())){
                        goodTypeResponse.setFirstName(pGoodsTypesList.get(2).getName());
                    }else{
                        goodTypeResponse.setFirstName("");
                    }
                    //二级分类处理
                    if(pGoodsTypesList.size()==2 &&pGoodsTypesList.get(1)!=null && !StringUtils.isEmpty(pGoodsTypesList.get(1).getName())){
                        goodTypeResponse.setFirstName(pGoodsTypesList.get(1).getName());
                    }
                    if(pGoodsTypesList.size()>2 &&pGoodsTypesList.get(1)!=null && !StringUtils.isEmpty(pGoodsTypesList.get(1).getName())){
                        goodTypeResponse.setSecName(pGoodsTypesList.get(1).getName());
                    }else{
                        goodTypeResponse.setSecName("");
                    }
                    if(pGoodsTypesList.size()>=1 && pGoodsTypesList.get(0)!=null && !StringUtils.isEmpty(pGoodsTypesList.get(0).getName())){
                        goodTypeResponse.setName(pGoodsTypesList.get(0).getName());
                    }else{
                        goodTypeResponse.setName("");
                    }

                }
                response.addT(goodTypeResponse);
            }
            result.setData(response);
        }catch(GoodsException e){
            log.info("商品分类-获取商品分类列表--结束, 信息：{}", e.getMessage());
            throw new GoodsException(GoodsApiCode.QUERY_GOODS_TYPE_LIST,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_GOODS_TYPE_LIST));
        }catch(Exception e){
            log.info("商品分类-获取商品分类列表--结束, 信息：{}", e);
            throw new GoodsException(GoodsApiCode.QUERY_GOODS_TYPE_LIST,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_GOODS_TYPE_LIST));
        }
        long interfaceTime = System.currentTimeMillis()-startTime;
        log.info("商品分类-获取商品分类列表--结束, 返回信息：{},耗时为{}", result,interfaceTime);
        return result;
    }
}
