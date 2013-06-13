package com.node.burn.dao;

import com.node.burn.dao.GenericDao;

import com.node.burn.model.MenuItem;

import java.util.List;

/**
 * An interface that provides a data management interface to the MenuItem table.
 */
public interface MenuItemDao extends GenericDao<MenuItem, Long> {

    public List<MenuItem> findTopMenuItems();

}