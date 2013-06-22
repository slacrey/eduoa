package com.node.burn.service.impl;

import com.node.burn.dao.RoleDao;
import com.node.burn.model.SysRoleEntity;
import com.node.burn.service.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of RoleManager interface.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
@Service("roleManager")
public class RoleManagerImpl extends GenericManagerImpl<SysRoleEntity, Long> implements RoleManager {
    RoleDao roleDao;

    @Autowired
    public RoleManagerImpl(RoleDao roleDao) {
        super(roleDao);
        this.roleDao = roleDao;
    }

    /**
     * {@inheritDoc}
     */
    public List<SysRoleEntity> getRoles(SysRoleEntity role) {
        return dao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    public SysRoleEntity getRole(String rolename) {
        return roleDao.getRoleByName(rolename);
    }

    /**
     * {@inheritDoc}
     */
    public SysRoleEntity saveRole(SysRoleEntity role) {
        return dao.save(role);
    }

    /**
     * {@inheritDoc}
     */
    public void removeRole(String rolename) {
        roleDao.removeRole(rolename);
    }
}