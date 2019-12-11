package spring.goods.dto.request;

import spring.utils.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 
* 功能描述: 获取商品列表请求类
* @author: xiongkun
* @date: 2017年11月27日 下午4:30:32
 */
@Data
public class GoodsListReq extends PegeBeanUtile{

	@ApiModelProperty(value = "商品ID")
	private Long id;

	@ApiModelProperty(value = "商品名称")
	private String goodsName;

	@ApiModelProperty(value = "商品分类ID")
	private Long pmsType;

	@ApiModelProperty(value = "商品品相：0全新，1优良，2普通，3轻度磨损，4不合格")
	private Integer goodsCondition;

	@ApiModelProperty(value = "折扣价最低")
	private BigDecimal highPrice;

	@ApiModelProperty(value = "折扣价最高")
	private BigDecimal lowPrice;

	@ApiModelProperty(value = "商品状态：0上架，1未上架")
	private Integer goodsState;

	@ApiModelProperty(value = "是否已出售：0是，1否")
	private Integer goodsNumType;

}
