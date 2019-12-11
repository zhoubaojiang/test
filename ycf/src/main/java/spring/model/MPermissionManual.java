package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MPermissionManual implements Serializable {
    @ApiModelProperty(value = "权限表主键")
    private Long permissionId;

    @ApiModelProperty(value = "权限表父标签")
    private Long parentId;

    @ApiModelProperty(value = "权限名称")
    private String permissionName;

    @ApiModelProperty(value = "权限描述")
    private String permissionDesc;

    @ApiModelProperty(value = "权限key")
    private String permissionKey;

    @ApiModelProperty(value = "权限链接")
    private String permissionUrl;

    @ApiModelProperty(value = "权限类型")
    private String permissionType;

    @ApiModelProperty(value = "权限链接图片")
    private String permissionImg;

    @ApiModelProperty(value = "状态:0可使用,1不可使用")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getPermissionImg() {
        return permissionImg;
    }

    public void setPermissionImg(String permissionImg) {
        this.permissionImg = permissionImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", permissionId=").append(permissionId);
        sb.append(", parentId=").append(parentId);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", permissionDesc=").append(permissionDesc);
        sb.append(", permissionKey=").append(permissionKey);
        sb.append(", permissionUrl=").append(permissionUrl);
        sb.append(", permissionType=").append(permissionType);
        sb.append(", permissionImg=").append(permissionImg);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}