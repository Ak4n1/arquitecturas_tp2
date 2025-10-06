package com.team.matias.juan.daos;

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
        em.getTransaction().begin();
        em.persist(estudiante);
        em.getTransaction().commit();
    }

    @Override
    public List<Estudiante> buscarPorGenero(String genero) {
        return em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero", Estudiante.class)
                .setParameter("genero", genero)
                .getResultList();
    }

    @Override
    public Estudiante buscarPorLibreta(int numeroLibreta) {
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e WHERE e.numeroLibretaUniversitaria = :numeroLibreta", Estudiante.class)
                .setParameter("numeroLibreta", numeroLibreta)
                .getResultList();
        return estudiantes.isEmpty() ? null : estudiantes.get(0);
    }

    @Override
    public List<Estudiante> buscarTodosOrdenadoPorApellido() {
        return em.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido ASC", Estudiante.class).getResultList();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> buscarEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudad) {
        String jpql = "SELECT e.id, e.nombre, e.apellido, e.numeroLibretaUniversitaria, e.ciudadDeRecidencia, c.nombre " +
                "FROM Estudiante e " +
                "JOIN Estudiante_carrera ec ON ec.id.estudianteId = e.id " +
                "JOIN Carrera c ON c.id = ec.id.carreraId " +
                "WHERE c.nombre = :nombreCarrera AND e.ciudadDeRecidencia = :ciudad";
        return em.createQuery(jpql)
                .setParameter("nombreCarrera", nombreCarrera)
                .setParameter("ciudad", ciudad)
                .getResultList();
    }
}
