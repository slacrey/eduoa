package com.node.burn.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_position")
@Entity
public class OaPositionEntity extends BaseObject implements Serializable {
    private Long id;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String positionName;

    @Column(name = "position_name")
    @Basic
    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    private String description;

    @Column(name = "description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.positionName)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaPositionEntity that = (OaPositionEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (positionName != null ? !positionName.equals(that.positionName) : that.positionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (positionName != null ? positionName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private Collection<OaTeacherInfoEntity> oaTeacherInfosById;

    @OneToMany(mappedBy = "oaPositionByPositionId")
    public Collection<OaTeacherInfoEntity> getOaTeacherInfosById() {
        return oaTeacherInfosById;
    }

    public void setOaTeacherInfosById(Collection<OaTeacherInfoEntity> oaTeacherInfosById) {
        this.oaTeacherInfosById = oaTeacherInfosById;
    }
}
