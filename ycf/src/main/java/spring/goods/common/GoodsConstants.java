package spring.goods.common;

/**
 * 商品模块自定义常量
 *
 * @author wenwj
 * @date: 2017年11月21日 上午11:38:49 
 * @since 1.0
 */
public class GoodsConstants {





	//固定销售量
	public static final Integer TEN = 10;

	//商品分类层级
	public static final Byte GOODS_TYPE_LEVEL_ONE = 1;
	public static final Byte GOODS_TYPE_LEVEL_TWO = 2;
	public static final Byte GOODS_TYPE_LEVEL_THREE = 3;

	/**是否上架 0为已下架 1为已上架 2为未上架*/
	public static final Byte GOODS_IS_ONLIVE_ZERO = 0;
	/**是否上架 0为已下架 1为已上架 2为未上架*/
	public static final Byte GOODS_IS_ONLIVE_ONE = 1;
	/**是否上架 0为已下架 1为已上架 2为未上架*/
	public static final Byte GOODS_IS_ONLIVE_TWO = 2;

	/**商品审核状态：0:等待审核 1:审核通过 2:审核不通过 3草稿发状态(没提交到审核)*/
	public static final Byte GOODS_PUBLISH_WAIT_ZERO = 0;
	/**商品审核状态：0:等待审核 1:审核通过 2:审核不通过 3草稿发状态(没提交到审核)*/
	public static final Byte GOODS_PUBLISH_WAIT_ONE = 1;
	/**商品审核状态：0:等待审核 1:审核通过 2:审核不通过 3草稿发状态(没提交到审核)*/
	public static final Byte GOODS_PUBLISH_WAIT_TWO = 2;
	/**商品审核状态：0:等待审核 1:审核通过 2:审核不通过 3草稿发状态(没提交到审核)*/
	public static final Byte GOODS_PUBLISH_WAIT_THREE = 3;

	//-------------------------商品状态校验提示信息----------------------------

