package com.node.burn.model;

import com.node.burn.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "sys_menu_item", catalog = "eduoa")
@Indexed
@XmlRootElement
public class MenuItem extends BaseObject implements Serializable {
    private Long id;
    private String name;
    private String title;
    private String description;
    private String location;
    private String target;
    private String onclick;
    private String onmouseover;
    private String onmouseout;
    private String image;
    private String altImage;
    private String tooltip;
    private String roles;
    private String page;
    private String width;
    private String height;
    private String forward;
    private String action;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 30)
    @Field
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "title", length = 30)
    @Field
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", length = 50)
    @Field
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "location")
    @Field
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "target", length = 10)
    @Field
    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Column(name = "onclick", length = 100)
    @Field
    public String getOnclick() {
        return this.onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    @Column(name = "onmouseover", length = 100)
    @Field
    public String getOnmouseover() {
        return this.onmouseover;
    }

    public void setOnmouseover(String onmouseover) {
        this.onmouseover = onmouseover;
    }

    @Column(name = "onmouseout", length = 100)
    @Field
    public String getOnmouseout() {
        return this.onmouseout;
    }

    public void setOnmouseout(String onmouseout) {
        this.onmouseout = onmouseout;
    }

    @Column(name = "image", length = 50)
    @Field
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "altImage", length = 30)
    @Field
    public String getAltImage() {
        return this.altImage;
    }

    public void setAltImage(String altImage) {
        this.altImage = altImage;
    }

    @Column(name = "tooltip", length = 100)
    @Field
    public String getTooltip() {
        return this.tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    @Column(name = "roles", length = 100)
    @Field
    public String getRoles() {
        return this.roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Column(name = "page")
    @Field
    public String getPage() {
        return this.page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Column(name = "width", length = 5)
    @Field
    public String getWidth() {
        return this.width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @Column(name = "height", length = 5)
    @Field
    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Column(name = "forward", length = 50)
    @Field
    public String getForward() {
        return this.forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    @Column(name = "action", length = 50)
    @Field
    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem pojo = (MenuItem) o;

        if (name != null ? !name.equals(pojo.name) : pojo.name != null) return false;
        if (title != null ? !title.equals(pojo.title) : pojo.title != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (location != null ? !location.equals(pojo.location) : pojo.location != null) return false;
        if (target != null ? !target.equals(pojo.target) : pojo.target != null) return false;
        if (onclick != null ? !onclick.equals(pojo.onclick) : pojo.onclick != null) return false;
        if (onmouseover != null ? !onmouseover.equals(pojo.onmouseover) : pojo.onmouseover != null) return false;
        if (onmouseout != null ? !onmouseout.equals(pojo.onmouseout) : pojo.onmouseout != null) return false;
        if (image != null ? !image.equals(pojo.image) : pojo.image != null) return false;
        if (altImage != null ? !altImage.equals(pojo.altImage) : pojo.altImage != null) return false;
        if (tooltip != null ? !tooltip.equals(pojo.tooltip) : pojo.tooltip != null) return false;
        if (roles != null ? !roles.equals(pojo.roles) : pojo.roles != null) return false;
        if (page != null ? !page.equals(pojo.page) : pojo.page != null) return false;
        if (width != null ? !width.equals(pojo.width) : pojo.width != null) return false;
        if (height != null ? !height.equals(pojo.height) : pojo.height != null) return false;
        if (forward != null ? !forward.equals(pojo.forward) : pojo.forward != null) return false;
        if (action != null ? !action.equals(pojo.action) : pojo.action != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
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

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("name").append("='").append(getName()).append("', ");
        sb.append("title").append("='").append(getTitle()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("location").append("='").append(getLocation()).append("', ");
        sb.append("target").append("='").append(getTarget()).append("', ");
        sb.append("onclick").append("='").append(getOnclick()).append("', ");
        sb.append("onmouseover").append("='").append(getOnmouseover()).append("', ");
        sb.append("onmouseout").append("='").append(getOnmouseout()).append("', ");
        sb.append("image").append("='").append(getImage()).append("', ");
        sb.append("altImage").append("='").append(getAltImage()).append("', ");
        sb.append("tooltip").append("='").append(getTooltip()).append("', ");
        sb.append("roles").append("='").append(getRoles()).append("', ");
        sb.append("page").append("='").append(getPage()).append("', ");
        sb.append("width").append("='").append(getWidth()).append("', ");
        sb.append("height").append("='").append(getHeight()).append("', ");
        sb.append("forward").append("='").append(getForward()).append("', ");
        sb.append("action").append("='").append(getAction()).append("'");
        sb.append("]");

        return sb.toString();
    }

    private MenuItem parentMenuItem;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = MenuItem.class)
    @javax.persistence.JoinColumn(name = "parent_id", referencedColumnName = "id")
    public MenuItem getParentMenuItem() {
        return parentMenuItem;
    }

    public void setParentMenuItem(MenuItem parentMenuItem) {
        this.parentMenuItem = parentMenuItem;
    }

    private Collection<MenuItem> childeanMenuItem;

    @OneToMany(mappedBy = "parentMenuItem")
    public Collection<MenuItem> getChildeanMenuItem() {
        return childeanMenuItem;
    }

    public void setChildeanMenuItem(Collection<MenuItem> childeanMenuItem) {
        this.childeanMenuItem = childeanMenuItem;
    }

}
