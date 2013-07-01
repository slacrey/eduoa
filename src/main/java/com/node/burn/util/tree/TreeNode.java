package com.node.burn.util.tree;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.List;

/**
 *
 * User: linfeng at Administrator
 * Date: 13-6-30
 * Time: 下午5:15
 * To change this template use File | Settings | File Templates.
 */
@JsonAutoDetect(JsonMethod.NONE)
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class TreeNode<T> implements Serializable {

    private String id;//
    private String name;//节点名
    private Boolean checked;//  checkBox / radio 勾选状态
    private List<TreeNode> children;//子节点数据集合
    private Boolean chkDisabled;//checkbox / radio 是否禁用
    private String click;//click 事件操作
    private Boolean halfCheck;//强行设置为半勾选
    private String icon;//图标图片的 url 可以是相对路径也可以是绝对路径
    private String iconClose;// 图标图片的 url 可以是相对路径也可以是绝对路径
    private String iconOpen;// 图标图片的 url 可以是相对路径也可以是绝对路径
    private String iconSkin;//个性图标的 className
    private Boolean isHidden;//是否被隐藏
    private Boolean isParent;//是否父节点
    private Boolean nocheck;//不显示  checkBox / radio 不影响勾选状态
    private Boolean open;// 展开 / 折叠 状态。
    private String target;//超链接 target 属性: "_blank", "_self" 或 其他指定窗口名称
    private String url;//超链接 href 属性
    private T val;//

    public TreeNode() {
    }

    public TreeNode(String id, String name, Boolean parent) {
        this.id = id;
        this.name = name;
        isParent = parent;
    }

    @JsonSerialize
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonSerialize
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSerialize
    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @JsonIgnore
    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    @JsonSerialize
    public Boolean getChkDisabled() {
        return chkDisabled;
    }

    public void setChkDisabled(Boolean chkDisabled) {
        this.chkDisabled = chkDisabled;
    }

    @JsonSerialize
    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    @JsonSerialize
    public Boolean getHalfCheck() {
        return halfCheck;
    }

    public void setHalfCheck(Boolean halfCheck) {
        this.halfCheck = halfCheck;
    }

    @JsonSerialize
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonSerialize
    public String getIconClose() {
        return iconClose;
    }

    public void setIconClose(String iconClose) {
        this.iconClose = iconClose;
    }

    @JsonSerialize
    public String getIconOpen() {
        return iconOpen;
    }

    public void setIconOpen(String iconOpen) {
        this.iconOpen = iconOpen;
    }

    @JsonSerialize
    public String getIconSkin() {
        return iconSkin;
    }

    public void setIconSkin(String iconSkin) {
        this.iconSkin = iconSkin;
    }

    @JsonSerialize
    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    @JsonSerialize
    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    @JsonSerialize
    public Boolean getNocheck() {
        return nocheck;
    }

    public void setNocheck(Boolean nocheck) {
        this.nocheck = nocheck;
    }

    @JsonSerialize
    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @JsonSerialize
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @JsonSerialize
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

}
