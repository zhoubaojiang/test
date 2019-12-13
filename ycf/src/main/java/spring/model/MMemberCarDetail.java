package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MMemberCarDetail implements Serializable {
    private Long id;

    private Long memberCarId;

    private Long goodsId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberCarId() {
        return memberCarId;
    }

    public void setMemberCarId(Long memberCarId) {
        this.memberCarId = memberCarId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberCarId=").append(memberCarId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}