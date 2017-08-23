package com.francisco.kazoku.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.francisco.kazoku.servicios.dto.CiudadDto;
import com.francisco.kazoku.servicios.dto.ConfiguracionDto;
import com.francisco.kazoku.servicios.interfaces.CiudadServiceI;
import com.francisco.kazoku.servicios.interfaces.ConfiguracionServiceI;
import com.francisco.kazoku.servicios.interfaces.MedidasServiceI;
import com.francisco.kazoku.servicios.interfaces.PaisServiceI;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
@Controller
@RequestMapping(value = "/configuracion")
public class ConfiguracionController{
    
    @Value("${ciudades.limite.resultados}")
    private String limiteResultados;
    
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
     * @return ModelAndView
     */
    @RequestMapping
    public ModelAndView configuracion(final HttpSession sesion, final ModelMap model){
        ConfiguracionDto conf = getConfiguracion(sesion);
        model.addAttribute("configuracion", conf);
        model.addAttribute("medidas", medidasService.getMedidas(conf.getIdioma()));
        model.addAttribute("paises", paisService.getPaises(conf.getIdioma()));
        model.addAttribute("ciudadSeleccionada", ciudadService.getCiudadById(Integer.parseInt(conf.getIdCiudad())));
        return new ModelAndView("config", "model", model);
    }
    
    /**
     * Recupera las ciudades de un país que sus palabras comiencen por el texto introducido
     * 
     * @param pais
     * @param texto
     * @return json con la lista de ciudades
     */
    @RequestMapping(value = "/ciudadespais", method = RequestMethod.POST)
    @ResponseBody
    public String getCiudadesPais(@RequestParam("pais") String pais, @RequestParam("ciudad") String texto){
        List<CiudadDto> listaCiudades = new ArrayList<CiudadDto>();
        Gson gson = new Gson();
        listaCiudades = ciudadService.getCiudadesPaisTextoLimite(pais, texto, Integer.parseInt(limiteResultados));
        return gson.toJson(listaCiudades);
    }
    
    /**
     * Actualiza la configuración básica relativa a la ubicación para la predicción del tiempo
     * 
     * @param sesion
     * @param response
     * @param ciudad
     * @param unidades
     * @param numeroDias
     * @param codigoApi
     */
    @RequestMapping(value = "/actualizarubicacion", method = RequestMethod.POST)
    @ResponseBody
    public void setUbicacion(final HttpSession sesion, HttpServletResponse response, @RequestParam("ciudad") String ciudad, 
            @RequestParam("unidades") String unidades, @RequestParam("numerodias") Integer numeroDias,
            @RequestParam("codigoapi") String codigoApi){
        
        ConfiguracionDto config = new ConfiguracionDto();
        config.setIdCiudad(ciudad);
        config.setUnidadesMedida(unidades);
        config.setClimaNumeroDias(numeroDias);
        config.setClimaApiId(codigoApi);
        ConfiguracionDto resultado = confService.actualizaConfiguracion(config);
        
        sesion.setAttribute("config", resultado);
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
