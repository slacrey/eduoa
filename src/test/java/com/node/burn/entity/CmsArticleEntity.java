package com.node.burn.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "cms_article", schema = "", catalog = "eduoa")
@Entity
public class CmsArticleEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private Long articleClassId;

    @javax.persistence.Column(name = "article_class_id")
    @Basic
    Long getArticleClassId() {
        return articleClassId;
    }

    void setArticleClassId(Long articleClassId) {
        this.articleClassId = articleClassId;
    }

    private String title;

    @javax.persistence.Column(name = "title")
    @Basic
    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    private String summary;

    @javax.persistence.Column(name = "summary")
    @Basic
    String getSummary() {
        return summary;
    }

    void setSummary(String summary) {
        this.summary = summary;
    }

    private String content;

    @javax.persistence.Column(name = "content")
    @Basic
    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    private Integer hits;

    @javax.persistence.Column(name = "hits")
    @Basic
    Integer getHits() {
        return hits;
    }

    void setHits(Integer hits) {
        this.hits = hits;
    }

    private Date createTime;

    @javax.persistence.Column(name = "create_time")
    @Basic
    Date getCreateTime() {
        return createTime;
    }

    void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Long createUserId;

    @javax.persistence.Column(name = "create_user_id")
    @Basic
    Long getCreateUserId() {
        return createUserId;
    }

    void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    private Date updateTime;

    @javax.persistence.Column(name = "update_time")
    @Basic
    Date getUpdateTime() {
        return updateTime;
    }

    void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private Long updateUserId;

    @javax.persistence.Column(name = "update_user_id")
    @Basic
    Long getUpdateUserId() {
        return updateUserId;
    }

    void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    private Integer articleState;

    @javax.persistence.Column(name = "article_state")
    @Basic
    Integer getArticleState() {
        return articleState;
    }

    void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CmsArticleEntity that = (CmsArticleEntity) o;

        if (id != that.id) return false;
        if (articleClassId != null ? !articleClassId.equals(that.articleClassId) : that.articleClassId != null)
            return false;
        if (articleState != null ? !articleState.equals(that.articleState) : that.articleState != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (hits != null ? !hits.equals(that.hits) : that.hits != null) return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateUserId != null ? !updateUserId.equals(that.updateUserId) : that.updateUserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (articleClassId != null ? articleClassId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (hits != null ? hits.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (articleState != null ? articleState.hashCode() : 0);
        return result;
    }

    private CmsChannelEntity cmsChannelByChannelId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "channel_id", referencedColumnName = "id")
    CmsChannelEntity getCmsChannelByChannelId() {
        return cmsChannelByChannelId;
    }

    void setCmsChannelByChannelId(CmsChannelEntity cmsChannelByChannelId) {
        this.cmsChannelByChannelId = cmsChannelByChannelId;
    }

    private Collection<CmsArticleTeacherEntity> cmsArticleTeachersById;

    @OneToMany(mappedBy = "cmsArticleByArticleId")
    Collection<CmsArticleTeacherEntity> getCmsArticleTeachersById() {
        return cmsArticleTeachersById;
    }

    void setCmsArticleTeachersById(Collection<CmsArticleTeacherEntity> cmsArticleTeachersById) {
        this.cmsArticleTeachersById = cmsArticleTeachersById;
    }
}
