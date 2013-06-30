package com.node.burn.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_dictionary_value", schema = "", catalog = "eduoa")
@Entity
public class OaDictionaryValueEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String dictLabel;

    @javax.persistence.Column(name = "dict_label")
    @Basic
    String getDictLabel() {
        return dictLabel;
    }

    void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    private String dictValue;

    @javax.persistence.Column(name = "dict_value")
    @Basic
    String getDictValue() {
        return dictValue;
    }

    void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaDictionaryValueEntity that = (OaDictionaryValueEntity) o;

        if (id != that.id) return false;
        if (dictLabel != null ? !dictLabel.equals(that.dictLabel) : that.dictLabel != null) return false;
        if (dictValue != null ? !dictValue.equals(that.dictValue) : that.dictValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (dictLabel != null ? dictLabel.hashCode() : 0);
        result = 31 * result + (dictValue != null ? dictValue.hashCode() : 0);
        return result;
    }

    private OaDictionaryEntity oaDictionaryByDictionaryId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "dictionary_id", referencedColumnName = "id")
    OaDictionaryEntity getOaDictionaryByDictionaryId() {
        return oaDictionaryByDictionaryId;
    }

    void setOaDictionaryByDictionaryId(OaDictionaryEntity oaDictionaryByDictionaryId) {
        this.oaDictionaryByDictionaryId = oaDictionaryByDictionaryId;
    }
}
