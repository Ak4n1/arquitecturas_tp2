package com.team.matias.juan.daos;

import com.team.matias.juan.entities.Estudiante_carrera;
import javax.persistence.EntityManager;
import java.util.List;

public class EstudianteCarreraDAOImpl implements EstudianteCarreraDAO {

    private EntityManager em;

    public EstudianteCarreraDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insertar(Estudiante_carrera inscripcion) {
        em.getTransaction().begin();
        em.persist(inscripcion);
        em.getTransaction().commit();
    }

    @Override
    public List<Estudiante_carrera> buscarPorEstudiante(Long estudianteId) {
        return em.createQuery("SELECT ec FROM Estudiante_carrera ec WHERE ec.id.estudianteId = :estudianteId", Estudiante_carrera.class)
                .setParameter("estudianteId", estudianteId)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> generarReporteCarreras() {
        String jpql = "SELECT c.nombre, YEAR(ec.fechaDeInscripcion), COUNT(ec), " +
                      "SUM(CASE WHEN e.graduado = true THEN 1 ELSE 0 END) " +
                      "FROM Carrera c " +
                      "LEFT JOIN Estudiante_carrera ec ON ec.id.carreraId = c.id " +
                      "LEFT JOIN Estudiante e ON e.id = ec.id.estudianteId " +
                      "GROUP BY c.nombre, YEAR(ec.fechaDeInscripcion) " +
                      "ORDER BY c.nombre ASC, YEAR(ec.fechaDeInscripcion) ASC";
        
        return em.createQuery(jpql).getResultList();
    }
}
