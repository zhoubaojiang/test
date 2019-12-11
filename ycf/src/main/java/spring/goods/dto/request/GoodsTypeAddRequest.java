package spring.goods.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 功能描述: 获取商品分类详情请求类
 * 
 * @author: xiongkun
 * @date: 2017年11月20日 下午4:30:32
 */
@Data
public class GoodsTypeAddRequest {

	@ApiModelProperty(value = "父级ID")
	private Integer pid;
	@ApiModelProperty(value = "分类名")
	private String name;
	@ApiModelProperty(value = "排序")
	private Integer sort;
	@ApiModelProperty(value = "是否显示在APP首页分类")
	private Byte appHome;
	@ApiModelProperty(value = "当前图标")
	private String icon;
	@ApiModelProperty(value = "分类层级")
	private Byte level;
	@ApiModelProperty(value = "属性ID")
	private Integer[] attrIds;
}
