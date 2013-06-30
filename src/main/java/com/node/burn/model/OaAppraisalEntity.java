package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_appraisal", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaAppraisalEntity extends BaseObject implements Serializable {
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

    private Integer atype;

    @javax.persistence.Column(name = "atype")
    @Basic
    public Integer getAtype() {
        return atype;
    }

    public void setAtype(Integer atype) {
        this.atype = atype;
    }

    private Date startMonth;

    @javax.persistence.Column(name = "start_month")
    @Basic
    public Date getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Date startMonth) {
        this.startMonth = startMonth;
    }

    private Date endMonth;

    @javax.persistence.Column(name = "end_month")
    @Basic
    public Date getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Date endMonth) {
        this.endMonth = endMonth;
    }

    private Long teacherId;

    @javax.persistence.Column(name = "teacher_id")
    @Basic
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaAppraisalEntity that = (OaAppraisalEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (atype != null ? !atype.equals(that.atype) : that.atype != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (endMonth != null ? !endMonth.equals(that.endMonth) : that.endMonth != null) return false;
        if (startMonth != null ? !startMonth.equals(that.startMonth) : that.startMonth != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (userId != null) {
            if (!userId.equals(that.userId)) return false;
        } else {
            if (that.userId != null) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (atype != null ? atype.hashCode() : 0);
        result = 31 * result + (startMonth != null ? startMonth.hashCode() : 0);
        result = 31 * result + (endMonth != null ? endMonth.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    private Collection<SysTypeRulesEntity> sysTypeRulesesById;

    @OneToMany(mappedBy = "oaAppraisalByApplayId")
    public Collection<SysTypeRulesEntity> getSysTypeRulesesById() {
        return sysTypeRulesesById;
    }

    public void setSysTypeRulesesById(Collection<SysTypeRulesEntity> sysTypeRulesesById) {
        this.sysTypeRulesesById = sysTypeRulesesById;
    }
}
