package com.tms.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SecurController {

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/bye")
    public String getByePage(Principal principal){
        System.out.println(principal.getName()); //Пользователь
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName()); //Пользователь
        return "bye";
    }

    @GetMapping("/hello")
    public String getHelloPage(){
        return "hello";
    }

    @GetMapping
    public String getHomeAlsoPage(){
        return "home";
    }
}
