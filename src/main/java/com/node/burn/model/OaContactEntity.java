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
@Table(name = "oa_contact")
@Entity
public class OaContactEntity extends BaseObject implements Serializable {
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

    private String nexus;

    @Column(name = "nexus")
    @Basic
    public String getNexus() {
        return nexus;
    }

    public void setNexus(String nexus) {
        this.nexus = nexus;
    }

    private String contactName;

    @Column(name = "contact_name")
    @Basic
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    private String job;

    @Column(name = "job")
    @Basic
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private String phone;

    @Column(name = "phone")
    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String qq;

    @Column(name = "qq")
    @Basic
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    private String email;

    @Column(name = "email")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String address;

    @Column(name = "address")
    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String homePhone;

    @Column(name = "home_phone")
    @Basic
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    private String officePhone;

    @Column(name = "office_phone")
    @Basic
    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    private Date createTime;

    @Column(name = "create_time")
    @Basic
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date updateTime;

    @Column(name = "update_time")
    @Basic
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.contactName)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaContactEntity that = (OaContactEntity) o;

        if (id != that.id) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        if (job != null ? !job.equals(that.job) : that.job != null) return false;
        if (nexus != null ? !nexus.equals(that.nexus) : that.nexus != null) return false;
        if (officePhone != null ? !officePhone.equals(that.officePhone) : that.officePhone != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (qq != null ? !qq.equals(that.qq) : that.qq != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nexus != null ? nexus.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (officePhone != null ? officePhone.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    private OaStudentEntity oaStudentByStudentId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public OaStudentEntity getOaStudentByStudentId() {
        return oaStudentByStudentId;
    }

    public void setOaStudentByStudentId(OaStudentEntity oaStudentByStudentId) {
        this.oaStudentByStudentId = oaStudentByStudentId;
    }
}
