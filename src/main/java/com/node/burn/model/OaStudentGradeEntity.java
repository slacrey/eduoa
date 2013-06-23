package com.node.burn.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(OaStudentGradeEntityPK.class)
@javax.persistence.Table(name = "oa_student_grade")
@Entity
public class OaStudentGradeEntity extends BaseObject implements Serializable {
    private Long gradeId;

    @javax.persistence.Column(name = "grade_id")
    @Id
    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    private long studentId;

    @javax.persistence.Column(name = "student_id")
    @Id
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaStudentGradeEntity that = (OaStudentGradeEntity) o;

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

    private OaGradeEntity oaGradeByGradeId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "grade_id", referencedColumnName = "id", nullable = false)
    public OaGradeEntity getOaGradeByGradeId() {
        return oaGradeByGradeId;
    }

    public void setOaGradeByGradeId(OaGradeEntity oaGradeByGradeId) {
        this.oaGradeByGradeId = oaGradeByGradeId;
    }

    private OaStudentEntity oaStudentByStudentId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public OaStudentEntity getOaStudentByStudentId() {
        return oaStudentByStudentId;
    }

    public void setOaStudentByStudentId(OaStudentEntity oaStudentByStudentId) {
        this.oaStudentByStudentId = oaStudentByStudentId;
    }
}
