package com.node.burn.dao.hibernate;

import com.node.burn.model.MenuItem;
import com.node.burn.dao.MenuItemDao;
import com.node.burn.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuItemDao")
public class MenuItemDaoHibernate extends GenericDaoHibernate<MenuItem, Long> implements MenuItemDao {

    public MenuItemDaoHibernate() {
        super(MenuItem.class);
    }


    @Override
    public List<MenuItem> findTopMenuItems() {
        Session session = getSession();
        Query query = session.createQuery("SELECT u FROM MenuItem u WHERE (u.parentMenuItem is null OR u.parentMenuItem = '') ORDER BY u.order desc");
        return query.list();
    }
}
