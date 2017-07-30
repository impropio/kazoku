package com.francisco.kazoku.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.francisco.kazoku.servicios.dto.ConfiguracionDto;
import com.francisco.kazoku.servicios.interfaces.CiudadServiceI;
import com.francisco.kazoku.servicios.interfaces.ConfiguracionServiceI;
import com.francisco.kazoku.servicios.interfaces.MedidasServiceI;
import com.francisco.kazoku.servicios.interfaces.PaisServiceI;

@Controller
@RequestMapping(value = "/configuracion")
public class ConfiguracionController{
    
    @Autowired
    ConfiguracionServiceI confService;
    
    @Autowired
    MedidasServiceI medidasService;
    
    @Autowired
    PaisServiceI paisService;
    
    @Autowired
    CiudadServiceI ciudadService;
    
    /**
     * Carga de la pantalla de configuración
     * 
     * @param session
     * @param model
     * @return
     */
    @RequestMapping
    public ModelAndView configuracion(final HttpSession sesion, final ModelMap model){
        ConfiguracionDto conf = getConfiguracion(sesion);
        model.addAttribute("configuracion", conf);
        model.addAttribute("medidas", medidasService.getMedidas(conf.getIdioma()));
        model.addAttribute("paises", paisService.getPaises(conf.getIdioma()));
        model.addAttribute("ciudadSeleccionada", ciudadService.getCiudadById(Integer.parseInt(conf.getIdCiudad())));
//        model.addAttribute("ciudades", ciudadService.getCiudadPais(conf.getCodigoPais()));
        model.addAttribute("ciudades", ciudadService.getCiudadesPaisTextoLimite(conf.getCodigoPais(), "san", 10));
        return new ModelAndView("config", "model", model);
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
