package com.node.burn.service.impl;

import com.node.burn.dao.OaEducationEntityDao;
import com.node.burn.model.OaEducationEntity;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-29
 * Time: 下午12:38
 * To change this template use File | Settings | File Templates.
 */
public class OaEducationEntityManagerImplTest extends BaseManagerMockTestCase {

    private OaEducationEntityManagerImpl manager = null;
    private OaEducationEntityDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(OaEducationEntityDao.class);
        manager = new OaEducationEntityManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetEmp() {
        log.debug("testing get...");

        final Long eid = 7L;
        final OaEducationEntity oaEducationEntity = new OaEducationEntity();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(eid)));
            will(returnValue(oaEducationEntity));
        }});

        OaEducationEntity result = manager.get(eid);
        assertSame(oaEducationEntity, result);
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

        final OaEducationEntity oaEducationEntity = new OaEducationEntity();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(oaEducationEntity)));
        }});

        manager.save(oaEducationEntity);
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
