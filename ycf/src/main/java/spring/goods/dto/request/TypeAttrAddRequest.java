package spring.goods.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
* 功能描述: 获取商品attr新增请求类
* @author: xiongkun
* @date: 2017年11月20日 下午4:30:32
 */
@Data
public class TypeAttrAddRequest {
	  
	@ApiModelProperty(value="属性名")
    private String attributeName;
	@ApiModelProperty(value="排序")
    private Byte sort;
}
