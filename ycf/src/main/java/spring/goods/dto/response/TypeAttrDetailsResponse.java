package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 
* 功能描述: 商品attr详情返回类
* @author: xiongkun
* @date: 2017年11月20日 下午5:00:26
 */
@Getter
@Setter
public class TypeAttrDetailsResponse implements Serializable{

	/**
	*/
	private static final long serialVersionUID = -8403950391937481829L;
	
	@ApiModelProperty("ID")
	private Integer id;
	@ApiModelProperty(value="属性名")
    private String attributeName;
	@ApiModelProperty(value="排序")
    private Byte sort;
	@ApiModelProperty(value="属性值")
	private List<TypeAttrValueResponse> typeAttrs;
}
