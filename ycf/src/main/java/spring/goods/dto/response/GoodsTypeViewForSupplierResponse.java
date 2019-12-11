package spring.goods.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: ylm
 * @Description:
 * @Dage: Created in 11:39 2019/3/18
 * @Modified By：
 */
@Getter
@Setter
public class GoodsTypeViewForSupplierResponse implements Serializable {
    /**
     */
    private static final long serialVersionUID = 8261836162071709969L;

    @ApiModelProperty("类目ID")
    private Integer id;

    @ApiModelProperty("类目名称")
    private String name;

    public GoodsTypeViewForSupplierResponse(Integer id, String name){
        this.id = id;
        this.name = name;
    }


}
