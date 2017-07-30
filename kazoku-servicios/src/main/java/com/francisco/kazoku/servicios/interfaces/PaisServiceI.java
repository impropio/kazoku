package com.francisco.kazoku.servicios.interfaces;

import java.util.List;

import com.francisco.kazoku.servicios.dto.PaisDto;

public interface PaisServiceI{
    
    List<PaisDto> getPaises(String idioma);
    
    PaisDto getPaiseById(String idioma, String codPais);
}
