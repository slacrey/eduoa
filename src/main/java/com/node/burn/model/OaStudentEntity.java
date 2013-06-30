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
@javax.persistence.Table(name = "oa_student", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaStudentEntity extends BaseObject implements Serializable {
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

    private String studentName;

    @javax.persistence.Column(name = "student_name")
    @Basic
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private String idNumber;

    @javax.persistence.Column(name = "id_number")
    @Basic
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    private Integer gender;

    @javax.persistence.Column(name = "gender")
    @Basic
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    private String studentNumber;

    @javax.persistence.Column(name = "student_number")
    @Basic
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    private Date birthday;

    @javax.persistence.Column(name = "birthday")
    @Basic
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    private Date updateTime;

    @javax.persistence.Column(name = "update_time")
    @Basic
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private Long operatorId;

    @javax.persistence.Column(name = "operator_id")
    @Basic
    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaStudentEntity that = (OaStudentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
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
    public Collection<OaContactEntity> getOaContactsById() {
        return oaContactsById;
    }

    public void setOaContactsById(Collection<OaContactEntity> oaContactsById) {
        this.oaContactsById = oaContactsById;
    }

    private Collection<OaStudentClassEntity> oaStudentClassesById;

    @OneToMany(mappedBy = "oaStudentByStudentId")
    public Collection<OaStudentClassEntity> getOaStudentClassesById() {
        return oaStudentClassesById;
    }

    public void setOaStudentClassesById(Collection<OaStudentClassEntity> oaStudentClassesById) {
        this.oaStudentClassesById = oaStudentClassesById;
    }

    private Collection<OaStudentGradeEntity> oaStudentGradesById;

    @OneToMany(mappedBy = "oaStudentByStudentId")
    public Collection<OaStudentGradeEntity> getOaStudentGradesById() {
        return oaStudentGradesById;
    }

    public void setOaStudentGradesById(Collection<OaStudentGradeEntity> oaStudentGradesById) {
        this.oaStudentGradesById = oaStudentGradesById;
    }
}
