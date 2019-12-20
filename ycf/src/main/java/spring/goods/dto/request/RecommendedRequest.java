package spring.goods.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RecommendedRequest extends PageBeanUtile {
    @ApiModelProperty(value = "商品分类ID")
    private Integer pmsType;

    @ApiModelProperty(value = "商品名")
    private String goodsName;

    @ApiModelProperty(value = "上新:0->上新")
    private Integer goodDesc;

    @ApiModelProperty(value = "排序：降序discount_price DESC,discount_price ASC升序")
    private String orderByClause;

}
