package com.node.burn.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_organizational_structure", schema = "", catalog = "eduoa")
@Entity
public class OaOrganizationalStructureEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String structureName;

    @javax.persistence.Column(name = "structure_name")
    @Basic
    String getStructureName() {
        return structureName;
    }

    void setStructureName(String structureName) {
        this.structureName = structureName;
    }

    private Date createTime;

    @javax.persistence.Column(name = "create_time")
    @Basic
    Date getCreateTime() {
        return createTime;
    }

    void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Long userId;

    @javax.persistence.Column(name = "user_id")
    @Basic
    Long getUserId() {
        return userId;
    }

    void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaOrganizationalStructureEntity that = (OaOrganizationalStructureEntity) o;

        if (id != that.id) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (structureName != null ? !structureName.equals(that.structureName) : that.structureName != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (structureName != null ? structureName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    private SysAttachmentEntity sysAttachmentByAttachmentId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "attachment_id", referencedColumnName = "id")
    SysAttachmentEntity getSysAttachmentByAttachmentId() {
        return sysAttachmentByAttachmentId;
    }

    void setSysAttachmentByAttachmentId(SysAttachmentEntity sysAttachmentByAttachmentId) {
        this.sysAttachmentByAttachmentId = sysAttachmentByAttachmentId;
    }
}
