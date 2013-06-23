package com.node.burn.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_class_teacher")
@Entity
public class OaClassTeacherEntity extends BaseObject implements Serializable {
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

    private Date startTime;

    @Column(name = "start_time")
    @Basic
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    private Date endTime;

    @Column(name = "end_time")
    @Basic
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.getId())
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaClassTeacherEntity that = (OaClassTeacherEntity) o;

        if (id != that.id) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (headTeacher != null ? !headTeacher.equals(that.headTeacher) : that.headTeacher != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (headTeacher != null ? headTeacher.hashCode() : 0);
        return result;
    }

    private OaClassEntity oaClassByClassId;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    public OaClassEntity getOaClassByClassId() {
        return oaClassByClassId;
    }

    public void setOaClassByClassId(OaClassEntity oaClassByClassId) {
        this.oaClassByClassId = oaClassByClassId;
    }

    private OaTeacherInfoEntity oaTeacherInfoByTeacherId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    public OaTeacherInfoEntity getOaTeacherInfoByTeacherId() {
        return oaTeacherInfoByTeacherId;
    }

    public void setOaTeacherInfoByTeacherId(OaTeacherInfoEntity oaTeacherInfoByTeacherId) {
        this.oaTeacherInfoByTeacherId = oaTeacherInfoByTeacherId;
    }
}
