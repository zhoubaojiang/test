package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 
* 功能描述: 商品分类详情返回类
* @author: xiongkun
* @date: 2017年11月20日 下午5:00:26
 */
@Getter
@Setter
public class GoodsTypeDetailsResponse implements Serializable{

	/**
	*/
	private static final long serialVersionUID = 821757115771151904L;
	
	@ApiModelProperty(value = "商品类型ID")
	private Integer id;
	@ApiModelProperty(value = "父级ID")
	private Integer pid;
	@ApiModelProperty(value = "父级分类名称")
	private String pName;
	@ApiModelProperty(value = "分类名")
	private String name;
	@ApiModelProperty(value = "排序")
	private Integer sort;
	@ApiModelProperty(value = "是否显示在APP首页分类")
	private Byte appHome;
	@ApiModelProperty(value="图片全路径前缀，例：http://wftest.oss-cn-shenzhen.aliyuncs.com")
	private String imgUrlPrix;
	@ApiModelProperty(value = "当前图标")
	private String icon;
	@ApiModelProperty(value = "分类层级")
	private Byte level;
	@ApiModelProperty(value = "attr属性")
	private List<TypeAttrResponse> attrList;

}
