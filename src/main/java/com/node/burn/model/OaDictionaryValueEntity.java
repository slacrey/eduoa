package com.node.burn.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "oa_dictionary_value")
@Entity
public class OaDictionaryValueEntity extends BaseObject implements Serializable {
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

    private String dictLabel;

    @Column(name = "dict_label")
    @Basic
    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    private String dictValue;

    @Column(name = "dict_value")
    @Basic
    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.dictLabel)
                .toString();
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
    @JoinColumn(name = "dictionary_id", referencedColumnName = "id")
    public OaDictionaryEntity getOaDictionaryByDictionaryId() {
        return oaDictionaryByDictionaryId;
    }

    public void setOaDictionaryByDictionaryId(OaDictionaryEntity oaDictionaryByDictionaryId) {
        this.oaDictionaryByDictionaryId = oaDictionaryByDictionaryId;
    }
}
