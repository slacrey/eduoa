package com.node.burn.dao;

import com.node.burn.dao.hibernate.OaDepartmentEntityDaoHibernate;
import com.node.burn.model.OaDepartmentEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import static junit.framework.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-29
 * Time: 下午2:03
 * To change this template use File | Settings | File Templates.
 */
public class OaDepartmentEntityDaoTest extends BaseDaoTestCase {

    @Qualifier("oaDepartmentEntityDao")
    @Autowired
    private OaDepartmentEntityDao oaDepartmentEntityDao;

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveEmp() {
        OaDepartmentEntity oaDepartmentEntity = new OaDepartmentEntity();
        oaDepartmentEntity.setDepartName("test");
        // enter all required fields

        log.debug("adding OaDepartmentEntity...");
        oaDepartmentEntity = oaDepartmentEntityDao.save(oaDepartmentEntity);

        oaDepartmentEntity = oaDepartmentEntityDao.get(oaDepartmentEntity.getId());

        assertNotNull(oaDepartmentEntity.getId());

        log.debug("removing OaDepartmentEntity...");

        oaDepartmentEntityDao.remove(oaDepartmentEntity.getId());

        // should throw DataAccessException
        oaDepartmentEntityDao.get(oaDepartmentEntity.getId());
    }
}
