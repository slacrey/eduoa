package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_class_teacher", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaClassTeacherEntity extends BaseObject implements Serializable {
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

    private Date startTime;

    @javax.persistence.Column(name = "start_time")
    @Basic
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    private Date endTime;

    @javax.persistence.Column(name = "end_time")
    @Basic
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    private Integer headTeacher;

    @javax.persistence.Column(name = "head_teacher")
    @Basic
    public Integer getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(Integer headTeacher) {
        this.headTeacher = headTeacher;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaClassTeacherEntity that = (OaClassTeacherEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
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
    public OaClassEntity getOaClassByClassId() {
        return oaClassByClassId;
    }

    public void setOaClassByClassId(OaClassEntity oaClassByClassId) {
        this.oaClassByClassId = oaClassByClassId;
    }

    private OaTeacherInfoEntity oaTeacherInfoByTeacherId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "teacher_id", referencedColumnName = "id")
    public OaTeacherInfoEntity getOaTeacherInfoByTeacherId() {
        return oaTeacherInfoByTeacherId;
    }

    public void setOaTeacherInfoByTeacherId(OaTeacherInfoEntity oaTeacherInfoByTeacherId) {
        this.oaTeacherInfoByTeacherId = oaTeacherInfoByTeacherId;
    }
}
