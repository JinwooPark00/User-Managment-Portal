package com.ajaxproject.configuration;

import lombok.Builder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("landing-page");
        registry.addViewController("/landing-page").setViewName("landing-page");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/admin/main").setViewName("admin/main");
        registry.addViewController("/user/main").setViewName("user/main");

        registry.addViewController("/login.html");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if (!registry.hasMappingForPattern("/static/**")) {
//            registry.addResourceHandler("/static/**")
//                    .addResourceLocations("/static/");
//        }
//    }

}
