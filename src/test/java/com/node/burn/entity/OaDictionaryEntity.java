package com.node.burn.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_dictionary", schema = "", catalog = "eduoa")
@Entity
public class OaDictionaryEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String dictName;

    @javax.persistence.Column(name = "dict_name")
    @Basic
    String getDictName() {
        return dictName;
    }

    void setDictName(String dictName) {
        this.dictName = dictName;
    }

    private String dictKey;

    @javax.persistence.Column(name = "dict_key")
    @Basic
    String getDictKey() {
        return dictKey;
    }

    void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaDictionaryEntity that = (OaDictionaryEntity) o;

        if (id != that.id) return false;
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
    @javax.persistence.JoinColumn(name = "parent_id", referencedColumnName = "id")
    OaDictionaryEntity getOaDictionaryByParentId() {
        return oaDictionaryByParentId;
    }

    void setOaDictionaryByParentId(OaDictionaryEntity oaDictionaryByParentId) {
        this.oaDictionaryByParentId = oaDictionaryByParentId;
    }

    private Collection<OaDictionaryEntity> oaDictionariesById;

    @OneToMany(mappedBy = "oaDictionaryByParentId")
    Collection<OaDictionaryEntity> getOaDictionariesById() {
        return oaDictionariesById;
    }

    void setOaDictionariesById(Collection<OaDictionaryEntity> oaDictionariesById) {
        this.oaDictionariesById = oaDictionariesById;
    }

    private Collection<OaDictionaryValueEntity> oaDictionaryValuesById;

    @OneToMany(mappedBy = "oaDictionaryByDictionaryId")
    Collection<OaDictionaryValueEntity> getOaDictionaryValuesById() {
        return oaDictionaryValuesById;
    }

    void setOaDictionaryValuesById(Collection<OaDictionaryValueEntity> oaDictionaryValuesById) {
        this.oaDictionaryValuesById = oaDictionaryValuesById;
    }
}
