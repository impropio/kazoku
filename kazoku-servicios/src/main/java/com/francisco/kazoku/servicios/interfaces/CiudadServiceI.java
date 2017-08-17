package com.francisco.kazoku.servicios.interfaces;

import java.util.List;

import com.francisco.kazoku.servicios.dto.CiudadDto;

public interface CiudadServiceI{
    
    List<CiudadDto> getCiudadesPaisTextoLimite(String codPais, String texto, Integer limite);
    
    CiudadDto getCiudadById(Integer idCiudad);
}
