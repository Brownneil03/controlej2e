package com.example.controle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @GetMapping({"/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }
} 