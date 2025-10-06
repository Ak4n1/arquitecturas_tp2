package com.team.matias.juan.services;

import com.team.matias.juan.dto.carrera.CarreraInscriptosDTO;
import java.util.List;

public interface CarreraService {
    
    List<CarreraInscriptosDTO> obtenerCarrerasConInscriptos();
    
}