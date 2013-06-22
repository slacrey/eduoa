package com.node.burn.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_appraisal", catalog = "eduoa")
@Entity
public class OaAppraisalEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private Integer atype;

    @javax.persistence.Column(name = "atype")
    @Basic
    Integer getAtype() {
        return atype;
    }

    void setAtype(Integer atype) {
        this.atype = atype;
    }

    private Date startMonth;

    @javax.persistence.Column(name = "start_month")
    @Basic
    Date getStartMonth() {
        return startMonth;
    }

    void setStartMonth(Date startMonth) {
        this.startMonth = startMonth;
    }

    private Date endMonth;

    @javax.persistence.Column(name = "end_month")
    @Basic
    Date getEndMonth() {
        return endMonth;
    }

    void setEndMonth(Date endMonth) {
        this.endMonth = endMonth;
    }

    private Long teacherId;

    @javax.persistence.Column(name = "teacher_id")
    @Basic
    Long getTeacherId() {
        return teacherId;
    }

    void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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

        OaAppraisalEntity that = (OaAppraisalEntity) o;

        if (id != that.id) return false;
        if (atype != null ? !atype.equals(that.atype) : that.atype != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (endMonth != null ? !endMonth.equals(that.endMonth) : that.endMonth != null) return false;
        if (startMonth != null ? !startMonth.equals(that.startMonth) : that.startMonth != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

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
    Collection<SysTypeRulesEntity> getSysTypeRulesesById() {
        return sysTypeRulesesById;
    }

    void setSysTypeRulesesById(Collection<SysTypeRulesEntity> sysTypeRulesesById) {
        this.sysTypeRulesesById = sysTypeRulesesById;
    }
}
