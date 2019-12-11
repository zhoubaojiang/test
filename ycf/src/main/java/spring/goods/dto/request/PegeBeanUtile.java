package spring.goods.dto.request;

import spring.utils.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PegeBeanUtile {
    /** 当前页 */
    @ApiModelProperty(value="当前分页数，默认：1")
    private Integer page = Constants.DEFAULT_PAGE;
    /** 每页记录数 */
    @ApiModelProperty(value="当前分页条数，默认：20")
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
}
