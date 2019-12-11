package spring.goods.dto.request;

import spring.utils.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
* 功能描述: 获取商品属性列表请求类
* @author: xiongkun
* @date: 2017年11月20日 下午4:30:32
 */
@Data
public class TypeAttrListRequest {
	  /** 当前页 */
	  @ApiModelProperty(value="当前分页数，默认：1")
	  private Integer page = Constants.DEFAULT_PAGE;
	  /** 每页记录数 */
	  @ApiModelProperty(value="当前分页条数，默认：20")
	  private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
}
