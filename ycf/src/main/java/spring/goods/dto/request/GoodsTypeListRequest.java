package spring.goods.dto.request;

import spring.utils.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
* 功能描述: 获取商品分类列表请求类
* @author: xiongkun
* @date: 2017年11月20日 下午4:30:45
 */
@Data
public class GoodsTypeListRequest {
	  /** 当前页 */
	  @ApiModelProperty(value="当前分页数，默认：1")
	  private Integer page = Constants.DEFAULT_PAGE;
	  /** 每页记录数 */
	  @ApiModelProperty(value="当前分页条数，默认：20")
	  private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
	  /** 分类名 */
	  @ApiModelProperty(value="分类名")
	  private String name;
	  @ApiModelProperty(value="父级ID,顶级分类时父级ID为0")
	  private Integer pid = 0;
	  @ApiModelProperty(value="层级")
	  private Integer level;
}
