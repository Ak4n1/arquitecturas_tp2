package com.team.matias.juan.daos;

import com.team.matias.juan.entities.Estudiante_carrera;
import java.util.List;

public interface EstudianteCarreraDAO {
    
    void insertar(Estudiante_carrera inscripcion);
    
    List<Estudiante_carrera> buscarPorEstudiante(Long estudianteId);
    
    List<Object[]> generarReporteCarreras();
}
