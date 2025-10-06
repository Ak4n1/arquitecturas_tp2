package com.team.matias.juan.daos;

import javax.persistence.EntityManager;
import java.util.List;

public class CarreraDAOImpl implements CarreraDAO {

    private EntityManager em;

    public CarreraDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> buscarCarrerasConInscriptos() {
        String jpql = "SELECT c.id, c.nombre, c.facultad, COUNT(ec) " +
                      "FROM Carrera c " +
                      "JOIN Estudiante_carrera ec ON ec.id.carreraId = c.id " +
                      "GROUP BY c.id, c.nombre, c.facultad " +
                      "ORDER BY COUNT(ec) DESC";
        return em.createQuery(jpql).getResultList();
    }


}
