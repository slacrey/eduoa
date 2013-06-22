package com.node.burn.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_class", catalog = "eduoa")
@Entity
public class OaClassEntity {
    private long id;

    @Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String className;

    @Column(name = "class_name")
    @Basic
    String getClassName() {
        return className;
    }

    void setClassName(String className) {
        this.className = className;
    }

    private Integer category;

    @Column(name = "category")
    @Basic
    Integer getCategory() {
        return category;
    }

    void setCategory(Integer category) {
        this.category = category;
    }

    private String description;

    @Column(name = "description")
    @Basic
    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    private Integer numberLimit;

    @Column(name = "number_limit")
    @Basic
    Integer getNumberLimit() {
        return numberLimit;
    }

    void setNumberLimit(Integer numberLimit) {
        this.numberLimit = numberLimit;
    }

    private Date createTime;

    @Column(name = "create_time")
    @Basic
    Date getCreateTime() {
        return createTime;
    }

    void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date updateTime;

    @Column(name = "update_time")
    @Basic
    Date getUpdateTime() {
        return updateTime;
    }

    void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private Long createUserId;

    @Column(name = "create_user_id")
    @Basic
    Long getCreateUserId() {
        return createUserId;
    }

    void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    private Long updateUserId;

    @Column(name = "update_user_id")
    @Basic
    Long getUpdateUserId() {
        return updateUserId;
    }

    void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaClassEntity that = (OaClassEntity) o;

        if (id != that.id) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (numberLimit != null ? !numberLimit.equals(that.numberLimit) : that.numberLimit != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateUserId != null ? !updateUserId.equals(that.updateUserId) : that.updateUserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (numberLimit != null ? numberLimit.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        return result;
    }

    private OaGradeEntity oaGradeByGradeId;

    @ManyToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    OaGradeEntity getOaGradeByGradeId() {
        return oaGradeByGradeId;
    }

    void setOaGradeByGradeId(OaGradeEntity oaGradeByGradeId) {
        this.oaGradeByGradeId = oaGradeByGradeId;
    }

    private Collection<OaClassTeacherEntity> oaClassTeachersById;

    @OneToMany(mappedBy = "oaClassByClassId")
    Collection<OaClassTeacherEntity> getOaClassTeachersById() {
        return oaClassTeachersById;
    }

    void setOaClassTeachersById(Collection<OaClassTeacherEntity> oaClassTeachersById) {
        this.oaClassTeachersById = oaClassTeachersById;
    }

    private Collection<OaStudentClassEntity> oaStudentClassesById;

    @OneToMany(mappedBy = "oaClassByClassId")
    Collection<OaStudentClassEntity> getOaStudentClassesById() {
        return oaStudentClassesById;
    }

    void setOaStudentClassesById(Collection<OaStudentClassEntity> oaStudentClassesById) {
        this.oaStudentClassesById = oaStudentClassesById;
    }
}
