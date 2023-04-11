package com.ajaxproject.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @GetMapping({"/", "home"})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("home");

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

}
