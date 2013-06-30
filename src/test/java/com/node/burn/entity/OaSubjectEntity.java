package com.node.burn.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_subject", schema = "", catalog = "eduoa")
@Entity
public class OaSubjectEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String subjectName;

    @javax.persistence.Column(name = "subject_name")
    @Basic
    String getSubjectName() {
        return subjectName;
    }

    void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

        OaSubjectEntity that = (OaSubjectEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (subjectName != null ? !subjectName.equals(that.subjectName) : that.subjectName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private Collection<OaTeacherInfoEntity> oaTeacherInfosById;

    @OneToMany(mappedBy = "oaSubjectBySubjectId")
    Collection<OaTeacherInfoEntity> getOaTeacherInfosById() {
        return oaTeacherInfosById;
    }

    void setOaTeacherInfosById(Collection<OaTeacherInfoEntity> oaTeacherInfosById) {
        this.oaTeacherInfosById = oaTeacherInfosById;
    }
}
