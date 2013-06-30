package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_grade", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaGradeEntity extends BaseObject implements Serializable {
    private Long id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String gradeName;

    @javax.persistence.Column(name = "grade_name")
    @Basic
    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    private String description;

    @javax.persistence.Column(name = "description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Date createTime;

    @javax.persistence.Column(name = "create_time")
    @Basic
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String currentYear;

    @javax.persistence.Column(name = "current_year")
    @Basic
    public String getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    private Integer currentHalf;

    @javax.persistence.Column(name = "current_half")
    @Basic
    public Integer getCurrentHalf() {
        return currentHalf;
    }

    public void setCurrentHalf(Integer currentHalf) {
        this.currentHalf = currentHalf;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaGradeEntity that = (OaGradeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (currentHalf != null ? !currentHalf.equals(that.currentHalf) : that.currentHalf != null) return false;
        if (currentYear != null ? !currentYear.equals(that.currentYear) : that.currentYear != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (gradeName != null ? !gradeName.equals(that.gradeName) : that.gradeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (gradeName != null ? gradeName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (currentYear != null ? currentYear.hashCode() : 0);
        result = 31 * result + (currentHalf != null ? currentHalf.hashCode() : 0);
        return result;
    }

    private Collection<OaClassEntity> oaClassesById;

    @OneToMany(mappedBy = "oaGradeByGradeId")
    public Collection<OaClassEntity> getOaClassesById() {
        return oaClassesById;
    }

    public void setOaClassesById(Collection<OaClassEntity> oaClassesById) {
        this.oaClassesById = oaClassesById;
    }

    private Collection<OaStudentGradeEntity> oaStudentGradesById;

    @OneToMany(mappedBy = "oaGradeByGradeId")
    public Collection<OaStudentGradeEntity> getOaStudentGradesById() {
        return oaStudentGradesById;
    }

    public void setOaStudentGradesById(Collection<OaStudentGradeEntity> oaStudentGradesById) {
        this.oaStudentGradesById = oaStudentGradesById;
    }

    private Collection<OaTeacherInfoEntity> oaTeacherInfosById;

    @OneToMany(mappedBy = "oaGradeByGradeId")
    public Collection<OaTeacherInfoEntity> getOaTeacherInfosById() {
        return oaTeacherInfosById;
    }

    public void setOaTeacherInfosById(Collection<OaTeacherInfoEntity> oaTeacherInfosById) {
        this.oaTeacherInfosById = oaTeacherInfosById;
    }
}
