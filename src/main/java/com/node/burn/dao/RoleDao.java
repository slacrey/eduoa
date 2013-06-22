package com.node.burn.dao;

import com.node.burn.model.SysRoleEntity;

/**
 * SysRoleEntity Data Access Object (DAO) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface RoleDao extends GenericDao<SysRoleEntity, Long> {
    /**
     * Gets role information based on rolename
     * @param rolename the rolename
     * @return populated role object
     */
    SysRoleEntity getRoleByName(String rolename);

    /**
     * Removes a role from the database by name
     * @param rolename the role's rolename
     */
    void removeRole(String rolename);
}
