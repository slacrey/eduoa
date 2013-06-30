package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_certificate_type", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaCertificateTypeEntity extends BaseObject implements Serializable {
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

    private String typeName;

    @javax.persistence.Column(name = "type_name")
    @Basic
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private String description;

    @javax.persistence.Column(name = "description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Integer typeLevel;

    @javax.persistence.Column(name = "type_level")
    @Basic
    public Integer getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(Integer typeLevel) {
        this.typeLevel = typeLevel;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaCertificateTypeEntity that = (OaCertificateTypeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (typeLevel != null ? !typeLevel.equals(that.typeLevel) : that.typeLevel != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (typeLevel != null ? typeLevel.hashCode() : 0);
        return result;
    }

    private Collection<OaCertificateEntity> oaCertificatesById;

    @OneToMany(mappedBy = "oaCertificateTypeByTypeId")
    public Collection<OaCertificateEntity> getOaCertificatesById() {
        return oaCertificatesById;
    }

    public void setOaCertificatesById(Collection<OaCertificateEntity> oaCertificatesById) {
        this.oaCertificatesById = oaCertificatesById;
    }
}
