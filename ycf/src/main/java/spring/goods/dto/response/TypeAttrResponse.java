package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TypeAttrResponse implements Serializable{
	
	private static final long serialVersionUID = 4585946277015263683L;
	
	@ApiModelProperty("ID")
	private Integer id;
	@ApiModelProperty(value="属性名")
    private String attributeName;
	@ApiModelProperty(value="排序")
    private Byte sort;
}
