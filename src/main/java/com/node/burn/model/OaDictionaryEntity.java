package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_dictionary", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaDictionaryEntity extends BaseObject implements Serializable {
    private Long id;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String dictName;

    @Column(name = "dict_name")
    @Basic
    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    private String dictKey;

    @Column(name = "dict_key")
    @Basic
    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaDictionaryEntity that = (OaDictionaryEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dictKey != null ? !dictKey.equals(that.dictKey) : that.dictKey != null) return false;
        if (dictName != null ? !dictName.equals(that.dictName) : that.dictName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (dictName != null ? dictName.hashCode() : 0);
        result = 31 * result + (dictKey != null ? dictKey.hashCode() : 0);
        return result;
    }

    private OaDictionaryEntity oaDictionaryByParentId;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public OaDictionaryEntity getOaDictionaryByParentId() {
        return oaDictionaryByParentId;
    }

    public void setOaDictionaryByParentId(OaDictionaryEntity oaDictionaryByParentId) {
        this.oaDictionaryByParentId = oaDictionaryByParentId;
    }

    private Collection<OaDictionaryEntity> oaDictionariesById;

    @OneToMany(mappedBy = "oaDictionaryByParentId")
    public Collection<OaDictionaryEntity> getOaDictionariesById() {
        return oaDictionariesById;
    }

    public void setOaDictionariesById(Collection<OaDictionaryEntity> oaDictionariesById) {
        this.oaDictionariesById = oaDictionariesById;
    }

    private Collection<OaDictionaryValueEntity> oaDictionaryValuesById;

    @OneToMany(mappedBy = "oaDictionaryByDictionaryId")
    public Collection<OaDictionaryValueEntity> getOaDictionaryValuesById() {
        return oaDictionaryValuesById;
    }

    public void setOaDictionaryValuesById(Collection<OaDictionaryValueEntity> oaDictionaryValuesById) {
        this.oaDictionaryValuesById = oaDictionaryValuesById;
    }
}
