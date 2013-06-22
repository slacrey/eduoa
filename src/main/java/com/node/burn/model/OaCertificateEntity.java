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
@javax.persistence.Table(name = "oa_certificate", catalog = "eduoa")
@Entity
public class OaCertificateEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private Integer advanced;

    @javax.persistence.Column(name = "advanced")
    @Basic
    Integer getAdvanced() {
        return advanced;
    }

    void setAdvanced(Integer advanced) {
        this.advanced = advanced;
    }

    private Date certificatesTime;

    @javax.persistence.Column(name = "certificates_time")
    @Basic
    Date getCertificatesTime() {
        return certificatesTime;
    }

    void setCertificatesTime(Date certificatesTime) {
        this.certificatesTime = certificatesTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaCertificateEntity that = (OaCertificateEntity) o;

        if (id != that.id) return false;
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
    OaCertificateTypeEntity getOaCertificateTypeByTypeId() {
        return oaCertificateTypeByTypeId;
    }

    void setOaCertificateTypeByTypeId(OaCertificateTypeEntity oaCertificateTypeByTypeId) {
        this.oaCertificateTypeByTypeId = oaCertificateTypeByTypeId;
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
