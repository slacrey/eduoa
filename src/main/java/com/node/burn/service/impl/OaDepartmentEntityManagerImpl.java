package com.node.burn.service.impl;

import com.node.burn.dao.OaDepartmentEntityDao;
import com.node.burn.dao.OaEducationEntityDao;
import com.node.burn.dao.hibernate.OaDepartmentEntityDaoHibernate;
import com.node.burn.dao.hibernate.OaEducationEntityDaoHibernate;
import com.node.burn.model.OaDepartmentEntity;
import com.node.burn.service.OaDepartmentEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-29
 * Time: 下午2:09
 * To change this template use File | Settings | File Templates.
 */
@Service("oaDepartmentEntityManager")
@WebService(serviceName = "DepartmentService", endpointInterface = "com.node.burn.service.OaDepartmentEntityManager")
public class OaDepartmentEntityManagerImpl extends GenericManagerImpl<OaDepartmentEntity, Long> implements OaDepartmentEntityManager {

    OaDepartmentEntityDao oaDepartmentEntityDao;

    @Autowired
    public OaDepartmentEntityManagerImpl(OaDepartmentEntityDao oaDepartmentEntityDao) {
        super(oaDepartmentEntityDao);
        this.oaDepartmentEntityDao = oaDepartmentEntityDao;
    }

    @Override
    public List<OaDepartmentEntity> searchByParentId(Long parentId) {
        return oaDepartmentEntityDao.searchByParentId(parentId);
    }
}
