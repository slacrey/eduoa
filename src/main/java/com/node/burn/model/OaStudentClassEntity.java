package com.node.burn.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(OaStudentClassEntityPK.class)
@javax.persistence.Table(name = "oa_student_class", catalog = "eduoa")
@Entity
public class OaStudentClassEntity {
    private long studentId;

    @javax.persistence.Column(name = "student_id")
    @Id
    long getStudentId() {
        return studentId;
    }

    void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    private long classId;

    @javax.persistence.Column(name = "class_id")
    @Id
    long getClassId() {
        return classId;
    }

    void setClassId(long classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaStudentClassEntity that = (OaStudentClassEntity) o;

        if (classId != that.classId) return false;
        if (studentId != that.studentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (studentId ^ (studentId >>> 32));
        result = 31 * result + (int) (classId ^ (classId >>> 32));
        return result;
    }

    private OaClassEntity oaClassByClassId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    OaClassEntity getOaClassByClassId() {
        return oaClassByClassId;
    }

    void setOaClassByClassId(OaClassEntity oaClassByClassId) {
        this.oaClassByClassId = oaClassByClassId;
    }

    private OaStudentEntity oaStudentByStudentId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    OaStudentEntity getOaStudentByStudentId() {
        return oaStudentByStudentId;
    }

    void setOaStudentByStudentId(OaStudentEntity oaStudentByStudentId) {
        this.oaStudentByStudentId = oaStudentByStudentId;
    }
}
