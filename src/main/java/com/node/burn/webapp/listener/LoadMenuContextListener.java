package com.node.burn.webapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.node.burn.service.MenuItemManager;
import com.node.burn.service.impl.MenuItemManagerImpl;
import net.sf.navigator.menu.MenuRepository;
import net.sf.navigator.util.LoadableResourceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LoadMenuContextListener implements ServletContextListener {
    private static Log log = LogFactory.getLog(LoadMenuContextListener.class);
    private ServletContext ctx;

    /** Configuration file for menus */
    private String menuConfig = "/WEB-INF/menu-config.xml";
    @Qualifier("menuItemManager")
    @Autowired
    private MenuItemManager menuItemManager;

    /**
     * Initialization of the Menu Repository.
     */
    public void contextInitialized(ServletContextEvent sce) {
        ctx = sce.getServletContext();

        if (log.isDebugEnabled()) {
            log.debug("Starting struts-menu initialization");
        }
        
        // check for menuConfigLocation context-param
        String override = 
            sce.getServletContext().getInitParameter("menuConfigLocation");
        if (override != null) {
            if (log.isDebugEnabled()) {
                log.debug("using menuConfigLocation: " + override);
            }
            this.menuConfig = override;
        }
        
        MenuRepository repository = new MenuRepository();
        repository.setLoadParam(menuConfig);
        repository.setServletContext(ctx);

        try {
            repository.load();
            ctx.setAttribute(MenuRepository.MENU_REPOSITORY_KEY, repository);

            if (log.isDebugEnabled()) {
                log.debug("struts-menu initialization successfull");
            }
        } catch (LoadableResourceException lre) {
            log.fatal("Failure initializing struts-menu: " + lre.getMessage());
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        if (log.isDebugEnabled()) {
            log.debug("destroying struts-menu...");
        }

        sce.getServletContext().removeAttribute(MenuRepository.MENU_REPOSITORY_KEY);
        menuConfig = null;
        ctx = null;
    }
}