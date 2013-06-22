package com.node.burn.service;

import com.node.burn.model.SysMenuItemEntity;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface MenuItemManager extends GenericManager<SysMenuItemEntity, Long> {

    List<SysMenuItemEntity> findTopMenuItems();

}