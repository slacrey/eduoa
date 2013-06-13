package com.node.burn.service.impl;

import com.node.burn.dao.MenuItemDao;
import com.node.burn.model.MenuItem;
import com.node.burn.service.MenuItemManager;
import com.node.burn.service.impl.GenericManagerImpl;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;

@Service("menuItemManager")
@WebService(serviceName = "MenuItemService", endpointInterface = "com.node.burn.service.MenuItemManager")
public class MenuItemManagerImpl extends GenericManagerImpl<MenuItem, Long> implements MenuItemManager {
    MenuItemDao menuItemDao;

    @Autowired
    public MenuItemManagerImpl(MenuItemDao menuItemDao) {
        super(menuItemDao);
        this.menuItemDao = menuItemDao;
    }

    @Override
    public List<MenuItem> findTopMenuItems() {
        return menuItemDao.findByNamedQuery("menuItem.findTopMenuItem", new HashMap<String, Object>());
    }
}