package spring.goods.service;

import spring.dto.BaseCommonResult;
import spring.exception.GoodsException;
import spring.goods.common.GoodsApiCode;
import spring.goods.dto.request.*;
import spring.goods.dto.response.*;
import spring.mapper.PGoodsTypeManualMapper;
import spring.mapper.PTypeAttrMapper;
import spring.mapper.PTypeAttrValueMapper;
import spring.model.PTypeAttr;
import spring.model.PTypeAttrExample;
import spring.model.PTypeAttrValue;
import spring.model.PTypeAttrValueExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/***
 * 
* 功能描述: 商品attr
* @author: xiongkun
* @date: 2017年11月20日 下午3:20:22
 */
@Slf4j
@Service
public class TypeAttrService {

	@Autowired
	private PTypeAttrMapper typeAttrMapper;
	
	@Autowired
	private PTypeAttrValueMapper typeAttrValueMapper;
	
	@Autowired
	private PGoodsTypeManualMapper goodsTypeManualMapper;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	public BaseCommonResult<TypeAttrListResponse> list(TypeAttrListRequest req) {
		BaseCommonResult<TypeAttrListResponse> result = new BaseCommonResult<>();
		log.info("商品attr-获取商品attr列表--开始, 请求信息：{}", req);
		try{
			PageHelper.startPage(req.getPage(), req.getPageSize());
			PTypeAttr attrType = new PTypeAttr();
			dozer.map(req, attrType);
			PTypeAttrExample typeAttrExample = new PTypeAttrExample();
			typeAttrExample.createCriteria().andIsDeleteEqualTo(new Byte("0"));
			typeAttrExample.setOrderByClause("sort desc");
			List<PTypeAttr> list = typeAttrMapper.selectByExample(typeAttrExample);
			
			PageInfo<PTypeAttr> pageInfo = new PageInfo<PTypeAttr>(list);
			TypeAttrListResponse response = new TypeAttrListResponse();
			response.setPageInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(),
					pageInfo.getTotal());
			for(PTypeAttr gt : list){
				TypeAttrResponse attrTypeResponse = dozer.map(gt, TypeAttrResponse.class);
				response.addT(attrTypeResponse);
			}
			result.setData(response);
		}catch(GoodsException e){
			log.info("商品attr-获取商品attr列表--结束, 信息：{}", e.getMessage());
			throw new GoodsException(GoodsApiCode.QUERY_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_ATTR));
		}catch(Exception e){
			log.info("商品attr-获取商品attr列表--结束, 信息：{}", e);
			throw new GoodsException(GoodsApiCode.QUERY_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_ATTR));
		}
		log.info("商品attr-获取商品attr列表--结束, 返回信息：{}", result);
		return result;
	}
	
	public BaseCommonResult<List<TypeAttrAndAttrValueAllListResponse>> allAttrAndAttrValueList(
			TypeAttrAndAttrValueAllListRequest request) {
		BaseCommonResult<List<TypeAttrAndAttrValueAllListResponse>> result = new BaseCommonResult<>();
		log.info("商品attr-获取商品attr及属性行全部列表--开始, 请求信息：{}", request);
		try{
			List<TypeAttrAndAttrValueAllListResponse> responseList = new ArrayList<>();
			
			PTypeAttrExample typeAttrExample = new PTypeAttrExample();
			typeAttrExample.createCriteria().andIsDeleteEqualTo(new Byte("0"));
			typeAttrExample.setOrderByClause("sort desc");
			List<PTypeAttr> list = typeAttrMapper.selectByExample(typeAttrExample);
			
			for(PTypeAttr attr : list){				
				//属性值
				List<TypeAttrValueResponse> attrValueResponseList = new ArrayList<>();
				PTypeAttrValueExample attrValueExample = new PTypeAttrValueExample();
				attrValueExample.createCriteria().andIsDeleteEqualTo(new Byte("0"))
					.andAttributeIdEqualTo(attr.getId());
				List<PTypeAttrValue> attrValueList = typeAttrValueMapper.selectByExample(attrValueExample);
				for(PTypeAttrValue attrValue : attrValueList){
					TypeAttrValueResponse typeAttrValueResponse = dozer.map(attrValue, TypeAttrValueResponse.class);
					attrValueResponseList.add(typeAttrValueResponse);
				}
				//属性
				TypeAttrAndAttrValueAllListResponse typeAttrAndAttrValueResponse = dozer.map(attr, TypeAttrAndAttrValueAllListResponse.class);
				typeAttrAndAttrValueResponse.setAttrValueList(attrValueResponseList);				
				responseList.add(typeAttrAndAttrValueResponse);
			}
			result.setData(responseList);
		}catch(GoodsException e){
			log.info("商品attr-获取商品attr及属性行全部列表--结束, 信息：{}", e.getMessage());
			throw new GoodsException(GoodsApiCode.QUERY_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_ATTR));
		}catch(Exception e){
			log.info("商品attr-获取商品attr及属性行全部列表--结束, 信息：{}", e);
			throw new GoodsException(GoodsApiCode.QUERY_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_ATTR));
		}
		log.info("商品attr-获取商品attr及属性行全部列表--结束, 返回信息：{}", result);
		return result;
	}


	public BaseCommonResult<List<TypeAttrAllListResponse>> allList(TypeAttrAllListRequest request) {
		BaseCommonResult<List<TypeAttrAllListResponse>> result = new BaseCommonResult<>();
		log.info("商品attr-获取商品attr全部列表--开始, 请求信息：{}", request);
		try{
			List<TypeAttrAllListResponse> responseList = new ArrayList<>();
			
			PTypeAttrExample typeAttrExample = new PTypeAttrExample();
			typeAttrExample.createCriteria().andIsDeleteEqualTo(new Byte("0"))
				.andAttributeNameLike("%" + request.getAttributeName() + "%" );
			typeAttrExample.setOrderByClause("sort desc");
			List<PTypeAttr> list = typeAttrMapper.selectByExample(typeAttrExample);
			
			for(PTypeAttr attr : list){
				TypeAttrAllListResponse attrTypeResponse = dozer.map(attr, TypeAttrAllListResponse.class);
				responseList.add(attrTypeResponse);
			}
			result.setData(responseList);
		}catch(GoodsException e){
			log.info("商品attr-获取商品attr全部列表--结束, 信息：{}", e.getMessage());
			throw new GoodsException(GoodsApiCode.QUERY_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_ATTR));
		}catch(Exception e){
			log.info("商品attr-获取商品attr全部列表--结束, 信息：{}", e);
			throw new GoodsException(GoodsApiCode.QUERY_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_ATTR));
		}
		log.info("商品attr-获取商品attr全部列表--结束, 返回信息：{}", result);
		return result;
	}
	
	public BaseCommonResult<TypeAttrDetailsResponse> details(Integer id) {
		BaseCommonResult<TypeAttrDetailsResponse> result = new BaseCommonResult<>();
		log.info("商品attr-获取商品attr详情--开始, 请求信息：{}", id);
		try{
			PTypeAttr typeAttr = typeAttrMapper.selectByPrimaryKey(id);
			TypeAttrDetailsResponse response = dozer.map(typeAttr, TypeAttrDetailsResponse.class);
			result.setData(response);
			
			//属性值列表
			PTypeAttrValueExample typeAttrValueExample = new PTypeAttrValueExample();
			typeAttrValueExample.createCriteria().andAttributeIdEqualTo(id).andIsDeleteEqualTo(new Byte("0"));
			typeAttrValueExample.setOrderByClause("sort desc");
			List<PTypeAttrValue> typeAttrValueList = typeAttrValueMapper.selectByExample(typeAttrValueExample);
			List<TypeAttrValueResponse> list = new ArrayList<>();
			typeAttrValueList.stream().forEach(item ->{
				TypeAttrValueResponse attrTypeValueResponse = dozer.map(item, TypeAttrValueResponse.class);
				list.add(attrTypeValueResponse);
			});
			
			response.setTypeAttrs(list);
		}catch(GoodsException e){
			log.info("商品attr-获取商品attr详情--结束, 信息：{}", e.getMessage());
			throw new GoodsException(e.getResponseCode(), e.getResponseMsg());
		}catch(Exception e){
			log.info("商品attr-获取商品attr详情--结束, 信息：{}", e);
			throw new GoodsException(GoodsApiCode.QUERY_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_ATTR));
		}
		log.info("商品attr-获取商品attr详情--结束, 返回信息：{}", result);
		return result;
	}

	public BaseCommonResult<Void> update(TypeAttrUpdateRequest request) {
		BaseCommonResult<Void> result = new BaseCommonResult<>();
		log.info("商品attr-商品attr更新--开始, 请求信息：{}", request);
		try{
			PTypeAttr typeAttr = new PTypeAttr();
			dozer.map(request, typeAttr);
			typeAttrMapper.updateByPrimaryKeySelective(typeAttr);
			
		}catch(GoodsException e){
			log.info("商品attr-商品attr更新--结束, 信息：{}", e.getMessage());
			throw new GoodsException(e.getResponseCode(), e.getResponseMsg());
		}catch(Exception e){
			log.info("商品attr-商品attr更新--结束, 信息：{}", e);
			throw new GoodsException(GoodsApiCode.UPDATE_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.UPDATE_ATTR));
		}
		log.info("商品attr-商品attr更新--结束, 返回信息：{}", result);
		return result;
	}

	public BaseCommonResult<Void> add(TypeAttrAddRequest request) {
		BaseCommonResult<Void> result = new BaseCommonResult<>();
		log.info("商品attr-商品attr新增--开始, 请求信息：{}", request);
		try{
			PTypeAttr typeAttr = new PTypeAttr();
			dozer.map(request, typeAttr);
			typeAttr.setIsDelete(new Byte("0"));
			typeAttr.setGoodsTypeId(0);
			typeAttrMapper.insertSelective(typeAttr);
			
		}catch(GoodsException e){
			log.info("商品attr-商品attr新增--结束, 信息：{}", e.getMessage());
			throw new GoodsException(e.getResponseCode(), e.getResponseMsg());
		}catch(Exception e){
			log.info("商品attr-商品attr新增--结束, 信息：{}", e);
			throw new GoodsException(GoodsApiCode.ADD_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.ADD_ATTR));
		}
		log.info("商品attr-商品attr新增--结束, 返回信息：{}", result);
		return result;
	}

	public BaseCommonResult<Void> delete(Integer id) {
		BaseCommonResult<Void> result = new BaseCommonResult<>();
		log.info("商品attr-商品attr删除--开始, 请求信息：{}", id);
		try{
			PTypeAttr typeAttr = new PTypeAttr();
			typeAttr.setId(id);
			typeAttr.setIsDelete(new Byte("1"));
			typeAttrMapper.updateByPrimaryKeySelective(typeAttr);
			
			//删除商品属性值
			PTypeAttrValue typeAttrValue = new PTypeAttrValue();
			typeAttrValue.setIsDelete(new Byte("1"));
			
			PTypeAttrValueExample typeAttrValueExample =  new PTypeAttrValueExample();
			typeAttrValueExample.createCriteria().andAttributeIdEqualTo(id);
			typeAttrValueMapper.updateByExampleSelective(typeAttrValue, typeAttrValueExample);
			
		}catch(GoodsException e){
			log.info("商品attr-商品attr删除--结束, 信息：{}", e.getMessage());
			throw new GoodsException(e.getResponseCode(), e.getResponseMsg());
		}catch(Exception e){
			log.info("商品attr-商品attr删除--结束, 信息：{}", e);
			throw new GoodsException(GoodsApiCode.DELETE_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.DELETE_ATTR));
		}
		log.info("商品attr-商品attr删除--结束, 返回信息：{}", result);
		return result;
	}

	public BaseCommonResult<List<AppTypeAttrResponse>> appList(Integer goodsTypeId) {
		BaseCommonResult<List<AppTypeAttrResponse>> result = new BaseCommonResult<>();
		
		log.info("商品attr-app获取商品attr列表--开始, 请求信息：{}", goodsTypeId);
		try{
			List<AppTypeAttrResponse> responseList = new ArrayList<AppTypeAttrResponse>();
			List<TypeAttrResponse> typeAttrResponseList = goodsTypeManualMapper.selectAttrByGoodsTypeId(goodsTypeId);
			for(TypeAttrResponse attr : typeAttrResponseList){
				AppTypeAttrResponse response = dozer.map(attr, AppTypeAttrResponse.class);				
				//属性值列表
				PTypeAttrValueExample typeAttrValueExample = new PTypeAttrValueExample();
				typeAttrValueExample.createCriteria().andAttributeIdEqualTo(attr.getId()).andIsDeleteEqualTo(new Byte("0"));
				typeAttrValueExample.setOrderByClause("sort desc");
				List<PTypeAttrValue> typeAttrValueList = typeAttrValueMapper.selectByExample(typeAttrValueExample);
				List<TypeAttrValueResponse> list = new ArrayList<>();
				typeAttrValueList.stream().forEach(item ->{
					TypeAttrValueResponse attrTypeValueResponse = dozer.map(item, TypeAttrValueResponse.class);
					list.add(attrTypeValueResponse);
				});				
				response.setAttrValueList(list);
				responseList.add(response);
			}
			result.setData(responseList);
		}catch(GoodsException e){
			log.info("商品attr-app获取商品attr列表--结束, 信息：{}", e.getMessage());
			throw new GoodsException(GoodsApiCode.QUERY_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_ATTR));
		}catch(Exception e){
			log.info("商品attr-app获取商品attr列表--结束, 信息：{}", e);
			throw new GoodsException(GoodsApiCode.QUERY_ATTR,GoodsApiCode.getZhMsg(GoodsApiCode.QUERY_ATTR));
		}
		log.info("商品attr-app获取商品attr列表--结束, 返回信息：{}", result);
		return result;
	}

	
	
}
