package com.node.burn.dao;

import com.node.burn.model.SysMenuItemEntity;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.ExpectedException;

public class MenuItemDaoTest extends BaseDaoTestCase {
    @Autowired
    private MenuItemDao menuItemDao;

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveMenuItem() {
        SysMenuItemEntity menuItem = new SysMenuItemEntity();

        // enter all required fields

        log.debug("adding menuItem...");
        menuItem = menuItemDao.save(menuItem);

        menuItem = menuItemDao.get(menuItem.getId());

        assertNotNull(menuItem.getId());

        log.debug("removing menuItem...");

        menuItemDao.remove(menuItem.getId());

        // should throw DataAccessException 
        menuItemDao.get(menuItem.getId());
    }
}