package com.node.burn.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@IdClass(OaStudentClassEntityPK.class)
@Table(name = "oa_student_class")
@Entity
public class OaStudentClassEntity extends BaseObject implements Serializable {
    private Long studentId;

    @Column(name = "student_id")
    @Id
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    private long classId;

    @Column(name = "class_id")
    @Id
    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.classId)
                .toString();
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
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    public OaClassEntity getOaClassByClassId() {
        return oaClassByClassId;
    }

    public void setOaClassByClassId(OaClassEntity oaClassByClassId) {
        this.oaClassByClassId = oaClassByClassId;
    }

    private OaStudentEntity oaStudentByStudentId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public OaStudentEntity getOaStudentByStudentId() {
        return oaStudentByStudentId;
    }

    public void setOaStudentByStudentId(OaStudentEntity oaStudentByStudentId) {
        this.oaStudentByStudentId = oaStudentByStudentId;
    }
}
