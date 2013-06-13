package com.node.burn.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.node.burn.dao.MenuItemDao;
import com.node.burn.model.MenuItem;
import com.node.burn.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class MenuItemManagerImplTest extends BaseManagerMockTestCase {
    private MenuItemManagerImpl manager = null;
    private MenuItemDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(MenuItemDao.class);
        manager = new MenuItemManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetMenuItem() {
        log.debug("testing get...");

        final Long id = 7L;
        final MenuItem menuItem = new MenuItem();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(menuItem));
        }});

        MenuItem result = manager.get(id);
        assertSame(menuItem, result);
    }

    @Test
    public void testGetMenuItems() {
        log.debug("testing getAll...");

        final List menuItems = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(menuItems));
        }});

        List result = manager.getAll();
        assertSame(menuItems, result);
    }

    @Test
    public void testSaveMenuItem() {
        log.debug("testing save...");

        final MenuItem menuItem = new MenuItem();
        // enter all required fields
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(menuItem)));
        }});

        manager.save(menuItem);
    }

    @Test
    public void testRemoveMenuItem() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}