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

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="sys_role",catalog="eduoa")
@Indexed
@XmlRootElement
public class SysRole extends BaseObject implements Serializable {
    private Long id;
    private String code;
    private String description;
    private String name;
    private Set<SysUser> sysUsers = new HashSet<SysUser>(0);

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="code", length=20)
    @Field
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    @Column(name="description", length=64)
    @Field
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="name", length=20)
    @Field
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="sys_user_role", catalog="eduoa", joinColumns = { 
        @JoinColumn(name="role_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) })
    public Set<SysUser> getSysUsers() {
        return this.sysUsers;
    }
    
    public void setSysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRole pojo = (SysRole) o;

        if (code != null ? !code.equals(pojo.code) : pojo.code != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (name != null ? !name.equals(pojo.name) : pojo.name != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (code != null ? code.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("code").append("='").append(getCode()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("name").append("='").append(getName()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
