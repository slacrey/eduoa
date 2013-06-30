package com.node.burn.service;

import com.node.burn.model.OaDepartmentEntity;

import javax.jws.WebService;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-29
 * Time: 下午2:08
 * To change this template use File | Settings | File Templates.
 */
@WebService
public interface OaDepartmentEntityManager extends GenericManager<OaDepartmentEntity, Long> {

    public List<OaDepartmentEntity> searchByParentId(Long parentId);

}
