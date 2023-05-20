package com.ajaxproject.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @GetMapping({"/", "landing-page"})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("landing-page");

        return mav;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
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

}
