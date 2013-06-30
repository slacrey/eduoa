package com.node.burn.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "cms_article", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class CmsArticleEntity extends BaseObject implements Serializable {
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

    private Long articleClassId;

    @Column(name = "article_class_id")
    @Basic
    public Long getArticleClassId() {
        return articleClassId;
    }

    public void setArticleClassId(Long articleClassId) {
        this.articleClassId = articleClassId;
    }

    private String title;

    @Column(name = "title")
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String summary;

    @Column(name = "summary")
    @Basic
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    private String content;

    @Column(name = "content")
    @Basic
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Integer hits;

    @Column(name = "hits")
    @Basic
    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    private Date createTime;

    @Column(name = "create_time")
    @Basic
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Long createUserId;

    @Column(name = "create_user_id")
    @Basic
    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    private Date updateTime;

    @Column(name = "update_time")
    @Basic
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private Long updateUserId;

    @Column(name = "update_user_id")
    @Basic
    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    private Integer articleState;

    @Column(name = "article_state")
    @Basic
    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    public CmsChannelEntity getCmsChannelByChannelId() {
        return cmsChannelByChannelId;
    }

    public void setCmsChannelByChannelId(CmsChannelEntity cmsChannelByChannelId) {
        this.cmsChannelByChannelId = cmsChannelByChannelId;
    }

    private Collection<CmsArticleTeacherEntity> cmsArticleTeachersById;

    @OneToMany(mappedBy = "cmsArticleByArticleId")
    public Collection<CmsArticleTeacherEntity> getCmsArticleTeachersById() {
        return cmsArticleTeachersById;
    }

    public void setCmsArticleTeachersById(Collection<CmsArticleTeacherEntity> cmsArticleTeachersById) {
        this.cmsArticleTeachersById = cmsArticleTeachersById;
    }
}
