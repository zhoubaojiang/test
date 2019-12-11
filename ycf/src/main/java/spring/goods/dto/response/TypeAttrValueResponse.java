package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TypeAttrValueResponse implements Serializable{
	
	private static final long serialVersionUID = 4585946277015263683L;
	
	@ApiModelProperty(value = "ID")
	private Integer id;
	@ApiModelProperty(value = "属性ID")
	private Integer attributeId;
	@ApiModelProperty(value = "属性值")
	private String attributeValue;
	@ApiModelProperty(value = "排序")
    private Byte sort;
	@ApiModelProperty(value = "是否选中")
    private Integer isChecked;
}
