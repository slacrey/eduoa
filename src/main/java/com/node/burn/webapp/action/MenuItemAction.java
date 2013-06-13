package com.node.burn.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.node.burn.service.MenuItemManager;
import com.node.burn.dao.SearchException;
import com.node.burn.model.MenuItem;
import com.node.burn.webapp.action.BaseAction;

import java.util.List;

public class MenuItemAction extends BaseAction implements Preparable {
    private MenuItemManager menuItemManager;
    private List menuItems;
    private MenuItem menuItem;
    private Long id;
    private String query;

    public void setMenuItemManager(MenuItemManager menuItemManager) {
        this.menuItemManager = menuItemManager;
    }

    public List getMenuItems() {
        return menuItems;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String menuItemId = getRequest().getParameter("menuItem.id");
            if (menuItemId != null && !menuItemId.equals("")) {
                menuItem = menuItemManager.get(new Long(menuItemId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            menuItems = menuItemManager.search(query, MenuItem.class);
        } catch (SearchException se) {
            addActionError(se.getMessage());
            menuItems = menuItemManager.getAll();
        }
        return SUCCESS;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public String delete() {
        menuItemManager.remove(menuItem.getId());
        saveMessage(getText("menuItem.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (id != null) {
            menuItem = menuItemManager.get(id);
        } else {
            menuItem = new MenuItem();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            return "cancel";
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (menuItem.getId() == null);

        menuItemManager.save(menuItem);

        String key = (isNew) ? "menuItem.added" : "menuItem.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}