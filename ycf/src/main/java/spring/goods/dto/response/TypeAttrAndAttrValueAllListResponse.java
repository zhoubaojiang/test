package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 
* 功能描述: 获取属性及属性值全部数据
* @author: xiongkun
* @date: 2017年11月30日 下午4:45:53
 */
@Data
public class TypeAttrAndAttrValueAllListResponse implements Serializable{

	
	/**
	*/
	private static final long serialVersionUID = -422755065845526129L;
	
	@ApiModelProperty("ID")
	private Integer id;
	@ApiModelProperty(value="属性名")
    private String attributeName;
	@ApiModelProperty(value="排序")
    private Byte sort;
	@ApiModelProperty(value="商品属性值")
	private List<TypeAttrValueResponse> attrValueList;
}
