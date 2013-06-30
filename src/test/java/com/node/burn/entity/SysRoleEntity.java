package com.node.burn.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "sys_role", schema = "", catalog = "eduoa")
@Entity
public class SysRoleEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String name;

    @javax.persistence.Column(name = "name")
    @Basic
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
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

        SysRoleEntity that = (SysRoleEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private Collection<SysUserRoleEntity> sysUserRolesById;

    @OneToMany(mappedBy = "sysRoleByRoleId")
    Collection<SysUserRoleEntity> getSysUserRolesById() {
        return sysUserRolesById;
    }

    void setSysUserRolesById(Collection<SysUserRoleEntity> sysUserRolesById) {
        this.sysUserRolesById = sysUserRolesById;
    }
}
