package com.node.burn.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.node.burn.service.EmpManager;
import com.node.burn.model.Emp;
import com.node.burn.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmpActionTest extends BaseActionTestCase {
    private EmpAction action;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new EmpAction();
        EmpManager empManager = (EmpManager) applicationContext.getBean("empManager");
        action.setEmpManager(empManager);

        // add a test emp to the database
        Emp emp = new Emp();

        // enter all required fields

        empManager.save(emp);
    }

    @Test
    public void testGetAllEmps() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getEmps().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        EmpManager empManager = (EmpManager) applicationContext.getBean("empManager");
        empManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getEmps().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setEid(-1L);
        assertNull(action.getEmp());
        assertEquals("success", action.edit());
        assertNotNull(action.getEmp());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setEid(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getEmp());

        Emp emp = action.getEmp();
        // update required fields

        action.setEmp(emp);

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
        Emp emp = new Emp();
        emp.setEid(-2L);
        action.setEmp(emp);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}