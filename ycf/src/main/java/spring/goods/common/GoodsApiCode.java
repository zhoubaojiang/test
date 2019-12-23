package spring.goods.common;

import spring.exception.BaseApiCode;

/**
 * 自定义状态码，继承基础状态码类：BaseApiCode
*
 */
public class GoodsApiCode extends BaseApiCode {


	/** 请求参数校验失败*/
	public static final Integer PARAMS_CHECK_FAIL = 10850;
	
	/** 查询商品列表失败*/
	public static final Integer QUERY_GOODS_LIST  = 10801;
	
	/** 查询商品分类列表失败*/
	public static final Integer QUERY_GOODS_TYPE_LIST  = 10802;
	
	/** 新增商品分类失败*/
	public static final Integer ADD_GOODS_TYPE  = 10803;
	
	/** 更新商品分类失败*/
	public static final Integer UPDATE_GOODS_TYPE  = 10804;
	
	/** 删除商品分类失败*/
	public static final Integer DELETE_GOODS_TYPE  = 10805;
	
	/** 查询商品分类详情失败*/
	public static final Integer QUERY_GOODS_TYPE_DETAILS  = 10806;
	
	/** 查询商品标签列表失败*/
	public static final Integer QUERY_GOODS_TAG_LIST  = 10807;
	
	/** 新增商品标签失败*/
	public static final Integer ADD_GOODS_TAG  = 10808;
	
	/** 更新商品标签失败*/
	public static final Integer UPDATE_GOODS_TAG  = 10809;
	
	/** 删除商品标签失败*/
	public static final Integer DELETE_GOODS_TAG  = 10810;
	
	/** 查询商品分类详情失败*/
	public static final Integer QUERY_GOODS_TAG_DETAILS  = 10811;
	
	
	/** 新增商品标签失败*/
	public static final Integer ADD_ATTR  = 10812;	
	/** 更新商品标签失败*/
	public static final Integer UPDATE_ATTR  = 10813;	
	/** 删除商品标签失败*/
	public static final Integer DELETE_ATTR  = 10814;
	/** 查询属性失败*/
	public static final Integer QUERY_ATTR  = 10815;
	/** 更新属性失败*/
	public static final Integer UPDATE_ATTR_VALUE  = 10816;	
	/** 删除属性失败*/
	public static final Integer DELETE_ATTR_VALUE  = 10817;
	/** 查询属性失败*/
	public static final Integer QUERY_ATTR_VALUE  = 10818;
	/** 新增属性失败*/
	public static final Integer ADD_ATTR_VALUE  = 10819;	
	
	/** 查询商品浏览历史*/
	public static final Integer QUERY_GOODS_BROWSE_LIST  = 10820;
	
	//-------------------------------------------10830--->10859---------start---------------------
	/** 商品模块获取用户缓存信息失败*/
	public static final Integer QUERY_GOODS_LOGIN_USER_ERROR = 10830;
	/**更新商品下单量/销量失败*/
	public static final Integer UPDATE_GOODS_STATISTICAL_ERROR = 10831;
	/** 新增商品信息失败，是否合作商2乐豆商品类型新增后不能修改*/
	public static final Integer ADD_GOODS_IS_HEALTH_CHANGE = 10832;
	/** 新增商品信息失败，非合作商2乐豆商品类型不能使用乐豆*/
	public static final Integer ADD_GOODS_IS_HEALTH_CANT_USE_H = 10833;
	/** 新增商品信息失败，合作商2乐豆商品类型不能使用平台福豆*/
	public static final Integer ADD_GOODS_IS_HEALTH_CANT_USE_W = 10834;
	/** 删除商品sku属性模板信息失败，上架状态为已上架*/
	public static final Integer DELETE_GOODS_SKU_MODEL_ERROR = 10849;
	/** 新增商品信息失败*/
	public static final Integer ADD_GOODS = 10851;
	/** 更新商品信息失败*/
	public static final Integer UPDATE_GOODS = 10852;
	/** 获取商品信息失败*/
	public static final Integer GET_GOODS = 10853;
	/** 删除商品信息失败*/
	public static final Integer DELETE_GOODS = 10854;
	/** 新增商品sku-model信息失败*/
	public static final Integer ADD_GOODS_SKU = 10855;
	/** 更新商品sku-model信息失败*/
	public static final Integer UPDATE_GOODS_SKU = 10855;
	/** 删除商品sku-model信息失败*/
	public static final Integer DELETE_GOODS_SKU = 10856;
	/** 新增商品信息失败，定时上架设置时间为空*/
	public static final Integer SHELVESDATE_IS_NULL = 10856;
	/** 更新商品信息失败，上架状态异常*/
	public static final Integer UPDATE_GOODS_IS_ONLIVE_ONE_ERROR = 10857;
	/** 删除商品信息失败，上架状态为已上架*/
	public static final Integer DELETE_GOODS_IS_ONLIVE_ONE_ERROR = 10858;
	/** 添加商品sku属性模板信息失败，上架状态为已上架*/
	public static final Integer ADD_GOODS_SKU_MODEL_ERROR = 10859;
	/**更新商品 选推荐商品渠道没有勾选*/
	public static final Integer ADD_GOODS_RECOMMEND_ERROR = 10860;


