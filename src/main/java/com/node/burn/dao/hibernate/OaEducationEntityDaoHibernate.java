package com.node.burn.dao.hibernate;

import com.node.burn.dao.OaEducationEntityDao;
import com.node.burn.model.OaEducationEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-29
 * Time: 下午12:11
 * To change this template use File | Settings | File Templates.
 */
@Repository("oaEducationEntityDao")
public class OaEducationEntityDaoHibernate extends GenericDaoHibernate<OaEducationEntity, Long> implements OaEducationEntityDao {

    public OaEducationEntityDaoHibernate() {
        super(OaEducationEntity.class);
    }

}
