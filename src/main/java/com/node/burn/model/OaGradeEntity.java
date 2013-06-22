package com.node.burn.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_grade", catalog = "eduoa")
@Entity
public class OaGradeEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String gradeName;

    @javax.persistence.Column(name = "grade_name")
    @Basic
    String getGradeName() {
        return gradeName;
    }

    void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    private Integer gradeType;

    @javax.persistence.Column(name = "grade_type")
    @Basic
    Integer getGradeType() {
        return gradeType;
    }

    void setGradeType(Integer gradeType) {
        this.gradeType = gradeType;
    }

    private Integer grade;

    @javax.persistence.Column(name = "grade")
    @Basic
    Integer getGrade() {
        return grade;
    }

    void setGrade(Integer grade) {
        this.grade = grade;
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

    private Date createTime;

    @javax.persistence.Column(name = "create_time")
    @Basic
    Date getCreateTime() {
        return createTime;
    }

    void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String currentYear;

    @javax.persistence.Column(name = "current_year")
    @Basic
    String getCurrentYear() {
        return currentYear;
    }

    void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    private Integer currentHalf;

    @javax.persistence.Column(name = "current_half")
    @Basic
    Integer getCurrentHalf() {
        return currentHalf;
    }

    void setCurrentHalf(Integer currentHalf) {
        this.currentHalf = currentHalf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaGradeEntity that = (OaGradeEntity) o;

        if (id != that.id) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (currentHalf != null ? !currentHalf.equals(that.currentHalf) : that.currentHalf != null) return false;
        if (currentYear != null ? !currentYear.equals(that.currentYear) : that.currentYear != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (gradeName != null ? !gradeName.equals(that.gradeName) : that.gradeName != null) return false;
        if (gradeType != null ? !gradeType.equals(that.gradeType) : that.gradeType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (gradeName != null ? gradeName.hashCode() : 0);
        result = 31 * result + (gradeType != null ? gradeType.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (currentYear != null ? currentYear.hashCode() : 0);
        result = 31 * result + (currentHalf != null ? currentHalf.hashCode() : 0);
        return result;
    }

    private Collection<OaClassEntity> oaClassesById;

    @OneToMany(mappedBy = "oaGradeByGradeId")
    Collection<OaClassEntity> getOaClassesById() {
        return oaClassesById;
    }

    void setOaClassesById(Collection<OaClassEntity> oaClassesById) {
        this.oaClassesById = oaClassesById;
    }

    private Collection<OaStudentGradeEntity> oaStudentGradesById;

    @OneToMany(mappedBy = "oaGradeByGradeId")
    Collection<OaStudentGradeEntity> getOaStudentGradesById() {
        return oaStudentGradesById;
    }

    void setOaStudentGradesById(Collection<OaStudentGradeEntity> oaStudentGradesById) {
        this.oaStudentGradesById = oaStudentGradesById;
    }

    private Collection<OaTeacherInfoEntity> oaTeacherInfosById;

    @OneToMany(mappedBy = "oaGradeByGradeId")
    Collection<OaTeacherInfoEntity> getOaTeacherInfosById() {
        return oaTeacherInfosById;
    }

    void setOaTeacherInfosById(Collection<OaTeacherInfoEntity> oaTeacherInfosById) {
        this.oaTeacherInfosById = oaTeacherInfosById;
    }
}
