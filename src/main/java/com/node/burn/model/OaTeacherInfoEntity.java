package com.node.burn.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_teacher_info", catalog = "eduoa")
@Entity
public class OaTeacherInfoEntity {
    private long id;

    @Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String teacherName;

    @Column(name = "teacher_name")
    @Basic
    String getTeacherName() {
        return teacherName;
    }

    void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    private String teacherNumber;

    @Column(name = "teacher_number")
    @Basic
    String getTeacherNumber() {
        return teacherNumber;
    }

    void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    private String idNumber;

    @Column(name = "id_number")
    @Basic
    String getIdNumber() {
        return idNumber;
    }

    void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    private Integer isTeacher;

    @Column(name = "is_teacher")
    @Basic
    Integer getTeacher() {
        return isTeacher;
    }

    void setTeacher(Integer teacher) {
        isTeacher = teacher;
    }

    private String phone;

    @Column(name = "phone")
    @Basic
    String getPhone() {
        return phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }

    private Integer headTeacher;

    @Column(name = "head_teacher")
    @Basic
    Integer getHeadTeacher() {
        return headTeacher;
    }

    void setHeadTeacher(Integer headTeacher) {
        this.headTeacher = headTeacher;
    }

    private String email;

    @Column(name = "email")
    @Basic
    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    private Integer gender;

    @Column(name = "gender")
    @Basic
    Integer getGender() {
        return gender;
    }

    void setGender(Integer gender) {
        this.gender = gender;
    }

    private Date birthday;

    @Column(name = "birthday")
    @Basic
    Date getBirthday() {
        return birthday;
    }

    void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private Integer politicalLandscape;

    @Column(name = "political_landscape")
    @Basic
    Integer getPoliticalLandscape() {
        return politicalLandscape;
    }

    void setPoliticalLandscape(Integer politicalLandscape) {
        this.politicalLandscape = politicalLandscape;
    }

    private Date joinTime;

    @Column(name = "join_time")
    @Basic
    Date getJoinTime() {
        return joinTime;
    }

    void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    private Date workingTime;

    @Column(name = "working_time")
    @Basic
    Date getWorkingTime() {
        return workingTime;
    }

    void setWorkingTime(Date workingTime) {
        this.workingTime = workingTime;
    }

    private String originalEducation;

    @Column(name = "original_education")
    @Basic
    String getOriginalEducation() {
        return originalEducation;
    }

    void setOriginalEducation(String originalEducation) {
        this.originalEducation = originalEducation;
    }

    private Date originalEducationTime;

    @Column(name = "original_education_time")
    @Basic
    Date getOriginalEducationTime() {
        return originalEducationTime;
    }

    void setOriginalEducationTime(Date originalEducationTime) {
        this.originalEducationTime = originalEducationTime;
    }

    private String special;

    @Column(name = "special")
    @Basic
    String getSpecial() {
        return special;
    }

    void setSpecial(String special) {
        this.special = special;
    }

    private String newEducation;

    @Column(name = "new_education")
    @Basic
    String getNewEducation() {
        return newEducation;
    }

    void setNewEducation(String newEducation) {
        this.newEducation = newEducation;
    }

    private Date newEducationTime;

    @Column(name = "new_education_time")
    @Basic
    Date getNewEducationTime() {
        return newEducationTime;
    }

    void setNewEducationTime(Date newEducationTime) {
        this.newEducationTime = newEducationTime;
    }

    private Date certificatesTime;

    @Column(name = "certificates_time")
    @Basic
    Date getCertificatesTime() {
        return certificatesTime;
    }

    void setCertificatesTime(Date certificatesTime) {
        this.certificatesTime = certificatesTime;
    }

    private Integer establishment;

    @Column(name = "establishment")
    @Basic
    Integer getEstablishment() {
        return establishment;
    }

    void setEstablishment(Integer establishment) {
        this.establishment = establishment;
    }

    private Date createTime;

    @Column(name = "create_time")
    @Basic
    Date getCreateTime() {
        return createTime;
    }

    void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date updateTime;

    @Column(name = "update_time")
    @Basic
    Date getUpdateTime() {
        return updateTime;
    }

    void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaTeacherInfoEntity that = (OaTeacherInfoEntity) o;

        if (id != that.id) return false;
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
    Collection<OaCertificateEntity> getOaCertificatesById() {
        return oaCertificatesById;
    }

    void setOaCertificatesById(Collection<OaCertificateEntity> oaCertificatesById) {
        this.oaCertificatesById = oaCertificatesById;
    }

    private Collection<OaClassTeacherEntity> oaClassTeachersById;

    @OneToMany(mappedBy = "oaTeacherInfoByTeacherId")
    Collection<OaClassTeacherEntity> getOaClassTeachersById() {
        return oaClassTeachersById;
    }

    void setOaClassTeachersById(Collection<OaClassTeacherEntity> oaClassTeachersById) {
        this.oaClassTeachersById = oaClassTeachersById;
    }

    private OaSubjectEntity oaSubjectBySubjectId;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    OaSubjectEntity getOaSubjectBySubjectId() {
        return oaSubjectBySubjectId;
    }

    void setOaSubjectBySubjectId(OaSubjectEntity oaSubjectBySubjectId) {
        this.oaSubjectBySubjectId = oaSubjectBySubjectId;
    }

    private OaDepartmentEntity oaDepartmentByDepartmentId;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    OaDepartmentEntity getOaDepartmentByDepartmentId() {
        return oaDepartmentByDepartmentId;
    }

    void setOaDepartmentByDepartmentId(OaDepartmentEntity oaDepartmentByDepartmentId) {
        this.oaDepartmentByDepartmentId = oaDepartmentByDepartmentId;
    }

    private OaGradeEntity oaGradeByGradeId;

    @ManyToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    OaGradeEntity getOaGradeByGradeId() {
        return oaGradeByGradeId;
    }

    void setOaGradeByGradeId(OaGradeEntity oaGradeByGradeId) {
        this.oaGradeByGradeId = oaGradeByGradeId;
    }

    private OaPositionEntity oaPositionByPositionId;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    OaPositionEntity getOaPositionByPositionId() {
        return oaPositionByPositionId;
    }

    void setOaPositionByPositionId(OaPositionEntity oaPositionByPositionId) {
        this.oaPositionByPositionId = oaPositionByPositionId;
    }

    private Collection<SysUserEntity> sysUsersById;

    @OneToMany(mappedBy = "oaTeacherInfoByTeacherId")
    Collection<SysUserEntity> getSysUsersById() {
        return sysUsersById;
    }

    void setSysUsersById(Collection<SysUserEntity> sysUsersById) {
        this.sysUsersById = sysUsersById;
    }
}
