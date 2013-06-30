package com.node.burn.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_department", schema = "", catalog = "eduoa")
@Entity
public class OaDepartmentEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String departName;

    @javax.persistence.Column(name = "depart_name")
    @Basic
    String getDepartName() {
        return departName;
    }

    void setDepartName(String departName) {
        this.departName = departName;
    }

    private String description;

    @javax.persistence.Column(name = "description")
    @Basic
    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaDepartmentEntity that = (OaDepartmentEntity) o;

        if (id != that.id) return false;
        if (departName != null ? !departName.equals(that.departName) : that.departName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (departName != null ? departName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private OaDepartmentEntity oaDepartmentByParentId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "parent_id", referencedColumnName = "id")
    OaDepartmentEntity getOaDepartmentByParentId() {
        return oaDepartmentByParentId;
    }

    void setOaDepartmentByParentId(OaDepartmentEntity oaDepartmentByParentId) {
        this.oaDepartmentByParentId = oaDepartmentByParentId;
    }

    private Collection<OaDepartmentEntity> oaDepartmentsById;

    @OneToMany(mappedBy = "oaDepartmentByParentId")
    Collection<OaDepartmentEntity> getOaDepartmentsById() {
        return oaDepartmentsById;
    }

    void setOaDepartmentsById(Collection<OaDepartmentEntity> oaDepartmentsById) {
        this.oaDepartmentsById = oaDepartmentsById;
    }

    private OaEducationEntity oaEducationByEducationId;

    @ManyToOne
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    OaEducationEntity getOaEducationByEducationId() {
        return oaEducationByEducationId;
    }

    void setOaEducationByEducationId(OaEducationEntity oaEducationByEducationId) {
        this.oaEducationByEducationId = oaEducationByEducationId;
    }

    private Collection<OaTeacherInfoEntity> oaTeacherInfosById;

    @OneToMany(mappedBy = "oaDepartmentByDepartmentId")
    Collection<OaTeacherInfoEntity> getOaTeacherInfosById() {
        return oaTeacherInfosById;
    }

    void setOaTeacherInfosById(Collection<OaTeacherInfoEntity> oaTeacherInfosById) {
        this.oaTeacherInfosById = oaTeacherInfosById;
    }
}
