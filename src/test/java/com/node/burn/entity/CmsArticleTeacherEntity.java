package com.node.burn.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "cms_article_teacher", schema = "", catalog = "eduoa")
@Entity
public class CmsArticleTeacherEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String teacherName;

    @javax.persistence.Column(name = "teacher_name")
    @Basic
    String getTeacherName() {
        return teacherName;
    }

    void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    private String photoUrl;

    @javax.persistence.Column(name = "photo_url")
    @Basic
    String getPhotoUrl() {
        return photoUrl;
    }

    void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    private Long attachmentId;

    @javax.persistence.Column(name = "attachment_id")
    @Basic
    Long getAttachmentId() {
        return attachmentId;
    }

    void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CmsArticleTeacherEntity that = (CmsArticleTeacherEntity) o;

        if (id != that.id) return false;
        if (attachmentId != null ? !attachmentId.equals(that.attachmentId) : that.attachmentId != null) return false;
        if (photoUrl != null ? !photoUrl.equals(that.photoUrl) : that.photoUrl != null) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
        result = 31 * result + (attachmentId != null ? attachmentId.hashCode() : 0);
        return result;
    }

    private SysAttachmentEntity sysAttachmentById;

    @OneToOne
    @javax.persistence.JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    SysAttachmentEntity getSysAttachmentById() {
        return sysAttachmentById;
    }

    void setSysAttachmentById(SysAttachmentEntity sysAttachmentById) {
        this.sysAttachmentById = sysAttachmentById;
    }

    private CmsArticleEntity cmsArticleByArticleId;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    CmsArticleEntity getCmsArticleByArticleId() {
        return cmsArticleByArticleId;
    }

    void setCmsArticleByArticleId(CmsArticleEntity cmsArticleByArticleId) {
        this.cmsArticleByArticleId = cmsArticleByArticleId;
    }
}
