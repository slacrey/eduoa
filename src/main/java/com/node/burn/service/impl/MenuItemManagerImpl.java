package com.node.burn.service.impl;

import com.node.burn.dao.MenuItemDao;
import com.node.burn.model.SysMenuItemEntity;
import com.node.burn.service.MenuItemManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import javax.jws.WebService;

@Service("menuItemManager")
@WebService(serviceName = "MenuItemService", endpointInterface = "com.node.burn.service.MenuItemManager")
public class MenuItemManagerImpl extends GenericManagerImpl<SysMenuItemEntity, Long> implements MenuItemManager {
    MenuItemDao menuItemDao;

    @Autowired
    public MenuItemManagerImpl(MenuItemDao menuItemDao) {
        super(menuItemDao);
        this.menuItemDao = menuItemDao;
    }

    @Override
    public List<SysMenuItemEntity> findTopMenuItems() {
        return menuItemDao.findByNamedQuery("menuItem.findTopMenuItem", new HashMap<String, Object>());
    }
}