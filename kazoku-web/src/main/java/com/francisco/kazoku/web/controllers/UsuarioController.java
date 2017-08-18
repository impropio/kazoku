package com.francisco.kazoku.web.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.francisco.kazoku.servicios.dto.ConfiguracionDto;
import com.francisco.kazoku.servicios.interfaces.ConfiguracionServiceI;
import com.francisco.kazoku.servicios.interfaces.GrupoSanguineoServiceI;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController{
    
    @Autowired
    ConfiguracionServiceI confService;
    
    @Autowired
    GrupoSanguineoServiceI grupoSanguineoService;
    
    /**
     * Carga de la pantalla de configuración
     * 
     * @param session
     * @param model
     * @return
     */
    @RequestMapping
    public ModelAndView usuario(final HttpSession sesion, final ModelMap model){
        model.addAttribute("gruposSanguineos", grupoSanguineoService.getGruposSanguineos());
        return new ModelAndView("usuario", "model", model);
    }
    
    @RequestMapping(value = "/actualizar", method = RequestMethod.POST)
    @ResponseBody
    public void actualizarUsuario(@RequestParam("id_usuario") Integer idUsuario, @RequestParam("nombre") String nombre,
            @RequestParam("clave") String clave, @RequestParam("clave2") String clave2, @RequestParam("nacimiento") Date nacimiento,
            @RequestParam("dni") String dni, @RequestParam("pasaporte") String pasaporte, @RequestParam("segsocial") String segSocial,
            @RequestParam("gruposanguineo") String grupoSanguineo, @RequestParam("cod_alergias") String codigosAlergias){
        
        
        if("".equals(idUsuario)){
            // Se crea un usuario nuevo y se recupera su id
            
        }else{
            // Se actualiza el usuario
            
        }
        
        
        
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
