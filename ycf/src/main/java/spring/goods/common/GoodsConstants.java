package spring.goods.common;

/**
 * 商品模块自定义常量
 */
public class GoodsConstants {


	//商品分类层级
	public static final Byte GOODS_TYPE_LEVEL_ONE = 1;
	public static final Byte GOODS_TYPE_LEVEL_TWO = 2;
	public static final Byte GOODS_TYPE_LEVEL_THREE = 3;


    /** 商品Redis缓存前缀 */
    public static final String GOODS_PREFIX= "GOODS_ID_%s";// 商品信息前缀 goods_id_id
    /** 商品Redis缓存前缀 */
    public static final String GOODS_COUNT_PREFIX= "GOODS_CACHE_COUNT_%s";// 商品计数前缀 goods_cache_count_id
}
