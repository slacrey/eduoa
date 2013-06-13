package com.node.burn.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.node.burn.service.MenuItemManager;
import com.node.burn.model.MenuItem;
import com.node.burn.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MenuItemActionTest extends BaseActionTestCase {
    private MenuItemAction action;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new MenuItemAction();
        MenuItemManager menuItemManager = (MenuItemManager) applicationContext.getBean("menuItemManager");
        action.setMenuItemManager(menuItemManager);

        // add a test menuItem to the database
        MenuItem menuItem = new MenuItem();

        // enter all required fields

        menuItemManager.save(menuItem);
    }

    @Test
    public void testGetAllMenuItems() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getMenuItems().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        MenuItemManager menuItemManager = (MenuItemManager) applicationContext.getBean("menuItemManager");
        menuItemManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getMenuItems().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setId(-1L);
        assertNull(action.getMenuItem());
        assertEquals("success", action.edit());
        assertNotNull(action.getMenuItem());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setId(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getMenuItem());

        MenuItem menuItem = action.getMenuItem();
        // update required fields

        action.setMenuItem(menuItem);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    @Test
    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        MenuItem menuItem = new MenuItem();
        menuItem.setId(-2L);
        action.setMenuItem(menuItem);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}