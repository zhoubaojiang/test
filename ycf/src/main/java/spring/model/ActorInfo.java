package spring.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ActorInfo implements Serializable {
    private Integer actorId;

    private Integer firstName;

    private Integer lastName;

    private Integer filmInfo;

    private static final long serialVersionUID = 1L;

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public Integer getFirstName() {
        return firstName;
    }

    public void setFirstName(Integer firstName) {
        this.firstName = firstName;
    }

    public Integer getLastName() {
        return lastName;
    }

    public void setLastName(Integer lastName) {
        this.lastName = lastName;
    }

    public Integer getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(Integer filmInfo) {
        this.filmInfo = filmInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", actorId=").append(actorId);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", filmInfo=").append(filmInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}