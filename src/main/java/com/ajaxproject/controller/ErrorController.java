package com.ajaxproject.controller;

import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ErrorController {

    @GetMapping("/403")
    public ModelAndView error403 (){
        ModelAndView mav = new ModelAndView("/errors/403");

        return mav;
    }
}
