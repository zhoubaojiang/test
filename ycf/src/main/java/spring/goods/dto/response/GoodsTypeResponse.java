package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GoodsTypeResponse implements Serializable{

	/**
	*/
	private static final long serialVersionUID = 8261836162071709969L;

	@ApiModelProperty("订单ID")
	private Integer id;

	@ApiModelProperty("父级ID")
    private Integer pid;

	@ApiModelProperty("分类名")
    private String name;

	@ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("分类层级")
    private Byte level;
}
