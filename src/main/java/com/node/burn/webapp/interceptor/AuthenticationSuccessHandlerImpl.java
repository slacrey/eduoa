package com.node.burn.webapp.interceptor;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * User: Administrator
 * Date: 13-6-10
 * Time: 下午12:17
 * To change this template use File | Settings | File Templates.
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {



    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        Object savedRequestObject = httpServletRequest.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        System.out.printf("+++++++++++++++++++++++++++++++++++++++"+savedRequestObject.toString());
        if(savedRequestObject != null) {
            String redirectUrl = ((SavedRequest)savedRequestObject).getRedirectUrl();
            String[] url = redirectUrl.split("\\.");
            System.out.printf("+++++++++++++++++++++++++++++++++++++++"+redirectUrl);
            httpServletRequest.getSession().removeAttribute("SPRING_SECURITY_SAVED_REQUEST");
            httpServletResponse.sendRedirect(url[0]);
        }
    }
}
