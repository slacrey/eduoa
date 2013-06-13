package com.node.burn.dao;

import com.node.burn.dao.BaseDaoTestCase;
import com.node.burn.model.Emp;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.annotation.ExpectedException;

import java.util.List;

public class EmpDaoTest extends BaseDaoTestCase {
    @Autowired
    private EmpDao empDao;

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveEmp() {
        Emp emp = new Emp();

        // enter all required fields

        log.debug("adding emp...");
        emp = empDao.save(emp);

        emp = empDao.get(emp.getEid());

        assertNotNull(emp.getEid());

        log.debug("removing emp...");

        empDao.remove(emp.getEid());

        // should throw DataAccessException 
        empDao.get(emp.getEid());
    }
}