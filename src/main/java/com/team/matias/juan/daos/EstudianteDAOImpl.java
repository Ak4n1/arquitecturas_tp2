package com.team.matias.juan.daos;

import com.team.matias.juan.dto.estudiante.EstudianteResponseDTO;
import com.team.matias.juan.dto.inscripcion.EstudiantePorCarreraDTO;
import com.team.matias.juan.entities.Estudiante;
import javax.persistence.EntityManager;
import java.util.List;

public class EstudianteDAOImpl implements EstudianteDAO {

    private EntityManager em;

    public EstudianteDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insertar(Estudiante estudiante) {
        // Verificar si ya existe un estudiante con el mismo DNI
        List<Estudiante> estudiantesExistentes = em.createQuery("SELECT e FROM Estudiante e WHERE e.dni = :dni", Estudiante.class)
                .setParameter("dni", estudiante.getDni())
                .getResultList();
        
        if (!estudiantesExistentes.isEmpty()) {
            throw new IllegalArgumentException("Ya existe un estudiante con el DNI: " + estudiante.getDni());
        }
        
        em.getTransaction().begin();
        em.persist(estudiante);
        em.getTransaction().commit();
    }

    @Override
    public List<EstudianteResponseDTO> buscarPorGenero(String genero) {
        String jpql = "SELECT NEW com.team.matias.juan.dto.estudiante.EstudianteResponseDTO(" +
                      "e.id, e.genero, e.edad, e.apellido, e.nombre, e.dni, " +
                      "e.ciudadDeRecidencia, e.numeroLibretaUniversitaria, e.graduado) " +
                      "FROM Estudiante e WHERE e.genero = :genero";
        return em.createQuery(jpql, EstudianteResponseDTO.class)
                .setParameter("genero", genero)
                .getResultList();
    }

    @Override
    public EstudianteResponseDTO buscarPorLibreta(int numeroLibreta) {
        String jpql = "SELECT NEW com.team.matias.juan.dto.estudiante.EstudianteResponseDTO(" +
                      "e.id, e.genero, e.edad, e.apellido, e.nombre, e.dni, " +
                      "e.ciudadDeRecidencia, e.numeroLibretaUniversitaria, e.graduado) " +
                      "FROM Estudiante e WHERE e.numeroLibretaUniversitaria = :numeroLibreta";
        List<EstudianteResponseDTO> estudiantes = em.createQuery(jpql, EstudianteResponseDTO.class)
                .setParameter("numeroLibreta", numeroLibreta)
                .getResultList();
        return estudiantes.isEmpty() ? null : estudiantes.get(0);
    }

    @Override
    public List<EstudianteResponseDTO> buscarTodosOrdenadoPorApellido() {
        String jpql = "SELECT NEW com.team.matias.juan.dto.estudiante.EstudianteResponseDTO(" +
                      "e.id, e.genero, e.edad, e.apellido, e.nombre, e.dni, " +
                      "e.ciudadDeRecidencia, e.numeroLibretaUniversitaria, e.graduado) " +
                      "FROM Estudiante e ORDER BY e.apellido ASC";
        return em.createQuery(jpql, EstudianteResponseDTO.class).getResultList();
    }

    @Override
    public List<EstudiantePorCarreraDTO> buscarEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudad) {
        String jpql = "SELECT NEW com.team.matias.juan.dto.inscripcion.EstudiantePorCarreraDTO(" +
                      "e.id, e.nombre, e.apellido, e.numeroLibretaUniversitaria, e.ciudadDeRecidencia, c.nombre) " +
                      "FROM Estudiante e " +
                      "JOIN Estudiante_carrera ec ON ec.id.estudianteId = e.id " +
                      "JOIN Carrera c ON c.id = ec.id.carreraId " +
                      "WHERE c.nombre = :nombreCarrera AND e.ciudadDeRecidencia = :ciudad";
        return em.createQuery(jpql, EstudiantePorCarreraDTO.class)
                .setParameter("nombreCarrera", nombreCarrera)
                .setParameter("ciudad", ciudad)
                .getResultList();
    }
}
