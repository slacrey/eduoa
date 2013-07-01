package com.node.burn.dao.hibernate;

import com.node.burn.dao.OaDepartmentEntityDao;
import com.node.burn.model.OaDepartmentEntity;
import com.node.burn.model.SysRoleEntity;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-29
 * Time: 下午2:01
 * To change this template use File | Settings | File Templates.
 */
@Repository("oaDepartmentEntityDao")
public class OaDepartmentEntityDaoHibernate extends GenericDaoHibernate<OaDepartmentEntity, Long> implements OaDepartmentEntityDao {

    public OaDepartmentEntityDaoHibernate() {
        super(OaDepartmentEntity.class);
    }


    @Override
    public List<OaDepartmentEntity> searchByParentId(Long parentId) {
        Query query = getSession().createQuery("from OaDepartmentEntity d where d.oaDepartmentByParentId.id=:parentId " +
                "order by d.departOrder asc ");
        query.setParameter("parentId", parentId);
        List roles = query.list();
        if (roles.isEmpty()) {
            return null;
        } else {
            return roles;
        }
    }

    @Override
    public List<OaDepartmentEntity> searchTop() {
        Query query = getSession().createQuery("from OaDepartmentEntity d where d.oaDepartmentByParentId is null " +
                "order by d.departOrder asc ");
        List roles = query.list();
        if (roles.isEmpty()) {
            return null;
        } else {
            return roles;
        }
    }
}
