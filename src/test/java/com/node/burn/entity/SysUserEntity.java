package com.node.burn.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "sys_user", schema = "", catalog = "eduoa")
@Entity
public class SysUserEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String username;

    @javax.persistence.Column(name = "username")
    @Basic
    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    private String password;

    @javax.persistence.Column(name = "password")
    @Basic
    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    private String passwordHint;

    @javax.persistence.Column(name = "password_hint")
    @Basic
    String getPasswordHint() {
        return passwordHint;
    }

    void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    private String realName;

    @javax.persistence.Column(name = "real_name")
    @Basic
    String getRealName() {
        return realName;
    }

    void setRealName(String realName) {
        this.realName = realName;
    }

    private String firstName;

    @javax.persistence.Column(name = "first_name")
    @Basic
    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    @javax.persistence.Column(name = "last_name")
    @Basic
    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
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

    private String phoneNumber;

    @javax.persistence.Column(name = "phone_number")
    @Basic
    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String website;

    @javax.persistence.Column(name = "website")
    @Basic
    String getWebsite() {
        return website;
    }

    void setWebsite(String website) {
        this.website = website;
    }

    private Integer version;

    @javax.persistence.Column(name = "version")
    @Basic
    Integer getVersion() {
        return version;
    }

    void setVersion(Integer version) {
        this.version = version;
    }

    private Boolean accountEnabled;

    @javax.persistence.Column(name = "account_enabled")
    @Basic
    Boolean getAccountEnabled() {
        return accountEnabled;
    }

    void setAccountEnabled(Boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    private Boolean accountExpired;

    @javax.persistence.Column(name = "account_expired")
    @Basic
    Boolean getAccountExpired() {
        return accountExpired;
    }

    void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    private Boolean accountLocked;

    @javax.persistence.Column(name = "account_locked")
    @Basic
    Boolean getAccountLocked() {
        return accountLocked;
    }

    void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    private Boolean credentialsExpired;

    @javax.persistence.Column(name = "credentials_expired")
    @Basic
    Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserEntity that = (SysUserEntity) o;

        if (id != that.id) return false;
        if (accountEnabled != null ? !accountEnabled.equals(that.accountEnabled) : that.accountEnabled != null)
            return false;
        if (accountExpired != null ? !accountExpired.equals(that.accountExpired) : that.accountExpired != null)
            return false;
        if (accountLocked != null ? !accountLocked.equals(that.accountLocked) : that.accountLocked != null)
            return false;
        if (credentialsExpired != null ? !credentialsExpired.equals(that.credentialsExpired) : that.credentialsExpired != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (passwordHint != null ? !passwordHint.equals(that.passwordHint) : that.passwordHint != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (passwordHint != null ? passwordHint.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (accountEnabled != null ? accountEnabled.hashCode() : 0);
        result = 31 * result + (accountExpired != null ? accountExpired.hashCode() : 0);
        result = 31 * result + (accountLocked != null ? accountLocked.hashCode() : 0);
        result = 31 * result + (credentialsExpired != null ? credentialsExpired.hashCode() : 0);
        return result;
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

    private Collection<SysUserRoleEntity> sysUserRolesById;

    @OneToMany(mappedBy = "sysUserByUserId")
    Collection<SysUserRoleEntity> getSysUserRolesById() {
        return sysUserRolesById;
    }

    void setSysUserRolesById(Collection<SysUserRoleEntity> sysUserRolesById) {
        this.sysUserRolesById = sysUserRolesById;
    }
}
