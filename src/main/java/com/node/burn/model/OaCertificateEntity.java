package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_certificate", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaCertificateEntity extends BaseObject implements Serializable {
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

    private Integer advanced;

    @javax.persistence.Column(name = "advanced")
    @Basic
    public Integer getAdvanced() {
        return advanced;
    }

    public void setAdvanced(Integer advanced) {
        this.advanced = advanced;
    }

    private Date certificatesTime;

    @javax.persistence.Column(name = "certificates_time")
    @Basic
    public Date getCertificatesTime() {
        return certificatesTime;
    }

    public void setCertificatesTime(Date certificatesTime) {
        this.certificatesTime = certificatesTime;
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

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaCertificateEntity that = (OaCertificateEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (advanced != null ? !advanced.equals(that.advanced) : that.advanced != null) return false;
        if (certificatesTime != null ? !certificatesTime.equals(that.certificatesTime) : that.certificatesTime != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (advanced != null ? advanced.hashCode() : 0);
        result = 31 * result + (certificatesTime != null ? certificatesTime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private OaCertificateTypeEntity oaCertificateTypeByTypeId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "type_id", referencedColumnName = "id")
    public OaCertificateTypeEntity getOaCertificateTypeByTypeId() {
        return oaCertificateTypeByTypeId;
    }

    public void setOaCertificateTypeByTypeId(OaCertificateTypeEntity oaCertificateTypeByTypeId) {
        this.oaCertificateTypeByTypeId = oaCertificateTypeByTypeId;
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
