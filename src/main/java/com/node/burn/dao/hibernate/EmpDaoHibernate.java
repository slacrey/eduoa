package com.node.burn.dao.hibernate;

import com.node.burn.model.Emp;
import com.node.burn.dao.EmpDao;
import com.node.burn.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("empDao")
public class EmpDaoHibernate extends GenericDaoHibernate<Emp, Long> implements EmpDao {

    public EmpDaoHibernate() {
        super(Emp.class);
    }
}
