package com.node.burn.service.impl;

import com.node.burn.dao.OaDepartmentEntityDao;
import com.node.burn.model.OaDepartmentEntity;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-29
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */
public class OaDepartmentEntityManagerImplTest extends BaseManagerMockTestCase {

    private OaDepartmentEntityManagerImpl manager = null;
    private OaDepartmentEntityDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(OaDepartmentEntityDao.class);
        manager = new OaDepartmentEntityManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetEmp() {
        log.debug("testing get...");

        final Long eid = 7L;
        final OaDepartmentEntity oaDepartmentEntity = new OaDepartmentEntity();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(eid)));
            will(returnValue(oaDepartmentEntity));
        }});

        OaDepartmentEntity result = manager.get(eid);
        assertSame(oaDepartmentEntity, result);
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

        final OaDepartmentEntity oaDepartmentEntity = new OaDepartmentEntity();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(oaDepartmentEntity)));
        }});

        manager.save(oaDepartmentEntity);
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
