package com.node.burn.service;

import com.node.burn.service.GenericManager;
import com.node.burn.model.Emp;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface EmpManager extends GenericManager<Emp, Long> {
    
}