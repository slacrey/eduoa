package com.node.burn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_student_class", schema = "", catalog = "eduoa")
@Entity
public class OaStudentClassEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaStudentClassEntity that = (OaStudentClassEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
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
