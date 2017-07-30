package com.francisco.kazoku.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.francisco.kazoku.servicios.dto.ConfiguracionDto;
import com.francisco.kazoku.servicios.interfaces.ConfiguracionServiceI;
import com.francisco.kazoku.servicios.interfaces.PrediccionClimaServiceI;

@Controller
@RequestMapping(value = "/")
public class InicioController{
    
    @Value("${app.web.inicio}")
    private String webInicio;
    
    @Autowired
    ConfiguracionServiceI confService;
    
    @Autowired
    PrediccionClimaServiceI prediccionService;
    
    
    /**
     * Carga de la página inicial de la aplicación
     * 
     * @param session
     * @param model
     * @return
     */
    @RequestMapping
    public ModelAndView inicio(final HttpSession sesion, final ModelMap model){
        ConfiguracionDto config = getConfiguracion(sesion);
        model.addAttribute("prediccionActual", prediccionService.getPrediccionActual(
                config.getIdCiudad(), 
                config.getUnidadesMedida(), 
                config.getClimaApiId()));
        model.addAttribute("predicciones", prediccionService.getPredicciones(
                config.getIdCiudad(), 
                config.getUnidadesMedida(), 
                config.getClimaApiId(), 
                config.getClimaNumeroDias()).getPredicciones());
        return new ModelAndView(webInicio, "model", model);
    }
    
    /**
     * Comprueba si estan los datos de la configuración en la sesión y si no lo están les recupera de la
     * base de datos y les guarda en la sesión
     * 
     * @param sesion
     * @return Objeto ConfiguracionDto
     */
    public ConfiguracionDto getConfiguracion(HttpSession sesion){
        ConfiguracionDto config = sesion.getAttribute("config")!=null?(ConfiguracionDto)sesion.getAttribute("config"):null;
        if(config==null){
            config = confService.getConfiguracion();
            sesion.setAttribute("config", config);
        }
        return config;
    }
    
}
