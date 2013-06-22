package com.node.burn.dao.hibernate;

import com.node.burn.model.SysMenuItemEntity;
import com.node.burn.dao.MenuItemDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuItemDao")
public class MenuItemDaoHibernate extends GenericDaoHibernate<SysMenuItemEntity, Long> implements MenuItemDao {

    public MenuItemDaoHibernate() {
        super(SysMenuItemEntity.class);
    }


    @Override
    public List<SysMenuItemEntity> findTopMenuItems() {
        Session session = getSession();
        Query query = session.createQuery("SELECT u FROM SysMenuItemEntity u WHERE (u.parentMenuItem is null OR u.parentMenuItem = '') ORDER BY u.menuOrder desc");
        return query.list();
    }
}
