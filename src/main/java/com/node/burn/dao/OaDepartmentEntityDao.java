package com.node.burn.dao;

import com.node.burn.model.OaDepartmentEntity;

import java.util.List;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-29
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
public interface OaDepartmentEntityDao extends GenericDao<OaDepartmentEntity, Long>  {

    public List<OaDepartmentEntity> searchByParentId(Long parentId);

    public List<OaDepartmentEntity> searchTop();

}
