package com.node.burn.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "sys_attachment", schema = "", catalog = "eduoa")
@Entity
public class SysAttachmentEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String fileName;

    @javax.persistence.Column(name = "file_name")
    @Basic
    String getFileName() {
        return fileName;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileExt;

    @javax.persistence.Column(name = "file_ext")
    @Basic
    String getFileExt() {
        return fileExt;
    }

    void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    private Integer fileSize;

    @javax.persistence.Column(name = "file_size")
    @Basic
    Integer getFileSize() {
        return fileSize;
    }

    void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    private String serviceFile;

    @javax.persistence.Column(name = "service_file")
    @Basic
    String getServiceFile() {
        return serviceFile;
    }

    void setServiceFile(String serviceFile) {
        this.serviceFile = serviceFile;
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

    private Long userId;

    @javax.persistence.Column(name = "user_id")
    @Basic
    Long getUserId() {
        return userId;
    }

    void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysAttachmentEntity that = (SysAttachmentEntity) o;

        if (id != that.id) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (fileExt != null ? !fileExt.equals(that.fileExt) : that.fileExt != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (fileSize != null ? !fileSize.equals(that.fileSize) : that.fileSize != null) return false;
        if (serviceFile != null ? !serviceFile.equals(that.serviceFile) : that.serviceFile != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (fileExt != null ? fileExt.hashCode() : 0);
        result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
        result = 31 * result + (serviceFile != null ? serviceFile.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    private CmsArticleTeacherEntity cmsArticleTeacherById;

    @OneToOne(mappedBy = "sysAttachmentById")
    CmsArticleTeacherEntity getCmsArticleTeacherById() {
        return cmsArticleTeacherById;
    }

    void setCmsArticleTeacherById(CmsArticleTeacherEntity cmsArticleTeacherById) {
        this.cmsArticleTeacherById = cmsArticleTeacherById;
    }

    private Collection<OaOrganizationalStructureEntity> oaOrganizationalStructuresById;

    @OneToMany(mappedBy = "sysAttachmentByAttachmentId")
    Collection<OaOrganizationalStructureEntity> getOaOrganizationalStructuresById() {
        return oaOrganizationalStructuresById;
    }

    void setOaOrganizationalStructuresById(Collection<OaOrganizationalStructureEntity> oaOrganizationalStructuresById) {
        this.oaOrganizationalStructuresById = oaOrganizationalStructuresById;
    }
}
