package com.node.burn.webapp.action;

import com.node.burn.dao.SearchException;
import com.node.burn.model.Emp;
import com.node.burn.model.OaDepartmentEntity;
import com.node.burn.service.EmpManager;
import com.node.burn.service.OaDepartmentEntityManager;
import com.node.burn.service.impl.OaDepartmentEntityManagerImpl;
import com.node.burn.util.JacksonUtil;
import com.node.burn.util.tree.TreeNode;
import com.opensymphony.xwork2.Preparable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class OaDepartmentEntityAction extends BaseAction implements Preparable {

    private Long parentId;
    private EmpManager empManager;
    private List emps;
    private Emp emp;
    private Long eid;
    private String query;
    @Qualifier("oaDepartmentEntityManager")
    @Autowired
    private OaDepartmentEntityManager oaDepartmentEntityManager;

    private List<OaDepartmentEntity> oaDepartmentEntities;

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

    public void initTree() {
        String id = getRequest().getParameter("parentId");
        if (id != null) {
            parentId = Long.valueOf(id);
        }
        List<OaDepartmentEntity> oaDepartmentEntities = oaDepartmentEntityManager.searchByParentId(parentId);
        List<TreeNode<OaDepartmentEntity>> treeNodes = new ArrayList<TreeNode<OaDepartmentEntity>>();
        if (oaDepartmentEntities != null && !oaDepartmentEntities.isEmpty()) {
            TreeNode<OaDepartmentEntity> treeNode = null;
            for (OaDepartmentEntity departmentEntity: oaDepartmentEntities) {
                if (departmentEntity.getOaDepartmentsById() != null
                        && !departmentEntity.getOaDepartmentsById().isEmpty()) {
                    treeNode = new TreeNode<OaDepartmentEntity>(departmentEntity.getId()+"", departmentEntity.getDepartName(), true);
                    treeNode.setOpen(true);
                } else {
                    treeNode = new TreeNode<OaDepartmentEntity>(departmentEntity.getId()+"", departmentEntity.getDepartName(), false);
                }
                treeNode.setVal(departmentEntity);
                treeNodes.add(treeNode);
            }
        }
        JacksonUtil jacksonUtil = new JacksonUtil();
        String result = jacksonUtil.toJson(treeNodes);
        this.sendMessage(result);
    }

    public String list() {
        try {
            oaDepartmentEntities = oaDepartmentEntityManager.search(query, OaDepartmentEntity.class);
        } catch (SearchException se) {
            addActionError(se.getMessage());
            oaDepartmentEntities = oaDepartmentEntityManager.getAll();
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

    public List<OaDepartmentEntity> getOaDepartmentEntities() {
        return oaDepartmentEntities;
    }

    public void setOaDepartmentEntities(List<OaDepartmentEntity> oaDepartmentEntities) {
        this.oaDepartmentEntities = oaDepartmentEntities;
    }
}