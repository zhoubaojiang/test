package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class PGoodsType implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "父级ID")
    private Integer pid;

    @ApiModelProperty(value = "分类名")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否删除")
    private Byte isdelete;

    @ApiModelProperty(value = "是否显示在APP首页分类")
    private Byte apphome;

    @ApiModelProperty(value = "当前图标")
    private String icon;

    @ApiModelProperty(value = "分类层级")
    private Byte level;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }

    public Byte getApphome() {
        return apphome;
    }

    public void setApphome(Byte apphome) {
        this.apphome = apphome;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", apphome=").append(apphome);
        sb.append(", icon=").append(icon);
        sb.append(", level=").append(level);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}