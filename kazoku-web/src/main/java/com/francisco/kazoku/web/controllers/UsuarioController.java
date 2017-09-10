package com.francisco.kazoku.web.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.francisco.kazoku.servicios.dto.ConfiguracionDto;
import com.francisco.kazoku.servicios.dto.UsuarioDto;
import com.francisco.kazoku.servicios.interfaces.ConfiguracionServiceI;
import com.francisco.kazoku.servicios.interfaces.UsuarioServiceI;
import com.google.gson.Gson;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController{
    
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    ConfiguracionServiceI confService;
    
    @Autowired
    UsuarioServiceI usuarioService;
    
    Locale locale = LocaleContextHolder.getLocale();
    
    /**
     * Carga de la pantalla de configuración
     * 
     * @param session
     * @param model
     * @return ModelAndView
     */
    @RequestMapping
    public ModelAndView usuario(final HttpSession sesion, final ModelMap model){
        model.addAttribute("gruposSanguineos", messageSource.getMessage("usuario.grupo.sanguineo.tipo", null, locale).split(","));
        return new ModelAndView("usuario", "model", model);
    }
    
    /**
     * Carga la lista de usuarios con sus datos básicos
     * 
     * @return Lista de usuarios
     */
    @RequestMapping(value = "/listausuarios", method = RequestMethod.GET)
    @ResponseBody
    public String listaUsuarios(){
        List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
        Gson gson = new Gson();
        listaUsuariosDto = usuarioService.getUsuarios();
        String resultado = gson.toJson(listaUsuariosDto);
        return resultado;
    }
    
    /**
     * Actualiza la información de un usuario ya existente o crea un usuario nuevo
     * 
     * @param idUsuario
     * @param nombre
     * @param clave
     * @param nacimiento
     * @param dni
     * @param pasaporte
     * @param segSocial
     * @param grupoSanguineo
     * @param codigosAlergias
     * @throws ParseException 
     */
    @RequestMapping(value = "/actualizar", method = RequestMethod.POST)
    @ResponseBody
    public void actualizarUsuario(@RequestParam("id") Integer idUsuario, @RequestParam("nombre") String nombre,
            @RequestParam("clave") String clave, @RequestParam("nacimiento") String nacimiento, @RequestParam("dni") String dni, 
            @RequestParam("pasaporte") String pasaporte, @RequestParam("segSocial") String segSocial,
            @RequestParam("grupoSanguineo") String grupoSanguineo, @RequestParam("codigosAlergias") String codigosAlergias) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNaciemiento = sdf.parse(nacimiento);
        UsuarioDto usuarioDto = new UsuarioDto();
        
        if(idUsuario != null){
            usuarioDto.setId(idUsuario);
        }else{
            usuarioDto.setId(0);
        }
        usuarioDto.setNombre(nombre);
        usuarioDto.setClave(clave);
        usuarioDto.setFechaNacimiento(fechaNaciemiento);
        usuarioDto.setDni(dni);
        usuarioDto.setPasaporte(pasaporte);
        usuarioDto.setSegSocial(segSocial);
        usuarioDto.setGrupoSanguineo(grupoSanguineo);
        usuarioDto.setCodigoAlergias(codigosAlergias);
        
        usuarioService.actualizarUsuario(usuarioDto);
        
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
