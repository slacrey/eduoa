package com.node.burn.service;

import com.node.burn.model.SysRoleEntity;

import java.util.List;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface RoleManager extends GenericManager<SysRoleEntity, Long> {
    /**
     * {@inheritDoc}
     */
    List getRoles(SysRoleEntity role);

    /**
     * {@inheritDoc}
     */
    SysRoleEntity getRole(String rolename);

    /**
     * {@inheritDoc}
     */
    SysRoleEntity saveRole(SysRoleEntity role);

    /**
     * {@inheritDoc}
     */
    void removeRole(String rolename);
}
