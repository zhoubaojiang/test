package spring.goods.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
* 功能描述: 获取商品属性全部列表(不分页)请求类
* @author: xiongkun
* @date: 2017年11月20日 下午4:30:32
 */
@Data
public class TypeAttrAllListRequest {
	  @ApiModelProperty(value="商品属性名  不能为空")
	  @NotBlank(message="商品属性名不能为空")
	  private String attributeName;
}