	//-------------------------------------------10830--->10859---------end---------------------
	
	/** 查询商品品牌信息失败*/
	public static final Integer QUERY_BRAND_LIST = 10860;
	
	/** 查询商品品牌详情失败*/
	public static final Integer QUERY_BRAND_INFO = 10861;
	
	/** 删除商品品牌详情失败*/
	public static final Integer DELETE_BRAND_INFO = 10862;
	
	/** 保存商品品牌详情失败*/
	public static final Integer SAVE_BRAND_INFO = 10863;
	
	/** 查询商品列表失败*/
	public static final Integer QUERY_GOODS_DETAILS  = 10864;
	
	/** 商品绑定标签*/
	public static final Integer GOODS_BIND_TAG  = 10865;
	
	/** 商品绑定属性*/
	public static final Integer GOODS_BIND_ATTR  = 10866;
	
	/** 商品标签关联关系*/
	public static final Integer GOODS_TAG_RELATION  = 10867;
	
	/** 商品属性关联关系*/
	public static final Integer GOODS_ATTR_RELATION  = 10868;
	
	/** 商品sku model已经存在*/
	public static final Integer GOODS_SKU_MODEL_EXITS_ERROR = 10869;
	
	/** 商品导出异常*/
	public static final Integer GOODS_EXPORT_ERROR = 10870;
	
	/**商品已下架**/
	public static final Integer GOODS_IS_OFFLINE = 10871;

	//---------------------------日志接口--------------------------------
	/** 10851-10859*/
	/** 日志异常校验不通过*/
	public static final Integer LOGS_DATA_CHECK_ERROR=10851;
	/** 日志入库异常*/
	public static final Integer LOGS_DATA_INDB_ERROR=10852;
	/** 商品告警失败 */
	public static final int GOODS_ALARM_FAIL = 10853;


	//-------------------------第三方商城接入----------------------------

	/**操作第三方库存失败**/
	public static final Integer GOODS_THIRD_STOCK_ERROR = 10872;

	/**操作第三方规格失败**/
	public static final Integer GOODS_THIRD_SPEC_ERROR = 10873;

	/** 更新顺道商品上下架信息失败*/
	public static final Integer UPDATE_GOODS_SD_ISONLIVE_FAIL = 10874;
	/** 运费模板已禁用*/
	public static final Integer FREIGHT_TEMPLATE_DISENABLE = 10875;
	/** 查询推荐商品列表*/
	public static final Integer GOODS_RECOMMEND_LIST_FAIL = 10876;
	/** 推荐商品算法查询*/
	public static final Integer GOODS_RECOMMEND_ALGORITHM_FAIL = 10877;
	/** 下架失败*/
	public static final Integer GOODS_PULL_OFF_FAIL = 10878;


	/**康养卡赠送配置错误*/
	public static final Integer HEALTH_CARD_NO_CONFIG = 10901;

	/**无康养卡订单信息*/
	public static final Integer HEALTH_CARD_NO_ORDER = 10902;

	/** 无赠送历史信息*/
	public static final Integer HEALTH_CARD_NO_GIVE_HISTORY = 10903;
	
