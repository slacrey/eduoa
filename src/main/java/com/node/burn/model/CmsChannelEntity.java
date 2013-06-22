package com.node.burn.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "cms_channel", catalog = "eduoa")
@Entity
public class CmsChannelEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String channelName;

    @javax.persistence.Column(name = "channel_name")
    @Basic
    String getChannelName() {
        return channelName;
    }

    void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    private Integer channelSort;

    @javax.persistence.Column(name = "channel_sort")
    @Basic
    Integer getChannelSort() {
        return channelSort;
    }

    void setChannelSort(Integer channelSort) {
        this.channelSort = channelSort;
    }

    private String channelUrl;

    @javax.persistence.Column(name = "channel_url")
    @Basic
    String getChannelUrl() {
        return channelUrl;
    }

    void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
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
    Collection<CmsArticleEntity> getCmsArticlesById() {
        return cmsArticlesById;
    }

    void setCmsArticlesById(Collection<CmsArticleEntity> cmsArticlesById) {
        this.cmsArticlesById = cmsArticlesById;
    }
}
