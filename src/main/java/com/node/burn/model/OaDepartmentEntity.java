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
@SuppressWarnings("ALL")
@Table(name = "oa_department")
@Entity
public class OaDepartmentEntity extends BaseObject implements Serializable {
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

    private String departName;

    @Column(name = "depart_name")
    @Basic
    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
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
                .append(this.departName)
                .toString();
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
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public OaDepartmentEntity getOaDepartmentByParentId() {
        return oaDepartmentByParentId;
    }

    public void setOaDepartmentByParentId(OaDepartmentEntity oaDepartmentByParentId) {
        this.oaDepartmentByParentId = oaDepartmentByParentId;
    }

    private Collection<OaDepartmentEntity> oaDepartmentsById;

    @OneToMany(mappedBy = "oaDepartmentByParentId")
    public Collection<OaDepartmentEntity> getOaDepartmentsById() {
        return oaDepartmentsById;
    }

    public void setOaDepartmentsById(Collection<OaDepartmentEntity> oaDepartmentsById) {
        this.oaDepartmentsById = oaDepartmentsById;
    }

    private OaEducationEntity oaEducationByEducationId;

    @ManyToOne
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    public OaEducationEntity getOaEducationByEducationId() {
        return oaEducationByEducationId;
    }

    public void setOaEducationByEducationId(OaEducationEntity oaEducationByEducationId) {
        this.oaEducationByEducationId = oaEducationByEducationId;
    }

    private Collection<OaTeacherInfoEntity> oaTeacherInfosById;

    @OneToMany(mappedBy = "oaDepartmentByDepartmentId")
    public Collection<OaTeacherInfoEntity> getOaTeacherInfosById() {
        return oaTeacherInfosById;
    }

    public void setOaTeacherInfosById(Collection<OaTeacherInfoEntity> oaTeacherInfosById) {
        this.oaTeacherInfosById = oaTeacherInfosById;
    }
}
