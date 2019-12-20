package spring.goods.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsMemberRequset extends PageBeanUtile {

    @ApiModelProperty(value = "商品分类ID:pms_product_category")
    private Long pmsType;
}