	/**
	 * 静态代码块，自定义编码需加入map
	 */
	static {
		zhMsgMap.put(FREIGHT_TEMPLATE_DISENABLE, "运费模板已禁用");
		zhMsgMap.put(GOODS_ALARM_FAIL, "商品告警失败");
		
		zhMsgMap.put(PARAMS_CHECK_FAIL,"请求参数校验失败");
		zhMsgMap.put(QUERY_GOODS_LIST, "查询商品列表失败");
		zhMsgMap.put(QUERY_GOODS_TYPE_LIST, "查询商品分类列表失败");
		zhMsgMap.put(ADD_GOODS_TYPE, "新增商品分类失败");
		zhMsgMap.put(UPDATE_GOODS_TYPE, "更新商品分类失败");
		zhMsgMap.put(DELETE_GOODS_TYPE, "删除商品分类失败");
		zhMsgMap.put(QUERY_GOODS_TYPE_DETAILS, "查询商品分类详情失败");
		zhMsgMap.put(QUERY_GOODS_TAG_LIST, "查询商品标签列表失败");
		zhMsgMap.put(ADD_GOODS_TAG, "新增商品标签失败");
		zhMsgMap.put(UPDATE_GOODS_TAG, "更新商品标签失败");
		zhMsgMap.put(DELETE_GOODS_TAG, "删除商品标签失败");
		zhMsgMap.put(QUERY_GOODS_TAG_DETAILS, "查询商品标签详情失败");
		zhMsgMap.put(QUERY_GOODS_DETAILS, "查询商品详情失败");
		zhMsgMap.put(QUERY_GOODS_BROWSE_LIST, "查询商品浏览历史失败");
		
		zhMsgMap.put(ADD_ATTR, "新增属性失败");
		zhMsgMap.put(UPDATE_ATTR, "更新属性失败");
		zhMsgMap.put(DELETE_ATTR, "删除属性失败");
		zhMsgMap.put(QUERY_ATTR, "查询属性失败");
		zhMsgMap.put(ADD_ATTR_VALUE, "新增属性值失败");
		zhMsgMap.put(UPDATE_ATTR_VALUE, "更新属性值失败");
		zhMsgMap.put(DELETE_ATTR_VALUE, "删除属性值失败");
		zhMsgMap.put(QUERY_ATTR_VALUE, "查询属性值失败");
		
		zhMsgMap.put(QUERY_GOODS_LOGIN_USER_ERROR, "商品模块获取用户缓存信息失败");
		zhMsgMap.put(UPDATE_GOODS_STATISTICAL_ERROR, "更新商品下单量/销量失败");
		zhMsgMap.put(ADD_GOODS, "新增商品信息失败");
		zhMsgMap.put(UPDATE_GOODS, "更新商品信息失败");
		zhMsgMap.put(GET_GOODS, "获取商品信息失败");
		zhMsgMap.put(DELETE_GOODS, "删除商品信息失败");
		zhMsgMap.put(ADD_GOODS_SKU, "新增商品sku-model信息失败");
		zhMsgMap.put(UPDATE_GOODS_SKU, "更新商品sku-model信息失败");
		zhMsgMap.put(DELETE_GOODS_SKU, "删除商品sku-model信息失败");
		zhMsgMap.put(SHELVESDATE_IS_NULL, "新增商品信息失败，定时上架设置时间为空");
		zhMsgMap.put(UPDATE_GOODS_IS_ONLIVE_ONE_ERROR, "更新商品信息失败，已上架商品不能更新");
		zhMsgMap.put(DELETE_GOODS_IS_ONLIVE_ONE_ERROR, "删除商品信息失败，已上架商品不能删除");
		zhMsgMap.put(ADD_GOODS_SKU_MODEL_ERROR, "添加商品sku属性模板信息失败，上架状态为已上架");
		zhMsgMap.put(DELETE_GOODS_SKU_MODEL_ERROR, "删除商品sku属性模板信息失败，上架状态为已上架");
		zhMsgMap.put(GOODS_SKU_MODEL_EXITS_ERROR, "商品sku属性模板已经存在了");
		
		zhMsgMap.put(ADD_GOODS_IS_HEALTH_CHANGE, "新增商品信息失败，是否合作商2乐豆商品类型新增后不能修改");
		zhMsgMap.put(ADD_GOODS_IS_HEALTH_CANT_USE_H, "新增商品信息失败，非合作商2乐豆商品类型不能使用乐豆");
		zhMsgMap.put(ADD_GOODS_IS_HEALTH_CANT_USE_W, "新增商品信息失败，合作商2乐豆商品类型不能使用平台福豆");

		
		zhMsgMap.put(QUERY_BRAND_LIST, "查询商品品牌信息失败");
		zhMsgMap.put(QUERY_BRAND_INFO, "查询商品品牌详情失败");
		zhMsgMap.put(DELETE_BRAND_INFO, "删除商品品牌详情失败");
		zhMsgMap.put(SAVE_BRAND_INFO, "保存商品品牌详情失败");		
		zhMsgMap.put(GOODS_BIND_TAG, "商品绑定标签失败");
		zhMsgMap.put(GOODS_BIND_ATTR, "商品绑定属性失败");
		zhMsgMap.put(GOODS_TAG_RELATION, "商品标签关联关系失败");
		zhMsgMap.put(GOODS_ATTR_RELATION, "商品属性关联关系失败");
		zhMsgMap.put(GOODS_EXPORT_ERROR, "商品导出失败");
		zhMsgMap.put(GOODS_IS_OFFLINE, "商品已下架");
		
		zhMsgMap.put(GOODS_THIRD_STOCK_ERROR, "操作第三方库存失败");
		zhMsgMap.put(GOODS_THIRD_SPEC_ERROR, "操作第三方规格失败");

		zhMsgMap.put(UPDATE_GOODS_SD_ISONLIVE_FAIL, "更新顺道商品上下架信息失败");
		
		zhMsgMap.put(GOODS_RECOMMEND_LIST_FAIL, "查询商品推荐列表失败");
		zhMsgMap.put(GOODS_RECOMMEND_ALGORITHM_FAIL, "查询商品推荐算法失败");

		zhMsgMap.put(GOODS_PULL_OFF_FAIL, "下架失败");

		zhMsgMap.put(HEALTH_CARD_NO_CONFIG, "康养卡赠送配置错误");
		zhMsgMap.put(HEALTH_CARD_NO_ORDER, "无康养卡订单信息");
		zhMsgMap.put(HEALTH_CARD_NO_GIVE_HISTORY, "无赠送历史信息");
	}
}
