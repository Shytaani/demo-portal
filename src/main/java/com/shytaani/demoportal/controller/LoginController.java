package com.shytaani.demoportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    
    @PostMapping("/")
    public ModelAndView login() {
        return new ModelAndView();
    }
}
