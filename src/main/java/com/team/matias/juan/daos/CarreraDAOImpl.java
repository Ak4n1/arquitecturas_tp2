package com.team.matias.juan.daos;

import com.team.matias.juan.dto.carrera.CarreraInscriptosDTO;
import javax.persistence.EntityManager;
import java.util.List;

public class CarreraDAOImpl implements CarreraDAO {

    private EntityManager em;

    public CarreraDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CarreraInscriptosDTO> buscarCarrerasConInscriptos() {
        String jpql = "SELECT NEW com.team.matias.juan.dto.carrera.CarreraInscriptosDTO(" +
                      "c.id, c.nombre, c.facultad, COUNT(ec)) " +
                      "FROM Carrera c " +
                      "JOIN Estudiante_carrera ec ON ec.id.carreraId = c.id " +
                      "GROUP BY c.id, c.nombre, c.facultad " +
                      "ORDER BY COUNT(ec) DESC";
        return em.createQuery(jpql, CarreraInscriptosDTO.class).getResultList();
    }

}
