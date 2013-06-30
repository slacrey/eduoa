package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_organizational_structure", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaOrganizationalStructureEntity extends BaseObject implements Serializable {
    private Long id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String structureName;

    @javax.persistence.Column(name = "structure_name")
    @Basic
    public String getStructureName() {
        return structureName;
    }

    public void setStructureName(String structureName) {
        this.structureName = structureName;
    }

    private Date createTime;

    @javax.persistence.Column(name = "create_time")
    @Basic
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Long userId;

    @javax.persistence.Column(name = "user_id")
    @Basic
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
    public SysAttachmentEntity getSysAttachmentByAttachmentId() {
        return sysAttachmentByAttachmentId;
    }

    public void setSysAttachmentByAttachmentId(SysAttachmentEntity sysAttachmentByAttachmentId) {
        this.sysAttachmentByAttachmentId = sysAttachmentByAttachmentId;
    }
}
