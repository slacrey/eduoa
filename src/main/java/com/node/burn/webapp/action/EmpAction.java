package com.node.burn.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.node.burn.service.EmpManager;
import com.node.burn.dao.SearchException;
import com.node.burn.model.Emp;
import com.node.burn.webapp.action.BaseAction;

import java.util.List;

public class EmpAction extends BaseAction implements Preparable {
    private EmpManager empManager;
    private List emps;
    private Emp emp;
    private Long eid;
    private String query;

    public void setEmpManager(EmpManager empManager) {
        this.empManager = empManager;
    }

    public List getEmps() {
        return emps;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String empId = getRequest().getParameter("emp.eid");
            if (empId != null && !empId.equals("")) {
                emp = empManager.get(new Long(empId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            emps = empManager.search(query, Emp.class);
        } catch (SearchException se) {
            addActionError(se.getMessage());
            emps = empManager.getAll();
        }
        return SUCCESS;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public String delete() {
        empManager.remove(emp.getEid());
        saveMessage(getText("emp.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (eid != null) {
            emp = empManager.get(eid);
        } else {
            emp = new Emp();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            return "cancel";
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (emp.getEid() == null);

        empManager.save(emp);

        String key = (isNew) ? "emp.added" : "emp.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}