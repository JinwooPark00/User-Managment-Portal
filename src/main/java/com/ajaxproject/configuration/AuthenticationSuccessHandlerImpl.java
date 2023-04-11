package com.ajaxproject.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    protected Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        handle(request, response, authentication);
    }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String redirectUrl = determineUrl(authentication);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect");
            return;
        }

        redirectStrategy.sendRedirect(request, response, redirectUrl);
    }

    protected String determineUrl(Authentication authentication) {
        List<String> authorizedRoles = new ArrayList();

        for (GrantedAuthority role : authentication.getAuthorities()){
            authorizedRoles.add(role.getAuthority());
        }

        if (authorizedRoles.contains("ROLE_ADMIN")){
            logger.info("Redirect to authorized view of admin");
            return "/search";
        }
        logger.info("Redirect to authorized view of user");
        return "/home";
    }
}
