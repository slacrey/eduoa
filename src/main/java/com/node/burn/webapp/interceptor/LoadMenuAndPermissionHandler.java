package com.node.burn.webapp.interceptor;

import com.node.burn.model.SysMenuItemEntity;
import com.node.burn.service.MenuItemManager;
import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * SysUserEntity: linfeng
 * Date: 13-6-10
 * Time: 下午12:17
 * To change this template use File | Settings | File Templates.
 */
public class LoadMenuAndPermissionHandler implements AuthenticationSuccessHandler {


    @Qualifier("menuItemManager")
    @Autowired
    private MenuItemManager menuItemManager;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Object savedRequestObject = request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        if (savedRequestObject != null) {
            String referer = request.getHeader("Referer");
            String redirectUrl = ((SavedRequest) savedRequestObject).getRedirectUrl();
            String[] url = redirectUrl.split("\\.");
            if (initMenuItem(request)) {
                request.getSession().removeAttribute("SPRING_SECURITY_SAVED_REQUEST");
                response.sendRedirect(url[0]);
            } else {
                response.sendRedirect(referer);
            }
        }
    }

    private MenuComponent[] initChildrenMenu(MenuComponent parentMenuItem, Collection<SysMenuItemEntity> menuItems) {
        MenuComponent[] menuComponents = new MenuComponent[menuItems.size()];
        List<MenuComponent> menuComponentList = new ArrayList<MenuComponent>();
        for (SysMenuItemEntity menuItem: menuItems) {
            MenuComponent menuComponent = new MenuComponent();
            menuComponent.setName(menuItem.getName());
            menuComponent.setParent(parentMenuItem);
            Collection<SysMenuItemEntity> childeanMenuItem = menuItem.getChildeanMenuItem();
            if (childeanMenuItem != null && !childeanMenuItem.isEmpty()) {
                initChildrenMenu(menuComponent, childeanMenuItem);
            }
            menuComponent.setTitle(menuItem.getTitle());
            menuComponent.setLocation(menuItem.getLocation());
            menuComponent.setRoles(menuItem.getRoles());
            menuComponent.setPage(menuItem.getPage());
            menuComponentList.add(menuComponent);
        }
        return menuComponentList.toArray(menuComponents);
    }

    private Boolean initMenuItem(HttpServletRequest request) {

        List<SysMenuItemEntity> menuItems = menuItemManager.findTopMenuItems();
        if (menuItems != null && !menuItems.isEmpty()) {
            MenuRepository repository = new MenuRepository();
            HttpSession httpSession = (HttpSession) request.getSession();
            ServletContext application = (ServletContext) httpSession.getServletContext();
            MenuRepository defaultRepository = (MenuRepository) application.getAttribute(MenuRepository.MENU_REPOSITORY_KEY);
            repository.setDisplayers(defaultRepository.getDisplayers());
            for (SysMenuItemEntity menuItem: menuItems) {
                MenuComponent menuComponent = new MenuComponent();
                menuComponent.setName(menuItem.getName());
                Collection<SysMenuItemEntity> childeanMenuItem = menuItem.getChildeanMenuItem();
                if (childeanMenuItem != null && !childeanMenuItem.isEmpty()) {
                    initChildrenMenu(menuComponent, childeanMenuItem);
                }
                String title = menuItem.getTitle();
                if (title == null || "".equals(title)) {
                    title = null;
                }
                menuComponent.setTitle(title);
                String location = menuItem.getLocation();
                if (location == null || "".equals(location)) {
                    location = null;
                }
                menuComponent.setLocation(location);
                String roles = menuItem.getRoles();
                if (roles == null || "".equals(roles)) {
                    roles = null;
                }
                menuComponent.setRoles(roles);
                String page = menuItem.getPage();
                if (page == null || "".equals(page)) {
                    page = null;
                }
                menuComponent.setPage(menuItem.getPage());
                repository.addMenu(menuComponent);
            }
//            request.getSession().setAttribute(MenuRepository.MENU_REPOSITORY_KEY, repository);
            return true;
        } else {
            return false;
        }

    }
}
