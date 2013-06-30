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
@Table(name = "oa_teacher_info", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaTeacherInfoEntity extends BaseObject implements Serializable {
    private Long id;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String teacherName;

    @Column(name = "teacher_name")
    @Basic
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    private String teacherNumber;

    @Column(name = "teacher_number")
    @Basic
    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    private String idNumber;

    @Column(name = "id_number")
    @Basic
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    private Integer isTeacher;

    @Column(name = "is_teacher")
    @Basic
    public Integer getTeacher() {
        return isTeacher;
    }

    public void setTeacher(Integer teacher) {
        isTeacher = teacher;
    }

    private String phone;

    @Column(name = "phone")
    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private Integer headTeacher;

    @Column(name = "head_teacher")
    @Basic
    public Integer getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(Integer headTeacher) {
        this.headTeacher = headTeacher;
    }

    private String email;

    @Column(name = "email")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Integer gender;

    @Column(name = "gender")
    @Basic
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    private Date birthday;

    @Column(name = "birthday")
    @Basic
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private Integer politicalLandscape;

    @Column(name = "political_landscape")
    @Basic
    public Integer getPoliticalLandscape() {
        return politicalLandscape;
    }

    public void setPoliticalLandscape(Integer politicalLandscape) {
        this.politicalLandscape = politicalLandscape;
    }

    private Date joinTime;

    @Column(name = "join_time")
    @Basic
    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    private Date workingTime;

    @Column(name = "working_time")
    @Basic
    public Date getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Date workingTime) {
        this.workingTime = workingTime;
    }

    private String originalEducation;

    @Column(name = "original_education")
    @Basic
    public String getOriginalEducation() {
        return originalEducation;
    }

    public void setOriginalEducation(String originalEducation) {
        this.originalEducation = originalEducation;
    }

    private Date originalEducationTime;

    @Column(name = "original_education_time")
    @Basic
    public Date getOriginalEducationTime() {
        return originalEducationTime;
    }

    public void setOriginalEducationTime(Date originalEducationTime) {
        this.originalEducationTime = originalEducationTime;
    }

    private String special;

    @Column(name = "special")
    @Basic
    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    private String newEducation;

    @Column(name = "new_education")
    @Basic
    public String getNewEducation() {
        return newEducation;
    }

    public void setNewEducation(String newEducation) {
        this.newEducation = newEducation;
    }

    private Date newEducationTime;

    @Column(name = "new_education_time")
    @Basic
    public Date getNewEducationTime() {
        return newEducationTime;
    }

    public void setNewEducationTime(Date newEducationTime) {
        this.newEducationTime = newEducationTime;
    }

    private Date certificatesTime;

    @Column(name = "certificates_time")
    @Basic
    public Date getCertificatesTime() {
        return certificatesTime;
    }

    public void setCertificatesTime(Date certificatesTime) {
        this.certificatesTime = certificatesTime;
    }

    private Integer establishment;

    @Column(name = "establishment")
    @Basic
    public Integer getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Integer establishment) {
        this.establishment = establishment;
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

    private Date updateTime;

    @Column(name = "update_time")
    @Basic
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaTeacherInfoEntity that = (OaTeacherInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (certificatesTime != null ? !certificatesTime.equals(that.certificatesTime) : that.certificatesTime != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (establishment != null ? !establishment.equals(that.establishment) : that.establishment != null)
            return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (headTeacher != null ? !headTeacher.equals(that.headTeacher) : that.headTeacher != null) return false;
        if (idNumber != null ? !idNumber.equals(that.idNumber) : that.idNumber != null) return false;
        if (isTeacher != null ? !isTeacher.equals(that.isTeacher) : that.isTeacher != null) return false;
        if (joinTime != null ? !joinTime.equals(that.joinTime) : that.joinTime != null) return false;
        if (newEducation != null ? !newEducation.equals(that.newEducation) : that.newEducation != null) return false;
        if (newEducationTime != null ? !newEducationTime.equals(that.newEducationTime) : that.newEducationTime != null)
            return false;
        if (originalEducation != null ? !originalEducation.equals(that.originalEducation) : that.originalEducation != null)
            return false;
        if (originalEducationTime != null ? !originalEducationTime.equals(that.originalEducationTime) : that.originalEducationTime != null)
            return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (politicalLandscape != null ? !politicalLandscape.equals(that.politicalLandscape) : that.politicalLandscape != null)
            return false;
        if (special != null ? !special.equals(that.special) : that.special != null) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
        if (teacherNumber != null ? !teacherNumber.equals(that.teacherNumber) : that.teacherNumber != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (workingTime != null ? !workingTime.equals(that.workingTime) : that.workingTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (teacherNumber != null ? teacherNumber.hashCode() : 0);
        result = 31 * result + (idNumber != null ? idNumber.hashCode() : 0);
        result = 31 * result + (isTeacher != null ? isTeacher.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (headTeacher != null ? headTeacher.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (politicalLandscape != null ? politicalLandscape.hashCode() : 0);
        result = 31 * result + (joinTime != null ? joinTime.hashCode() : 0);
        result = 31 * result + (workingTime != null ? workingTime.hashCode() : 0);
        result = 31 * result + (originalEducation != null ? originalEducation.hashCode() : 0);
        result = 31 * result + (originalEducationTime != null ? originalEducationTime.hashCode() : 0);
        result = 31 * result + (special != null ? special.hashCode() : 0);
        result = 31 * result + (newEducation != null ? newEducation.hashCode() : 0);
        result = 31 * result + (newEducationTime != null ? newEducationTime.hashCode() : 0);
        result = 31 * result + (certificatesTime != null ? certificatesTime.hashCode() : 0);
        result = 31 * result + (establishment != null ? establishment.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    private Collection<OaCertificateEntity> oaCertificatesById;

    @OneToMany(mappedBy = "oaTeacherInfoByTeacherId")
    public Collection<OaCertificateEntity> getOaCertificatesById() {
        return oaCertificatesById;
    }

    public void setOaCertificatesById(Collection<OaCertificateEntity> oaCertificatesById) {
        this.oaCertificatesById = oaCertificatesById;
    }

    private Collection<OaClassTeacherEntity> oaClassTeachersById;

    @OneToMany(mappedBy = "oaTeacherInfoByTeacherId")
    public Collection<OaClassTeacherEntity> getOaClassTeachersById() {
        return oaClassTeachersById;
    }

    public void setOaClassTeachersById(Collection<OaClassTeacherEntity> oaClassTeachersById) {
        this.oaClassTeachersById = oaClassTeachersById;
    }

    private OaSubjectEntity oaSubjectBySubjectId;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    public OaSubjectEntity getOaSubjectBySubjectId() {
        return oaSubjectBySubjectId;
    }

    public void setOaSubjectBySubjectId(OaSubjectEntity oaSubjectBySubjectId) {
        this.oaSubjectBySubjectId = oaSubjectBySubjectId;
    }

    private OaDepartmentEntity oaDepartmentByDepartmentId;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    public OaDepartmentEntity getOaDepartmentByDepartmentId() {
        return oaDepartmentByDepartmentId;
    }

    public void setOaDepartmentByDepartmentId(OaDepartmentEntity oaDepartmentByDepartmentId) {
        this.oaDepartmentByDepartmentId = oaDepartmentByDepartmentId;
    }

    private OaGradeEntity oaGradeByGradeId;

    @ManyToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    public OaGradeEntity getOaGradeByGradeId() {
        return oaGradeByGradeId;
    }

    public void setOaGradeByGradeId(OaGradeEntity oaGradeByGradeId) {
        this.oaGradeByGradeId = oaGradeByGradeId;
    }

    private OaPositionEntity oaPositionByPositionId;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    public OaPositionEntity getOaPositionByPositionId() {
        return oaPositionByPositionId;
    }

    public void setOaPositionByPositionId(OaPositionEntity oaPositionByPositionId) {
        this.oaPositionByPositionId = oaPositionByPositionId;
    }

    private Collection<SysUserEntity> sysUsersById;

    @OneToMany(mappedBy = "oaTeacherInfoByTeacherId")
    public Collection<SysUserEntity> getSysUsersById() {
        return sysUsersById;
    }

    public void setSysUsersById(Collection<SysUserEntity> sysUsersById) {
        this.sysUsersById = sysUsersById;
    }
}
