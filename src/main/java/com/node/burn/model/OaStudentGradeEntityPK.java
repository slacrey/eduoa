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
public class OaStudentGradeEntityPK implements Serializable {
    private long gradeId;

    @Id
    @Column(name = "grade_id")
    long getGradeId() {
        return gradeId;
    }

    void setGradeId(long gradeId) {
        this.gradeId = gradeId;
    }

    private long studentId;

    @Id
    @Column(name = "student_id")
    long getStudentId() {
        return studentId;
    }

    void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaStudentGradeEntityPK that = (OaStudentGradeEntityPK) o;

        if (gradeId != that.gradeId) return false;
        if (studentId != that.studentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (gradeId ^ (gradeId >>> 32));
        result = 31 * result + (int) (studentId ^ (studentId >>> 32));
        return result;
    }
}
