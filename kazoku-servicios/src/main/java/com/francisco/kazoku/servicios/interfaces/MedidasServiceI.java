package com.francisco.kazoku.servicios.interfaces;

import java.util.List;

import com.francisco.kazoku.servicios.dto.MedidasDto;

public interface MedidasServiceI{
    
    List<MedidasDto> getMedidas(String idioma);
}
