package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 
* 功能描述: 商品属性app返回值
* @author: xiongkun
* @date: 2017年11月23日 上午11:55:41
 */
@Getter
@Setter
public class AppTypeAttrResponse implements Serializable{
	
	
	/**
	*/
	private static final long serialVersionUID = -7500501238070820940L;
	
	@ApiModelProperty("ID")
	private Integer id;
	@ApiModelProperty(value="属性名")
    private String attributeName;
	@ApiModelProperty(value="排序")
    private Byte sort;
	@ApiModelProperty(value="属性值")
	private List<TypeAttrValueResponse> attrValueList;
}
