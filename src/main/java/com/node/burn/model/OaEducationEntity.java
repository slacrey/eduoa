package com.node.burn.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_education", catalog = "eduoa")
@Entity
public class OaEducationEntity {
    private long id;

    @Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String eduName;

    @Column(name = "edu_name")
    @Basic
    String getEduName() {
        return eduName;
    }

    void setEduName(String eduName) {
        this.eduName = eduName;
    }

    private String description;

    @Column(name = "description")
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

        OaEducationEntity that = (OaEducationEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (eduName != null ? !eduName.equals(that.eduName) : that.eduName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (eduName != null ? eduName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private Collection<OaDepartmentEntity> oaDepartmentsById;

    @OneToMany(mappedBy = "oaEducationByEducationId")
    Collection<OaDepartmentEntity> getOaDepartmentsById() {
        return oaDepartmentsById;
    }

    void setOaDepartmentsById(Collection<OaDepartmentEntity> oaDepartmentsById) {
        this.oaDepartmentsById = oaDepartmentsById;
    }

    private OaEducationEntity oaEducationByParentId;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    OaEducationEntity getOaEducationByParentId() {
        return oaEducationByParentId;
    }

    void setOaEducationByParentId(OaEducationEntity oaEducationByParentId) {
        this.oaEducationByParentId = oaEducationByParentId;
    }

    private Collection<OaEducationEntity> oaEducationsById;

    @OneToMany(mappedBy = "oaEducationByParentId")
    Collection<OaEducationEntity> getOaEducationsById() {
        return oaEducationsById;
    }

    void setOaEducationsById(Collection<OaEducationEntity> oaEducationsById) {
        this.oaEducationsById = oaEducationsById;
    }
}
