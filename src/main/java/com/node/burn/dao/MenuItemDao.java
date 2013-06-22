package com.node.burn.dao;

import com.node.burn.model.SysMenuItemEntity;

import java.util.List;

/**
 * An interface that provides a data management interface to the SysMenuItemEntity table.
 */
public interface MenuItemDao extends GenericDao<SysMenuItemEntity, Long> {

    public List<SysMenuItemEntity> findTopMenuItems();

}