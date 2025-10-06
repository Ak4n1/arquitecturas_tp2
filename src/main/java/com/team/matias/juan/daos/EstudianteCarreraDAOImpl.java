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
        String sql = "SELECT c.nombre, YEAR(ec.fechaDeInscripcion) as anio, COUNT(ec.estudiante_id) as inscriptos, " +
                     "0 as egresados " +
                     "FROM carreras c " +
                     "LEFT JOIN estudiante_carrera ec ON ec.carrera_id = c.id " +
                     "LEFT JOIN estudiantes e ON e.id = ec.estudiante_id " +
                     "GROUP BY c.nombre, YEAR(ec.fechaDeInscripcion) " +
                     "ORDER BY c.nombre ASC, YEAR(ec.fechaDeInscripcion) ASC";
        
        return em.createNativeQuery(sql).getResultList();
    }
}
