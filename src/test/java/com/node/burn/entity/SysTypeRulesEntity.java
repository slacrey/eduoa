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
@javax.persistence.Table(name = "sys_type_rules", schema = "", catalog = "eduoa")
@Entity
public class SysTypeRulesEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private Integer roleType;

    @javax.persistence.Column(name = "role_type")
    @Basic
    Integer getRoleType() {
        return roleType;
    }

    void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    private String roleName;

    @javax.persistence.Column(name = "role_name")
    @Basic
    String getRoleName() {
        return roleName;
    }

    void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String content;

    @javax.persistence.Column(name = "content")
    @Basic
    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysTypeRulesEntity that = (SysTypeRulesEntity) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (roleType != null ? !roleType.equals(that.roleType) : that.roleType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (roleType != null ? roleType.hashCode() : 0);
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    private OaAppraisalEntity oaAppraisalByApplayId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "applay_id", referencedColumnName = "id")
    OaAppraisalEntity getOaAppraisalByApplayId() {
        return oaAppraisalByApplayId;
    }

    void setOaAppraisalByApplayId(OaAppraisalEntity oaAppraisalByApplayId) {
        this.oaAppraisalByApplayId = oaAppraisalByApplayId;
    }
}
