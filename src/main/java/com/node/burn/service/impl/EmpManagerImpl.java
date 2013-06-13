package com.node.burn.service.impl;

import com.node.burn.dao.EmpDao;
import com.node.burn.model.Emp;
import com.node.burn.service.EmpManager;
import com.node.burn.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("empManager")
@WebService(serviceName = "EmpService", endpointInterface = "com.node.burn.service.EmpManager")
public class EmpManagerImpl extends GenericManagerImpl<Emp, Long> implements EmpManager {
    EmpDao empDao;

    @Autowired
    public EmpManagerImpl(EmpDao empDao) {
        super(empDao);
        this.empDao = empDao;
    }
}