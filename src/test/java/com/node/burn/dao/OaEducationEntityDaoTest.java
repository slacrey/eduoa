package com.node.burn.dao;

import com.node.burn.dao.hibernate.OaEducationEntityDaoHibernate;
import com.node.burn.model.OaEducationEntity;
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
 * Time: 下午12:14
 * To change this template use File | Settings | File Templates.
 */
public class OaEducationEntityDaoTest extends BaseDaoTestCase {


    @Qualifier("oaEducationEntityDao")
    @Autowired
    private OaEducationEntityDao oaEducationEntityDao;


    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveEmp() {
        OaEducationEntity oaEducationEntity = new  OaEducationEntity();
        oaEducationEntity.setEduName("test");
        // enter all required fields

        log.debug("adding OaEducationEntity...");
        oaEducationEntity = oaEducationEntityDao.save(oaEducationEntity);

        oaEducationEntity = oaEducationEntityDao.get(oaEducationEntity.getId());

        assertNotNull(oaEducationEntity.getId());

        log.debug("removing OaEducationEntity...");

        oaEducationEntityDao.remove(oaEducationEntity.getId());

        // should throw DataAccessException
        oaEducationEntityDao.get(oaEducationEntity.getId());
    }

}
