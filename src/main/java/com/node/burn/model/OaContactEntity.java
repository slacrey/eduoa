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
@javax.persistence.Table(name = "oa_contact", catalog = "eduoa")
@Entity
public class OaContactEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String nexus;

    @javax.persistence.Column(name = "nexus")
    @Basic
    String getNexus() {
        return nexus;
    }

    void setNexus(String nexus) {
        this.nexus = nexus;
    }

    private String contactName;

    @javax.persistence.Column(name = "contact_name")
    @Basic
    String getContactName() {
        return contactName;
    }

    void setContactName(String contactName) {
        this.contactName = contactName;
    }

    private String job;

    @javax.persistence.Column(name = "job")
    @Basic
    String getJob() {
        return job;
    }

    void setJob(String job) {
        this.job = job;
    }

    private String phone;

    @javax.persistence.Column(name = "phone")
    @Basic
    String getPhone() {
        return phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }

    private String qq;

    @javax.persistence.Column(name = "qq")
    @Basic
    String getQq() {
        return qq;
    }

    void setQq(String qq) {
        this.qq = qq;
    }

    private String email;

    @javax.persistence.Column(name = "email")
    @Basic
    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    private String address;

    @javax.persistence.Column(name = "address")
    @Basic
    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    private String homePhone;

    @javax.persistence.Column(name = "home_phone")
    @Basic
    String getHomePhone() {
        return homePhone;
    }

    void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    private String officePhone;

    @javax.persistence.Column(name = "office_phone")
    @Basic
    String getOfficePhone() {
        return officePhone;
    }

    void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    private Date createTime;

    @javax.persistence.Column(name = "create_time")
    @Basic
    Date getCreateTime() {
        return createTime;
    }

    void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date updateTime;

    @javax.persistence.Column(name = "update_time")
    @Basic
    Date getUpdateTime() {
        return updateTime;
    }

    void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
    @javax.persistence.JoinColumn(name = "student_id", referencedColumnName = "id")
    OaStudentEntity getOaStudentByStudentId() {
        return oaStudentByStudentId;
    }

    void setOaStudentByStudentId(OaStudentEntity oaStudentByStudentId) {
        this.oaStudentByStudentId = oaStudentByStudentId;
    }
}
