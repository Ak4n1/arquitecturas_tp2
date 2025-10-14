package com.team.matias.juan.daos;

import com.team.matias.juan.dto.estudiante.EstudianteResponseDTO;
import com.team.matias.juan.dto.inscripcion.EstudiantePorCarreraDTO;
import com.team.matias.juan.entities.Estudiante;

import java.util.List;

public interface EstudianteDAO {

    void insertar(Estudiante estudiante);

    List<EstudianteResponseDTO> buscarPorGenero(String genero);

    EstudianteResponseDTO buscarPorLibreta(int numeroLibreta);

    List<EstudianteResponseDTO> buscarTodosOrdenadoPorApellido();

    List<EstudiantePorCarreraDTO> buscarEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudad);

}