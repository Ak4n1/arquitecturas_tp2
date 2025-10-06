package com.team.matias.juan.services;

import com.team.matias.juan.dto.estudiante.EstudianteRequestDTO;
import com.team.matias.juan.dto.estudiante.EstudianteResponseDTO;
import com.team.matias.juan.dto.inscripcion.EstudiantePorCarreraDTO;

import java.util.List;

public interface EstudianteService {
    
    EstudianteResponseDTO altaEstudiante(EstudianteRequestDTO request);
    
    EstudianteResponseDTO buscarPorLibreta(int numeroLibreta);
    
    List<EstudianteResponseDTO> obtenerTodosOrdenados();
    
    List<EstudianteResponseDTO> obtenerPorGenero(String genero);

    List<EstudiantePorCarreraDTO> obtenerEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudad);

}