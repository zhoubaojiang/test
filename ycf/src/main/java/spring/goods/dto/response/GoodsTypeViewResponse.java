package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: zhouzhiming
 * @Description:
 * @Dage: Created in 17:18 2018/3/22
 * @Modified By：
 */
@Getter
@Setter
public class GoodsTypeViewResponse implements Serializable {
    /**
     */
    private static final long serialVersionUID = 8261836162071709969L;

    @ApiModelProperty("订单ID")
    private Integer id;

    @ApiModelProperty("分类名")
    private String name;

    @ApiModelProperty("第一级分类名")
    private String firstName;

    @ApiModelProperty("第二级分类名")
    private String secName;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("分类层级")
    private Byte level;
}
