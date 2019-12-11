package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TypeAttrAllListResponse implements Serializable{
	/**
	*/
	private static final long serialVersionUID = -8894511308336337708L;
	
	@ApiModelProperty("ID")
	private Integer id;
	@ApiModelProperty(value="属性名")
    private String attributeName;
	@ApiModelProperty(value="排序")
    private Byte sort;
}
