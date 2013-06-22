package com.node.burn.dao.hibernate;

import com.node.burn.dao.RoleDao;
import com.node.burn.model.SysRoleEntity;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve SysRoleEntity objects.
 *
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * @author jgarcia (updated to hibernate 4)
 */
@Repository
public class RoleDaoHibernate extends GenericDaoHibernate<SysRoleEntity, Long> implements RoleDao {

    /**
     * Constructor to create a Generics-based version using SysRoleEntity as the entity
     */
    public RoleDaoHibernate() {
        super(SysRoleEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    public SysRoleEntity getRoleByName(String rolename) {
        List roles = getSession().createCriteria(SysRoleEntity.class).add(Restrictions.eq("name", rolename)).list();
        if (roles.isEmpty()) {
            return null;
        } else {
            return (SysRoleEntity) roles.get(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void removeRole(String rolename) {
        Object role = getRoleByName(rolename);
        Session session = getSessionFactory().getCurrentSession();
        session.delete(role);
    }
}
