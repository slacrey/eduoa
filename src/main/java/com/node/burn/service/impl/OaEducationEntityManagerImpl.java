package com.node.burn.service.impl;

import com.node.burn.dao.OaEducationEntityDao;
import com.node.burn.model.OaEducationEntity;
import com.node.burn.service.OaEducationEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-29
 * Time: 下午12:35
 * To change this template use File | Settings | File Templates.
 */
@Service("oaEducationEntityManager")
@WebService(serviceName = "EducationService", endpointInterface = "com.node.burn.service.OaEducationEntityManager")
public class OaEducationEntityManagerImpl extends GenericManagerImpl<OaEducationEntity, Long> implements OaEducationEntityManager {
    OaEducationEntityDao oaEducationEntityDao;

    @Autowired
    public OaEducationEntityManagerImpl(OaEducationEntityDao oaEducationEntityDao) {
        super(oaEducationEntityDao);
        this.oaEducationEntityDao = oaEducationEntityDao;
    }
}
