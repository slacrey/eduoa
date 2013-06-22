package com.node.burn.dao;

import com.node.burn.model.SysUserEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.node.burn.dao.hibernate.GenericDaoHibernate;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class GenericDaoTest extends BaseDaoTestCase {
    Log log = LogFactory.getLog(GenericDaoTest.class);
    GenericDao<SysUserEntity, Long> genericDao;
    @Autowired
    SessionFactory sessionFactory;

    @Before
    public void setUp() {
        genericDao = new GenericDaoHibernate<SysUserEntity, Long>(SysUserEntity.class, sessionFactory);
    }

    @Test
    public void getUser() {
        SysUserEntity user = genericDao.get(-1L);
        assertNotNull(user);
        assertEquals("user", user.getUsername());
    }
}
