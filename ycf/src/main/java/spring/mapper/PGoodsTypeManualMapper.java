package spring.mapper;

import spring.goods.dto.response.TypeAttrResponse;

import java.util.List;

public interface PGoodsTypeManualMapper {
	
	/**
	 * 
	* 功能描述: 根据商品类型id
	* @author: xiongkun
	* @date: 2017年11月22日 下午3:29:08 
	* @param goodsTypeId
	* @return
	 */
	List<TypeAttrResponse> selectAttrByGoodsTypeId(Integer goodsTypeId);
}