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
@Table(name = "oa_certificate")
@Entity
public class OaCertificateEntity extends BaseObject implements Serializable {
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

    private Integer advanced;

    @Column(name = "advanced")
    @Basic
    public Integer getAdvanced() {
        return advanced;
    }

    public void setAdvanced(Integer advanced) {
        this.advanced = advanced;
    }

    private Date certificatesTime;

    @Column(name = "certificates_time")
    @Basic
    public Date getCertificatesTime() {
        return certificatesTime;
    }

    public void setCertificatesTime(Date certificatesTime) {
        this.certificatesTime = certificatesTime;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.description)
                .toString();
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
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    public OaCertificateTypeEntity getOaCertificateTypeByTypeId() {
        return oaCertificateTypeByTypeId;
    }

    public void setOaCertificateTypeByTypeId(OaCertificateTypeEntity oaCertificateTypeByTypeId) {
        this.oaCertificateTypeByTypeId = oaCertificateTypeByTypeId;
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
