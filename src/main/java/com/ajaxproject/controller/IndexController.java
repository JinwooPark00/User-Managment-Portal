package com.ajaxproject.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    private Log logger = LogFactory.getLog(this.getClass());

    @GetMapping({"/", "landing-page"})
    public ModelAndView index(Authentication authentication) {

        ModelAndView mav = new ModelAndView("landing-page");
        return redirectMainView(mav, authentication);
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(Authentication authentication) {
        ModelAndView mav = new ModelAndView("login");
        return redirectMainView(mav, authentication);
    }

    @GetMapping({"/search"})
    public ModelAndView search() {
        ModelAndView mav = new ModelAndView("search");

        return mav;
    }

    @GetMapping({"/admin/main"})
    public ModelAndView adminMain() {
        ModelAndView mav = new ModelAndView("/admin/main");

        return mav;
    }

    @GetMapping({"/user/main"})
    public ModelAndView userMain() {
        ModelAndView mav = new ModelAndView("/user/main");

        return mav;
    }

    private ModelAndView redirectMainView(ModelAndView mav, Authentication authentication) {
        List<String> authorizedRoles = new ArrayList<>();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return mav;
        } else {
            for (GrantedAuthority role : authentication.getAuthorities()){
                authorizedRoles.add(role.getAuthority());
            }

            if (authorizedRoles.contains("ROLE_ADMIN")){
                logger.info("Redirect to authorized view of admin");
                return new ModelAndView("redirect:/admin/main");
            }
            logger.info("Redirect to authorized view of user");
            return new ModelAndView("redirect:/user/main");
        }
    }
}
