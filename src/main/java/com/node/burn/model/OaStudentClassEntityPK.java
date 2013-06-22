package com.node.burn.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
public class OaStudentClassEntityPK implements Serializable {
    private long studentId;

    @Id
    @Column(name = "student_id")
    long getStudentId() {
        return studentId;
    }

    void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    private long classId;

    @Id
    @Column(name = "class_id")
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

        OaStudentClassEntityPK that = (OaStudentClassEntityPK) o;

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
}
