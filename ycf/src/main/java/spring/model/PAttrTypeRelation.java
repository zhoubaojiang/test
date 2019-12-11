package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class PAttrTypeRelation implements Serializable {
    private Integer attrId;

    private Integer goodsTypeId;

    private static final long serialVersionUID = 1L;

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attrId=").append(attrId);
        sb.append(", goodsTypeId=").append(goodsTypeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}