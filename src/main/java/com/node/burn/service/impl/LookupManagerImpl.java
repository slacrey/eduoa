package com.node.burn.service.impl;

import com.node.burn.dao.LookupDao;
import com.node.burn.model.LabelValue;
import com.node.burn.model.SysRoleEntity;
import com.node.burn.service.LookupManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of LookupManager interface to talk to the persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("lookupManager")
public class LookupManagerImpl implements LookupManager {
    @Autowired
    LookupDao dao;

    /**
     * {@inheritDoc}
     */
    public List<LabelValue> getAllRoles() {
        List<SysRoleEntity> roles = dao.getRoles();
        List<LabelValue> list = new ArrayList<LabelValue>();

        for (SysRoleEntity role1 : roles) {
            list.add(new LabelValue(role1.getName(), role1.getName()));
        }

        return list;
    }
}
