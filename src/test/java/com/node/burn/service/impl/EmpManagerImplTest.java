package com.node.burn.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.node.burn.dao.EmpDao;
import com.node.burn.model.Emp;
import com.node.burn.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmpManagerImplTest extends BaseManagerMockTestCase {
    private EmpManagerImpl manager = null;
    private EmpDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(EmpDao.class);
        manager = new EmpManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetEmp() {
        log.debug("testing get...");

        final Long eid = 7L;
        final Emp emp = new Emp();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(eid)));
            will(returnValue(emp));
        }});

        Emp result = manager.get(eid);
        assertSame(emp, result);
    }

    @Test
    public void testGetEmps() {
        log.debug("testing getAll...");

        final List emps = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(emps));
        }});

        List result = manager.getAll();
        assertSame(emps, result);
    }

    @Test
    public void testSaveEmp() {
        log.debug("testing save...");

        final Emp emp = new Emp();
        // enter all required fields
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(emp)));
        }});

        manager.save(emp);
    }

    @Test
    public void testRemoveEmp() {
        log.debug("testing remove...");

        final Long eid = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(eid)));
        }});

        manager.remove(eid);
    }
}