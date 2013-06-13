package com.node.burn.service;

import com.node.burn.service.GenericManager;
import com.node.burn.model.MenuItem;

import java.util.List;
import java.util.Map;
import javax.jws.WebService;

@WebService
public interface MenuItemManager extends GenericManager<MenuItem, Long> {

    List<MenuItem> findTopMenuItems();

}