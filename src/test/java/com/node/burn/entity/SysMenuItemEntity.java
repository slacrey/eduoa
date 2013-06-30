package com.node.burn.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "sys_menu_item", schema = "", catalog = "eduoa")
@Entity
public class SysMenuItemEntity {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    private String name;

    @javax.persistence.Column(name = "name")
    @Basic
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
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

    private String description;

    @javax.persistence.Column(name = "description")
    @Basic
    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    private String location;

    @javax.persistence.Column(name = "location")
    @Basic
    String getLocation() {
        return location;
    }

    void setLocation(String location) {
        this.location = location;
    }

    private String target;

    @javax.persistence.Column(name = "target")
    @Basic
    String getTarget() {
        return target;
    }

    void setTarget(String target) {
        this.target = target;
    }

    private String onclick;

    @javax.persistence.Column(name = "onclick")
    @Basic
    String getOnclick() {
        return onclick;
    }

    void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    private String onmouseover;

    @javax.persistence.Column(name = "onmouseover")
    @Basic
    String getOnmouseover() {
        return onmouseover;
    }

    void setOnmouseover(String onmouseover) {
        this.onmouseover = onmouseover;
    }

    private String onmouseout;

    @javax.persistence.Column(name = "onmouseout")
    @Basic
    String getOnmouseout() {
        return onmouseout;
    }

    void setOnmouseout(String onmouseout) {
        this.onmouseout = onmouseout;
    }

    private String image;

    @javax.persistence.Column(name = "image")
    @Basic
    String getImage() {
        return image;
    }

    void setImage(String image) {
        this.image = image;
    }

    private String altImage;

    @javax.persistence.Column(name = "alt_image")
    @Basic
    String getAltImage() {
        return altImage;
    }

    void setAltImage(String altImage) {
        this.altImage = altImage;
    }

    private String tooltip;

    @javax.persistence.Column(name = "tooltip")
    @Basic
    String getTooltip() {
        return tooltip;
    }

    void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    private String roles;

    @javax.persistence.Column(name = "roles")
    @Basic
    String getRoles() {
        return roles;
    }

    void setRoles(String roles) {
        this.roles = roles;
    }

    private String page;

    @javax.persistence.Column(name = "page")
    @Basic
    String getPage() {
        return page;
    }

    void setPage(String page) {
        this.page = page;
    }

    private String width;

    @javax.persistence.Column(name = "width")
    @Basic
    String getWidth() {
        return width;
    }

    void setWidth(String width) {
        this.width = width;
    }

    private String height;

    @javax.persistence.Column(name = "height")
    @Basic
    String getHeight() {
        return height;
    }

    void setHeight(String height) {
        this.height = height;
    }

    private String forward;

    @javax.persistence.Column(name = "forward")
    @Basic
    String getForward() {
        return forward;
    }

    void setForward(String forward) {
        this.forward = forward;
    }

    private String action;

    @javax.persistence.Column(name = "action")
    @Basic
    String getAction() {
        return action;
    }

    void setAction(String action) {
        this.action = action;
    }

    private String menuOrder;

    @javax.persistence.Column(name = "menu_order")
    @Basic
    String getMenuOrder() {
        return menuOrder;
    }

    void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysMenuItemEntity that = (SysMenuItemEntity) o;

        if (id != that.id) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (altImage != null ? !altImage.equals(that.altImage) : that.altImage != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (forward != null ? !forward.equals(that.forward) : that.forward != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (menuOrder != null ? !menuOrder.equals(that.menuOrder) : that.menuOrder != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (onclick != null ? !onclick.equals(that.onclick) : that.onclick != null) return false;
        if (onmouseout != null ? !onmouseout.equals(that.onmouseout) : that.onmouseout != null) return false;
        if (onmouseover != null ? !onmouseover.equals(that.onmouseover) : that.onmouseover != null) return false;
        if (page != null ? !page.equals(that.page) : that.page != null) return false;
        if (roles != null ? !roles.equals(that.roles) : that.roles != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (tooltip != null ? !tooltip.equals(that.tooltip) : that.tooltip != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (onclick != null ? onclick.hashCode() : 0);
        result = 31 * result + (onmouseover != null ? onmouseover.hashCode() : 0);
        result = 31 * result + (onmouseout != null ? onmouseout.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (altImage != null ? altImage.hashCode() : 0);
        result = 31 * result + (tooltip != null ? tooltip.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (page != null ? page.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (forward != null ? forward.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (menuOrder != null ? menuOrder.hashCode() : 0);
        return result;
    }

    private SysMenuItemEntity sysMenuItemByParentId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "parent_id", referencedColumnName = "id")
    SysMenuItemEntity getSysMenuItemByParentId() {
        return sysMenuItemByParentId;
    }

    void setSysMenuItemByParentId(SysMenuItemEntity sysMenuItemByParentId) {
        this.sysMenuItemByParentId = sysMenuItemByParentId;
    }

    private Collection<SysMenuItemEntity> sysMenuItemsById;

    @OneToMany(mappedBy = "sysMenuItemByParentId")
    Collection<SysMenuItemEntity> getSysMenuItemsById() {
        return sysMenuItemsById;
    }

    void setSysMenuItemsById(Collection<SysMenuItemEntity> sysMenuItemsById) {
        this.sysMenuItemsById = sysMenuItemsById;
    }
}
