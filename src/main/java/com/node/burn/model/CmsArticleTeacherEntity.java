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
@Table(name = "cms_article_teacher")
@Entity
public class CmsArticleTeacherEntity extends BaseObject implements Serializable {
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

    private String teacherName;

    @Column(name = "teacher_name")
    @Basic
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    private String photoUrl;

    @Column(name = "photo_url")
    @Basic
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    private Long attachmentId;

    @Column(name = "attachment_id")
    @Basic
    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.getTeacherName())
                .toString();
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
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public SysAttachmentEntity getSysAttachmentById() {
        return sysAttachmentById;
    }

    public void setSysAttachmentById(SysAttachmentEntity sysAttachmentById) {
        this.sysAttachmentById = sysAttachmentById;
    }

    private CmsArticleEntity cmsArticleByArticleId;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    public CmsArticleEntity getCmsArticleByArticleId() {
        return cmsArticleByArticleId;
    }

    public void setCmsArticleByArticleId(CmsArticleEntity cmsArticleByArticleId) {
        this.cmsArticleByArticleId = cmsArticleByArticleId;
    }
}
