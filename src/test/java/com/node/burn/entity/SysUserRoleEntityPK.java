package com.node.burn.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
public class SysUserRoleEntityPK implements Serializable {
    private long userId;

    @Id
    @Column(name = "user_id")
    long getUserId() {
        return userId;
    }

    void setUserId(long userId) {
        this.userId = userId;
    }

    private long roleId;

    @Id
    @Column(name = "role_id")
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

        SysUserRoleEntityPK that = (SysUserRoleEntityPK) o;

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
}
