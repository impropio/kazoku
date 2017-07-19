package com.francisco.kazoku.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.francisco.kazoku.servicios.interfaces.PrediccionClimaServiceI;

@Controller
@RequestMapping(value = "/")
public class Inicio{
    
    @Value("${app.web.inicio}")
    private String webInicio;
    
    @Autowired
    PrediccionClimaServiceI prediccion;
    
    /**
     * Carga de la página inicial de la aplicación
     * 
     * @param session
     * @param model
     * @return
     */
    @RequestMapping
    public ModelAndView inicio(final HttpSession session, final ModelMap model){
        model.addAttribute("prediccionActual", prediccion.getPrediccionActual());
        model.addAttribute("predicciones", prediccion.getPredicciones().getPredicciones());
        return new ModelAndView(webInicio, "model", model);
    }
    
    /**
     * Carga de la pantalla de configuración
     * 
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value="configuracion", method=RequestMethod.GET)
    public ModelAndView configuracion(final HttpSession session, final ModelMap model){
        return new ModelAndView("config", "model", model);
    }
    
}
