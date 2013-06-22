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
@javax.persistence.Table(name = "oa_student", catalog = "eduoa")
@Entity
public class OaStudentEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String studentName;

    @javax.persistence.Column(name = "student_name")
    @Basic
    String getStudentName() {
        return studentName;
    }

    void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private String idNumber;

    @javax.persistence.Column(name = "id_number")
    @Basic
    String getIdNumber() {
        return idNumber;
    }

    void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    private Integer gender;

    @javax.persistence.Column(name = "gender")
    @Basic
    Integer getGender() {
        return gender;
    }

    void setGender(Integer gender) {
        this.gender = gender;
    }

    private String studentNumber;

    @javax.persistence.Column(name = "student_number")
    @Basic
    String getStudentNumber() {
        return studentNumber;
    }

    void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    private Date birthday;

    @javax.persistence.Column(name = "birthday")
    @Basic
    Date getBirthday() {
        return birthday;
    }

    void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    private Date updateTime;

    @javax.persistence.Column(name = "update_time")
    @Basic
    Date getUpdateTime() {
        return updateTime;
    }

    void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private Long operatorId;

    @javax.persistence.Column(name = "operator_id")
    @Basic
    Long getOperatorId() {
        return operatorId;
    }

    void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaStudentEntity that = (OaStudentEntity) o;

        if (id != that.id) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (idNumber != null ? !idNumber.equals(that.idNumber) : that.idNumber != null) return false;
        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        if (studentNumber != null ? !studentNumber.equals(that.studentNumber) : that.studentNumber != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (idNumber != null ? idNumber.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (studentNumber != null ? studentNumber.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        return result;
    }

    private Collection<OaContactEntity> oaContactsById;

    @OneToMany(mappedBy = "oaStudentByStudentId")
    Collection<OaContactEntity> getOaContactsById() {
        return oaContactsById;
    }

    void setOaContactsById(Collection<OaContactEntity> oaContactsById) {
        this.oaContactsById = oaContactsById;
    }

    private Collection<OaStudentClassEntity> oaStudentClassesById;

    @OneToMany(mappedBy = "oaStudentByStudentId")
    Collection<OaStudentClassEntity> getOaStudentClassesById() {
        return oaStudentClassesById;
    }

    void setOaStudentClassesById(Collection<OaStudentClassEntity> oaStudentClassesById) {
        this.oaStudentClassesById = oaStudentClassesById;
    }

    private Collection<OaStudentGradeEntity> oaStudentGradesById;

    @OneToMany(mappedBy = "oaStudentByStudentId")
    Collection<OaStudentGradeEntity> getOaStudentGradesById() {
        return oaStudentGradesById;
    }

    void setOaStudentGradesById(Collection<OaStudentGradeEntity> oaStudentGradesById) {
        this.oaStudentGradesById = oaStudentGradesById;
    }
}
