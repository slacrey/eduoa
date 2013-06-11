package com.node.burn.model;

import com.node.burn.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="sys_user",catalog="eduoa", uniqueConstraints = {@UniqueConstraint(columnNames="email"), @UniqueConstraint(columnNames="username")} )
@Indexed
@XmlRootElement
public class SysUser extends BaseObject implements Serializable {
    private Long id;
    private Long version;
    private boolean accountExpired;
    private boolean accountLocked;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String province;
    private boolean credentialsExpired;
    private String email;
    private Boolean accountEnabled;
    private String firstName;
    private String lastName;
    private String password;
    private String passwordHint;
    private String phoneNumber;
    private String realName;
    private String username;
    private String website;
    private Set<SysRole> sysRoles = new HashSet<SysRole>(0);

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    @Version
    @Column(name="version")
    @Field
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    @Column(name="account_expired", nullable=false)
    @Field
    public boolean isAccountExpired() {
        return this.accountExpired;
    }
    
    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }
    
    @Column(name="account_locked", nullable=false)
    @Field
    public boolean isAccountLocked() {
        return this.accountLocked;
    }
    
    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }
    
    @Column(name="address", length=150)
    @Field
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="city", length=50)
    @Field
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Column(name="country", length=100)
    @Field
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    @Column(name="postal_code", length=15)
    @Field
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    @Column(name="province", length=100)
    @Field
    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    @Column(name="credentials_expired", nullable=false)
    @Field
    public boolean isCredentialsExpired() {
        return this.credentialsExpired;
    }
    
    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }
    
    @Column(name="email", unique=true, nullable=false)
    @Field
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="account_enabled")
    @Field
    public Boolean getAccountEnabled() {
        return this.accountEnabled;
    }
    
    public void setAccountEnabled(Boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }
    
    @Column(name="first_name", nullable=false, length=50)
    @Field
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="last_name", nullable=false, length=50)
    @Field
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name="password", nullable=false)
    @Field
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="password_hint")
    @Field
    public String getPasswordHint() {
        return this.passwordHint;
    }
    
    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }
    
    @Column(name="phone_number")
    @Field
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Column(name="real_name", nullable=false, length=50)
    @Field
    public String getRealName() {
        return this.realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    @Column(name="username", unique=true, nullable=false, length=50)
    @Field
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="website")
    @Field
    public String getWebsite() {
        return this.website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="sys_user_role", catalog="eduoa", joinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="role_id", nullable=false, updatable=false) })
    public Set<SysRole> getSysRoles() {
        return this.sysRoles;
    }
    
    public void setSysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUser pojo = (SysUser) o;

        if (version != null ? !version.equals(pojo.version) : pojo.version != null) return false;
        if (accountExpired != pojo.accountExpired) return false;
        if (accountLocked != pojo.accountLocked) return false;
        if (address != null ? !address.equals(pojo.address) : pojo.address != null) return false;
        if (city != null ? !city.equals(pojo.city) : pojo.city != null) return false;
        if (country != null ? !country.equals(pojo.country) : pojo.country != null) return false;
        if (postalCode != null ? !postalCode.equals(pojo.postalCode) : pojo.postalCode != null) return false;
        if (province != null ? !province.equals(pojo.province) : pojo.province != null) return false;
        if (credentialsExpired != pojo.credentialsExpired) return false;
        if (email != null ? !email.equals(pojo.email) : pojo.email != null) return false;
        if (accountEnabled != null ? !accountEnabled.equals(pojo.accountEnabled) : pojo.accountEnabled != null) return false;
        if (firstName != null ? !firstName.equals(pojo.firstName) : pojo.firstName != null) return false;
        if (lastName != null ? !lastName.equals(pojo.lastName) : pojo.lastName != null) return false;
        if (password != null ? !password.equals(pojo.password) : pojo.password != null) return false;
        if (passwordHint != null ? !passwordHint.equals(pojo.passwordHint) : pojo.passwordHint != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(pojo.phoneNumber) : pojo.phoneNumber != null) return false;
        if (realName != null ? !realName.equals(pojo.realName) : pojo.realName != null) return false;
        if (username != null ? !username.equals(pojo.username) : pojo.username != null) return false;
        if (website != null ? !website.equals(pojo.website) : pojo.website != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (version != null ? version.hashCode() : 0);
        result = 31 * result + (accountExpired ? 1 : 0);
        result = 31 * result + (accountLocked ? 1 : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (credentialsExpired ? 1 : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (accountEnabled != null ? accountEnabled.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (passwordHint != null ? passwordHint.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("version").append("='").append(getVersion()).append("', ");
        sb.append("accountExpired").append("='").append(isAccountExpired()).append("', ");
        sb.append("accountLocked").append("='").append(isAccountLocked()).append("', ");
        sb.append("address").append("='").append(getAddress()).append("', ");
        sb.append("city").append("='").append(getCity()).append("', ");
        sb.append("country").append("='").append(getCountry()).append("', ");
        sb.append("postalCode").append("='").append(getPostalCode()).append("', ");
        sb.append("province").append("='").append(getProvince()).append("', ");
        sb.append("credentialsExpired").append("='").append(isCredentialsExpired()).append("', ");
        sb.append("email").append("='").append(getEmail()).append("', ");
        sb.append("accountEnabled").append("='").append(getAccountEnabled()).append("', ");
        sb.append("firstName").append("='").append(getFirstName()).append("', ");
        sb.append("lastName").append("='").append(getLastName()).append("', ");
        sb.append("password").append("='").append(getPassword()).append("', ");
        sb.append("passwordHint").append("='").append(getPasswordHint()).append("', ");
        sb.append("phoneNumber").append("='").append(getPhoneNumber()).append("', ");
        sb.append("realName").append("='").append(getRealName()).append("', ");
        sb.append("username").append("='").append(getUsername()).append("', ");
        sb.append("website").append("='").append(getWebsite()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
