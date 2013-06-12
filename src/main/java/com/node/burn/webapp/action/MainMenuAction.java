package com.node.burn.webapp.action;

import com.opensymphony.xwork2.ActionContext;
import net.sf.navigator.menu.MenuRepository;
import org.apache.struts2.ServletActionContext;

import javax.servlet.jsp.PageContext;

/**
 * Created with IntelliJ IDEA.
 * User: linfeng at Administrator
 * Date: 13-6-12
 * Time: 下午8:06
 * To change this template use File | Settings | File Templates.
 */
public class MainMenuAction extends BaseAction {

    public String init() {
        MenuRepository menuRepository = (MenuRepository)getRequest().getSession().getAttribute("repository");
        ActionContext actionContext = ActionContext.getContext();
        getRequest().setAttribute("menuRepository", menuRepository);
        getRequest().setAttribute("test", "-----------------------------");
        return SUCCESS;
    }

}
