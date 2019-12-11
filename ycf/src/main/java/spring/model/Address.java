package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable {
    private Short addressId;

    private String address;

    private String address2;

    private String district;

    private Short cityId;

    private String postalCode;

    private String phone;

    private Date lastUpdate;

    private byte[] location;

    private static final long serialVersionUID = 1L;

    public Short getAddressId() {
        return addressId;
    }

    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Short getCityId() {
        return cityId;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public byte[] getLocation() {
        return location;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addressId=").append(addressId);
        sb.append(", address=").append(address);
        sb.append(", address2=").append(address2);
        sb.append(", district=").append(district);
        sb.append(", cityId=").append(cityId);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", phone=").append(phone);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", location=").append(location);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}