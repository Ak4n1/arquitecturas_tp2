package com.team.matias.juan.daos;

import com.team.matias.juan.dto.carrera.CarreraInscriptosDTO;
import java.util.List;

public interface CarreraDAO {
    
    List<CarreraInscriptosDTO> buscarCarrerasConInscriptos();
    
}