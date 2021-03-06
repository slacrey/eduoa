package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "oa_dictionary_value", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class OaDictionaryValueEntity extends BaseObject implements Serializable {
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

    private String dictLabel;

    @javax.persistence.Column(name = "dict_label")
    @Basic
    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    private String dictValue;

    @javax.persistence.Column(name = "dict_value")
    @Basic
    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaDictionaryValueEntity that = (OaDictionaryValueEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
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
    public OaDictionaryEntity getOaDictionaryByDictionaryId() {
        return oaDictionaryByDictionaryId;
    }

    public void setOaDictionaryByDictionaryId(OaDictionaryEntity oaDictionaryByDictionaryId) {
        this.oaDictionaryByDictionaryId = oaDictionaryByDictionaryId;
    }
}
