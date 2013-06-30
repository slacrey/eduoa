package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_student_class", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaStudentClassEntity extends BaseObject implements Serializable {
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

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaStudentClassEntity that = (OaStudentClassEntity) o;

        if (id != null ? !id.equals(that.id):that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    private OaClassEntity oaClassByClassId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    public OaClassEntity getOaClassByClassId() {
        return oaClassByClassId;
    }

    public void setOaClassByClassId(OaClassEntity oaClassByClassId) {
        this.oaClassByClassId = oaClassByClassId;
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
