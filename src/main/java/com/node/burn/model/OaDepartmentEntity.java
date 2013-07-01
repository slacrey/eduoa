package com.node.burn.model;

import com.node.burn.util.JacksonUtil;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

/**
 * 部门
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_department", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
@JsonAutoDetect(JsonMethod.NONE)
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class OaDepartmentEntity extends BaseObject implements Serializable {
    private Long id;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    @JsonSerialize
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String departName;

    @Column(name = "depart_name")
    @Basic
    @JsonSerialize
    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    private String description;

    @Column(name = "description")
    @Basic
    @JsonSerialize
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Integer departOrder;

    @Column(name = "depart_order")
    @Basic
    @JsonSerialize
    public Integer getDepartOrder() {
        return departOrder;
    }

    public void setDepartOrder(Integer departOrder) {
        this.departOrder = departOrder;
    }

    @Override
    public String toString() {
        JacksonUtil jacksonUtil = new JacksonUtil();
        return jacksonUtil.toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaDepartmentEntity that = (OaDepartmentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (departName != null ? !departName.equals(that.departName) : that.departName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (departName != null ? departName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private OaDepartmentEntity oaDepartmentByParentId;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @JsonIgnore
    public OaDepartmentEntity getOaDepartmentByParentId() {
        return oaDepartmentByParentId;
    }

    public void setOaDepartmentByParentId(OaDepartmentEntity oaDepartmentByParentId) {
        this.oaDepartmentByParentId = oaDepartmentByParentId;
    }

    private Collection<OaDepartmentEntity> oaDepartmentsById;

    @OneToMany(mappedBy = "oaDepartmentByParentId")
    @JsonIgnore
    public Collection<OaDepartmentEntity> getOaDepartmentsById() {
        return oaDepartmentsById;
    }

    public void setOaDepartmentsById(Collection<OaDepartmentEntity> oaDepartmentsById) {
        this.oaDepartmentsById = oaDepartmentsById;
    }

    private OaEducationEntity oaEducationByEducationId;

    @ManyToOne
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    @JsonIgnore
    public OaEducationEntity getOaEducationByEducationId() {
        return oaEducationByEducationId;
    }

    public void setOaEducationByEducationId(OaEducationEntity oaEducationByEducationId) {
        this.oaEducationByEducationId = oaEducationByEducationId;
    }

    private Collection<OaTeacherInfoEntity> oaTeacherInfosById;

    @OneToMany(mappedBy = "oaDepartmentByDepartmentId")
    @JsonIgnore
    public Collection<OaTeacherInfoEntity> getOaTeacherInfosById() {
        return oaTeacherInfosById;
    }

    public void setOaTeacherInfosById(Collection<OaTeacherInfoEntity> oaTeacherInfosById) {
        this.oaTeacherInfosById = oaTeacherInfosById;
    }
}
