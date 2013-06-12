package com.node.burn.webapp.interceptor;

import com.node.burn.model.MenuItem;
import com.node.burn.service.MenuItemManager;
import com.node.burn.service.impl.MenuItemManagerImpl;
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
import java.util.List;

/**
 * User: Administrator
 * Date: 13-6-10
 * Time: 下午12:17
 * To change this template use File | Settings | File Templates.
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {


    @Qualifier("menuItemManager")
    @Autowired
    private MenuItemManager menuItemManager;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Object savedRequestObject = request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        if (savedRequestObject != null) {
            String redirectUrl = ((SavedRequest) savedRequestObject).getRedirectUrl();
            String[] url = redirectUrl.split("\\.");
            if (initMenuItem(request)) {
                request.getSession().removeAttribute("SPRING_SECURITY_SAVED_REQUEST");
                response.sendRedirect(url[0]);
            } else {

            }
        }
    }

    private Boolean initMenuItem(HttpServletRequest request) {

        List<MenuItem> menuItems = menuItemManager.getAll();
        if (menuItems != null && !menuItems.isEmpty()) {
            MenuRepository repository = new MenuRepository();
            HttpSession httpSession = (HttpSession) request.getSession();
            ServletContext application = (ServletContext) httpSession.getServletContext();
            MenuRepository defaultRepository = (MenuRepository) application.getAttribute(MenuRepository.MENU_REPOSITORY_KEY);
            repository.setDisplayers(defaultRepository.getDisplayers());
            for (MenuItem menuItem: menuItems) {
                MenuComponent menuComponent = new MenuComponent();
                menuComponent.setName(menuItem.getName());
                MenuItem parent = menuItem.getParentMenuItem();
                if (parent != null) {
                    MenuComponent parentMenu = repository.getMenu(parent.getName());
                    if (parentMenu == null) {
                        parentMenu = new MenuComponent();
                        parentMenu.setName(parent.getName());
                        repository.addMenu(parentMenu);
                    }
                    menuComponent.setParent(parentMenu);
                }
                menuComponent.setTitle(menuItem.getTitle());
                menuComponent.setLocation(menuItem.getLocation());
                menuComponent.setRoles(menuItem.getRoles());
                menuComponent.setPage(menuItem.getPage());
                repository.addMenu(menuComponent);
            }
            request.getSession().setAttribute("repository", repository);
            return true;
        } else {
            return false;
        }

    }
}
