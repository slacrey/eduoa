package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "cms_channel", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class CmsChannelEntity extends BaseObject implements Serializable {
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

    private String channelName;

    @javax.persistence.Column(name = "channel_name")
    @Basic
    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    private Integer channelSort;

    @javax.persistence.Column(name = "channel_sort")
    @Basic
    public Integer getChannelSort() {
        return channelSort;
    }

    public void setChannelSort(Integer channelSort) {
        this.channelSort = channelSort;
    }

    private String channelUrl;

    @javax.persistence.Column(name = "channel_url")
    @Basic
    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CmsChannelEntity that = (CmsChannelEntity) o;

        if (id != that.id) return false;
        if (channelName != null ? !channelName.equals(that.channelName) : that.channelName != null) return false;
        if (channelSort != null ? !channelSort.equals(that.channelSort) : that.channelSort != null) return false;
        if (channelUrl != null ? !channelUrl.equals(that.channelUrl) : that.channelUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (channelName != null ? channelName.hashCode() : 0);
        result = 31 * result + (channelSort != null ? channelSort.hashCode() : 0);
        result = 31 * result + (channelUrl != null ? channelUrl.hashCode() : 0);
        return result;
    }

    private Collection<CmsArticleEntity> cmsArticlesById;

    @OneToMany(mappedBy = "cmsChannelByChannelId")
    public Collection<CmsArticleEntity> getCmsArticlesById() {
        return cmsArticlesById;
    }

    public void setCmsArticlesById(Collection<CmsArticleEntity> cmsArticlesById) {
        this.cmsArticlesById = cmsArticlesById;
    }
}
