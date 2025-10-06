package com.team.matias.juan.daos;

import com.team.matias.juan.entities.Estudiante;

import java.util.List;

public interface EstudianteDAO {

    void insertar(Estudiante estudiante);

    List<Estudiante> buscarPorGenero(String genero);

    Estudiante buscarPorLibreta(int numeroLibreta);

    List<Estudiante> buscarTodosOrdenadoPorApellido();

    List<Object[]> buscarEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudad);

}