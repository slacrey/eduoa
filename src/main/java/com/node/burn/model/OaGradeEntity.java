package com.node.burn.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_grade")
@Entity
public class OaGradeEntity extends BaseObject implements Serializable {
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

    private String gradeName;

    @Column(name = "grade_name")
    @Basic
    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
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

    private Date createTime;

    @Column(name = "create_time")
    @Basic
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String currentYear;

    @Column(name = "current_year")
    @Basic
    public String getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    private Integer currentHalf;

    @Column(name = "current_half")
    @Basic
    public Integer getCurrentHalf() {
        return currentHalf;
    }

    public void setCurrentHalf(Integer currentHalf) {
        this.currentHalf = currentHalf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.gradeName)
                .toString();
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
