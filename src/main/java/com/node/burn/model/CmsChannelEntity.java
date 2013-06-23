package com.node.burn.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * SysUserEntity: linfeng at Administrator
 * Date: 13-6-21
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "cms_channel")
@Entity
public class CmsChannelEntity extends BaseObject implements Serializable {
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

    private String channelName;

    @Column(name = "channel_name")
    @Basic
    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    private Integer channelSort;

    @Column(name = "channel_sort")
    @Basic
    public Integer getChannelSort() {
        return channelSort;
    }

    public void setChannelSort(Integer channelSort) {
        this.channelSort = channelSort;
    }

    private String channelUrl;

    @Column(name = "channel_url")
    @Basic
    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.channelName)
                .toString();
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
