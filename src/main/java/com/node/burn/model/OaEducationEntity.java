package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_education", catalog = "eduoa")
@Entity
@XmlRootElement
public class OaEducationEntity extends BaseObject implements Serializable {
    private Long id;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String eduName;

    @Column(name = "edu_name")
    @Basic
    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    private String description;

    @Column(name = "description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Integer eduOrder;

    @Column(name = "edu_order")
    @Basic
    public Integer getEduOrder() {
        return eduOrder;
    }

    public void setEduOrder(Integer eduOrder) {
        this.eduOrder = eduOrder;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaEducationEntity that = (OaEducationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (eduName != null ? !eduName.equals(that.eduName) : that.eduName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (eduName != null ? eduName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private Collection<OaDepartmentEntity> oaDepartmentsById;

    @OneToMany(mappedBy = "oaEducationByEducationId")
    public Collection<OaDepartmentEntity> getOaDepartmentsById() {
        return oaDepartmentsById;
    }

    public void setOaDepartmentsById(Collection<OaDepartmentEntity> oaDepartmentsById) {
        this.oaDepartmentsById = oaDepartmentsById;
    }

    private OaEducationEntity oaEducationByParentId;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public OaEducationEntity getOaEducationByParentId() {
        return oaEducationByParentId;
    }

    public void setOaEducationByParentId(OaEducationEntity oaEducationByParentId) {
        this.oaEducationByParentId = oaEducationByParentId;
    }

    private Collection<OaEducationEntity> oaEducationsById;

    @OneToMany(mappedBy = "oaEducationByParentId")
    public Collection<OaEducationEntity> getOaEducationsById() {
        return oaEducationsById;
    }

    public void setOaEducationsById(Collection<OaEducationEntity> oaEducationsById) {
        this.oaEducationsById = oaEducationsById;
    }
}
