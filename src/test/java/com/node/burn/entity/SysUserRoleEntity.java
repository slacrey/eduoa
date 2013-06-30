package com.node.burn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(com.node.burn.entity.SysUserRoleEntityPK.class)
@javax.persistence.Table(name = "sys_user_role", schema = "", catalog = "eduoa")
@Entity
public class SysUserRoleEntity {
    private long userId;

    @javax.persistence.Column(name = "user_id")
    @Id
    long getUserId() {
        return userId;
    }

    void setUserId(long userId) {
        this.userId = userId;
    }

    private long roleId;

    @javax.persistence.Column(name = "role_id")
    @Id
    long getRoleId() {
        return roleId;
    }

    void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserRoleEntity that = (SysUserRoleEntity) o;

        if (roleId != that.roleId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        return result;
    }

    private SysRoleEntity sysRoleByRoleId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    SysRoleEntity getSysRoleByRoleId() {
        return sysRoleByRoleId;
    }

    void setSysRoleByRoleId(SysRoleEntity sysRoleByRoleId) {
        this.sysRoleByRoleId = sysRoleByRoleId;
    }

    private SysUserEntity sysUserByUserId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    SysUserEntity getSysUserByUserId() {
        return sysUserByUserId;
    }

    void setSysUserByUserId(SysUserEntity sysUserByUserId) {
        this.sysUserByUserId = sysUserByUserId;
    }
}
