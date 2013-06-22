package com.node.burn.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_class_teacher", catalog = "eduoa")
@Entity
public class OaClassTeacherEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private Date startTime;

    @javax.persistence.Column(name = "start_time")
    @Basic
    Date getStartTime() {
        return startTime;
    }

    void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    private Date endTime;

    @javax.persistence.Column(name = "end_time")
    @Basic
    Date getEndTime() {
        return endTime;
    }

    void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    private Integer headTeacher;

    @javax.persistence.Column(name = "head_teacher")
    @Basic
    Integer getHeadTeacher() {
        return headTeacher;
    }

    void setHeadTeacher(Integer headTeacher) {
        this.headTeacher = headTeacher;
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
    @javax.persistence.JoinColumn(name = "class_id", referencedColumnName = "id")
    OaClassEntity getOaClassByClassId() {
        return oaClassByClassId;
    }

    void setOaClassByClassId(OaClassEntity oaClassByClassId) {
        this.oaClassByClassId = oaClassByClassId;
    }

    private OaTeacherInfoEntity oaTeacherInfoByTeacherId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "teacher_id", referencedColumnName = "id")
    OaTeacherInfoEntity getOaTeacherInfoByTeacherId() {
        return oaTeacherInfoByTeacherId;
    }

    void setOaTeacherInfoByTeacherId(OaTeacherInfoEntity oaTeacherInfoByTeacherId) {
        this.oaTeacherInfoByTeacherId = oaTeacherInfoByTeacherId;
    }
}
