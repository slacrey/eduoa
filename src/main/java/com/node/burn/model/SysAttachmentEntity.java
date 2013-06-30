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
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "sys_attachment", schema = "", catalog = "eduoa")
@Entity
@Indexed
@XmlRootElement
public class SysAttachmentEntity extends BaseObject implements Serializable {
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

    private String fileName;

    @Column(name = "file_name")
    @Basic
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileExt;

    @Column(name = "file_ext")
    @Basic
    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    private Integer fileSize;

    @Column(name = "file_size")
    @Basic
    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    private String serviceFile;

    @Column(name = "service_file")
    @Basic
    public String getServiceFile() {
        return serviceFile;
    }

    public void setServiceFile(String serviceFile) {
        this.serviceFile = serviceFile;
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

    private Long userId;

    @Column(name = "user_id")
    @Basic
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysAttachmentEntity that = (SysAttachmentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
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
    public CmsArticleTeacherEntity getCmsArticleTeacherById() {
        return cmsArticleTeacherById;
    }

    public void setCmsArticleTeacherById(CmsArticleTeacherEntity cmsArticleTeacherById) {
        this.cmsArticleTeacherById = cmsArticleTeacherById;
    }

    private Collection<OaOrganizationalStructureEntity> oaOrganizationalStructuresById;

    @OneToMany(mappedBy = "sysAttachmentByAttachmentId")
    public Collection<OaOrganizationalStructureEntity> getOaOrganizationalStructuresById() {
        return oaOrganizationalStructuresById;
    }

    void setOaOrganizationalStructuresById(Collection<OaOrganizationalStructureEntity> oaOrganizationalStructuresById) {
        this.oaOrganizationalStructuresById = oaOrganizationalStructuresById;
    }
}