	/**商品校验使用：0：默认 1:前端操作的审核上架按钮 2:前端操作的审核不通过按钮 3: 前端操作的批量按钮 4: 前端操作的上架按钮 5: 前端操作的下架按钮 6: 上下架*/
	public static final Byte GOODS_CHECK_USE_DEFAULT = 0;
    /**商品校验使用：0：默认 1:前端操作的审核上架按钮 2:前端操作的审核不通过按钮 3: 前端操作的批量按钮 4: 前端操作的上架按钮 5: 前端操作的下架按钮 6: 上下架*/
	public static final Byte GOODS_CHECK_USE_PUBLISHPASS_ONLINE = 1;
    /**商品校验使用：0：默认 1:前端操作的审核上架按钮 2:前端操作的审核不通过按钮 3: 前端操作的批量按钮 4: 前端操作的上架按钮 5: 前端操作的下架按钮 6: 上下架*/
	public static final Byte GOODS_CHECK_USE_PUBLISHFAIL = 2;
    /**商品校验使用：0：默认 1:前端操作的审核上架按钮 2:前端操作的审核不通过按钮 3: 前端操作的批量按钮 4: 前端操作的上架按钮 5: 前端操作的下架按钮 6: 上下架*/
	public static final Byte GOODS_CHECK_USE_BATCH = 3;
    /**商品校验使用：0：默认 1:前端操作的审核上架按钮 2:前端操作的审核不通过按钮 3: 前端操作的批量按钮 4: 前端操作的上架按钮 5: 前端操作的下架按钮 6: 上下架*/
    public static final Byte GOODS_CHECK_USE_ONLINE = 4;
    /**商品校验使用：0：默认 1:前端操作的审核上架按钮 2:前端操作的审核不通过按钮 3: 前端操作的批量按钮 4: 前端操作的上架按钮 5: 前端操作的下架按钮 6: 上下架*/
    public static final Byte GOODS_CHECK_USE_OFFLINE = 5;
    /**商品校验使用：0：默认 1:前端操作的审核上架按钮 2:前端操作的审核不通过按钮 3: 前端操作的批量按钮 4: 前端操作的上架按钮 5: 前端操作的下架按钮 6: 上下架*/
    public static final Byte GOODS_CHECK_USE_ISONLINE = 6;
	/** 未审核的商品，不能操作上架*/
	public static final String GOODS_PUBLISH_WAIT_FAIL = "未审核的商品，不能操作上架";
	/** 草稿	已下架	批量审核通过/不通过*/
	public static final String GOODS_PUBLISH_WAIT_THREE_IS_ONLIVE_ZERO_PUBLISH_WAIT = "草稿状态不能审核";
	/** 草稿	已下架	批量上架*/
	public static final String GOODS_PUBLISH_WAIT_THREE_IS_ONLIVE_ZERO_ONLIVE = "未审核的商品，不能操作上架";
	/** 草稿	已下架	批量下架*/
	public static final String GOODS_PUBLISH_WAIT_THREE_IS_ONLIVE_ONE_OFFLIVE = "未审核的商品，不能操作下架";
	/** 待审核	已下架	批量审核通过/不通过*/
	public static final String GOODS_PUBLISH_WAIT_ZERO_IS_ONLIVE_ZERO_PUBLISH_WAIT = "批量操作成功";
	/** 待审核	已下架	批量上架*/
	public static final String GOODS_PUBLISH_WAIT_ZERO_IS_ONLIVE_ZERO_ONLIVE = "未审核的商品，不能上架";
	/** 待审核	已上架	批量上架*/
	public static final String GOODS_PUBLISH_WAIT_ZERO_IS_ONLIVE_ONE_ONLIVE = "未审核的商品，不能上架";
	/** 审核通过	已下架	批量审核通过*/
	public static final String GOODS_PUBLISH_WAIT_ONE_IS_ONLIVE_ZERO_PUBLISH_PASS = "已审核通过，请不要重复操作";
	/** 批量操作成功*/
	public static final String GOODS_SUCCESS = "批量操作成功";
	/** 审核通过	已下架	批量下架*/
	public static final String GOODS_PUBLISH_WAIT_ONE_IS_ONLIVE_ZERO_OFFLIVE = "请先上架商品";
	/** 审核通过	已上架	批量审核通过*/
	public static final String GOODS_PUBLISH_WAIT_ONE_IS_ONLIVE_ONE_PUBLISH_PASS = "已审核通过，请不要重复操作";
	/** 审核通过	已上架	批量审核不通过 */
	public static final String GOODS_PUBLISH_WAIT_ONE_IS_ONLIVE_ONE_PUBLISH_FAIL = "请先下架商品";
	/** 审核通过	已下架	批量审核不通过 */
	public static final String GOODS_PUBLISH_WAIT_ONE_IS_ONLIVE_TWO_PUBLISH_FAIL_ = "请到编辑页面提交审核";
	/** 审核通过	已上架	批量上架*/
	public static final String GOODS_PUBLISH_WAIT_ONE_IS_ONLIVE_ONE_ONLIVE = "请先下架商品";
	/** 审核不通过	已下架	批量审核不通过*/
	public static final String GOODS_PUBLISH_WAIT_TWO_IS_ONLIVE_ZERO_PUBLISH_FAIL = "已审核不通过，请不要重复操作";
	/** 审核不通过	已下架	批量上架*/
	public static final String GOODS_PUBLISH_WAIT_TWO_IS_ONLIVE_ZERO_ONLIVE = "商品审核不通过，不能操作上架";
	/** 审核不通过	已下架	批量下架*/
	public static final String GOODS_PUBLISH_WAIT_TWO_IS_ONLIVE_ZERO_OFFLIVE = "商品已下架，请不要重复操作";
	/** 草稿	未上架	批量上/下架*/
	public static final String GOODS_PUBLISH_WAIT_THREE_IS_ONLIVE_TWO_ISONLIVE = "请先提交到待审核";
	/** 等待审核	未上架	批量上/下架*/
	public static final String GOODS_PUBLISH_WAIT_ZERO_IS_ONLIVE_TWO_ISONLIVE = "请先提交到审核";




	/**请求参数校验失败*/
	public static final String SD_PARAMS_VALID_ERROR = "请求参数校验失败";
	/**商品下架失败*/
	public static final String SD_GOODS_ISONLIVE_UPDATE_ERROR = "商品下架失败";
	/**商品下架成功*/
	public static final String SD_GOODS_ISONLIVE_UPDATE_SUCCESS = "商品下架成功";
	/**商品上架提示*/
	public static final String SD_GOODS_ISONLIVE_UPDATE_NO_OPERATION = "顺道商品上架五福商城不同步上架，需五福后台审核上架";

	/** 商品sku库存更新失败*/
	public static final String SD_GOODS_STOCK_UPDATE_ERROR = "商品sku库存更新失败";

	/** 告警 */
	public static final String SD_GOODS_ALARM_ROUTE_KEY = "alarm.sender.sdgoods";   //sd告警路由key
	public static final String GOODS_ALARM_ROUTE_KEY = "alarm.sender.goods";    // 告警路由
	public static final int GOODS_ALARM_CODE = 10501;                               //告警代号
	public static final int SD_GOODS_ALARM_CODE = 10502;                               // sd告警代号
	public static final String GOODS_ALARM_IP = "localhost:10500";                  //告警应用ip
	public static final String GOODS_ALARM_TOPIC = "alarm";                         //告警主题

    /** 商品Redis缓存前缀 */
    public static final String GOODS_PREFIX= "GOODS_ID_%s";// 商品信息前缀 goods_id_id
    /** 商品Redis缓存前缀 */
    public static final String GOODS_COUNT_PREFIX= "GOODS_CACHE_COUNT_%s";// 商品计数前缀 goods_cache_count_id
}
