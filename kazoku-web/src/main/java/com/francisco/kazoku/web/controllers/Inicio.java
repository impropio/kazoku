package com.francisco.kazoku.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class Inicio{
    
    @Value("${app.web.inicio}")
    private String webInicio;
    
    @RequestMapping
    public ModelAndView masterLogin(final HttpSession session, final ModelMap model){
        return new ModelAndView(webInicio);
    }
    
}
