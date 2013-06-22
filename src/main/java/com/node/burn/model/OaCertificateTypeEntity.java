package com.node.burn.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_certificate_type", catalog = "eduoa")
@Entity
public class OaCertificateTypeEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String typeName;

    @javax.persistence.Column(name = "type_name")
    @Basic
    String getTypeName() {
        return typeName;
    }

    void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private String description;

    @javax.persistence.Column(name = "description")
    @Basic
    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    private Integer typeLevel;

    @javax.persistence.Column(name = "type_level")
    @Basic
    Integer getTypeLevel() {
        return typeLevel;
    }

    void setTypeLevel(Integer typeLevel) {
        this.typeLevel = typeLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaCertificateTypeEntity that = (OaCertificateTypeEntity) o;

        if (id != that.id) return false;
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
    Collection<OaCertificateEntity> getOaCertificatesById() {
        return oaCertificatesById;
    }

    void setOaCertificatesById(Collection<OaCertificateEntity> oaCertificatesById) {
        this.oaCertificatesById = oaCertificatesById;
    }
}
