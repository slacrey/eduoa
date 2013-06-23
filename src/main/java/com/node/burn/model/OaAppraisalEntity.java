package com.node.burn.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_appraisal")
@Entity
public class OaAppraisalEntity extends BaseObject implements Serializable {
    private Long id;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Integer atype;

    @Column(name = "atype")
    @Basic
    public Integer getAtype() {
        return atype;
    }

    public void setAtype(Integer atype) {
        this.atype = atype;
    }

    private Date startMonth;

    @Column(name = "start_month")
    @Basic
    public Date getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Date startMonth) {
        this.startMonth = startMonth;
    }

    private Date endMonth;

    @Column(name = "end_month")
    @Basic
    public Date getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Date endMonth) {
        this.endMonth = endMonth;
    }

    private Long teacherId;

    @Column(name = "teacher_id")
    @Basic
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    private Date createTime;

    @Column(name = "create_time")
    @Basic
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Long userId;

    @Column(name = "user_id")
    @Basic
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.getId())
                .toString();
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
    public Collection<SysTypeRulesEntity> getSysTypeRulesesById() {
        return sysTypeRulesesById;
    }

    public void setSysTypeRulesesById(Collection<SysTypeRulesEntity> sysTypeRulesesById) {
        this.sysTypeRulesesById = sysTypeRulesesById;
    }
}
