package com.team.matias.juan.services;

import com.team.matias.juan.dto.carrera.CarreraReporteDTO;
import com.team.matias.juan.dto.inscripcion.InscripcionRequestDTO;
import com.team.matias.juan.dto.inscripcion.InscripcionResponseDTO;
import java.util.List;

public interface InscripcionService {
    
    InscripcionResponseDTO matricularEstudiante(InscripcionRequestDTO request);
    
    boolean estaInscripto(Long estudianteId, Long carreraId);
    
    List<CarreraReporteDTO> generarReporteCarreras();
}