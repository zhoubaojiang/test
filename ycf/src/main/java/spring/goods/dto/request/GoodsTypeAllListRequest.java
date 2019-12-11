package spring.goods.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 
* 功能描述: 获取商品分类全部列表
* @date: 2017年11月22日 下午5:28:08
 */
@Data
public class GoodsTypeAllListRequest implements Serializable{
	
	/**
	*/
	private static final long serialVersionUID = 6060711520859739476L;
	
	/**商品分类ID*/
	private Integer pid = 0;
}
