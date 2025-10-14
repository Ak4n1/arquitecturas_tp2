package com.team.matias.juan.daos;

import com.team.matias.juan.dto.carrera.CarreraAnioDTO;
import com.team.matias.juan.dto.carrera.CarreraReporteDTO;
import com.team.matias.juan.entities.Estudiante_carrera;
import javax.persistence.EntityManager;
import java.util.ArrayList;
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
    public List<CarreraReporteDTO> generarReporteCarreras() {
        String sql = "SELECT NEW com.team.matias.juan.dto.carrera.CarreraAnioDTO(" +
                     "c.nombre, YEAR(ec.fechaDeInscripcion), COUNT(ec.id.estudianteId), 0) " +
                     "FROM Carrera c " +
                     "LEFT JOIN Estudiante_carrera ec ON ec.id.carreraId = c.id " +
                     "LEFT JOIN Estudiante e ON e.id = ec.id.estudianteId " +
                     "GROUP BY c.nombre, YEAR(ec.fechaDeInscripcion) " +
                     "ORDER BY c.nombre ASC, YEAR(ec.fechaDeInscripcion) ASC";
        
        List<CarreraAnioDTO> resultado = em.createQuery(sql, CarreraAnioDTO.class).getResultList();
        List<CarreraReporteDTO> reporte = new ArrayList<>();
        String carreraActual = null;
        CarreraReporteDTO carreraDTO = null;

        for (CarreraAnioDTO row : resultado) {
            // Si cambió la carrera, crear nueva instancia
            if (!row.getNombreCarrera().equals(carreraActual)) {
                carreraActual = row.getNombreCarrera();
                carreraDTO = new CarreraReporteDTO(carreraActual);
                reporte.add(carreraDTO);
            }

            // Solo agregar año si no es null (carreras con inscripciones)
            if (row.getAnio() != null) {
                carreraDTO.agregarAnio(new CarreraReporteDTO.AnioReporteDTO(
                    row.getAnio(), row.getInscriptos(), row.getEgresados()));
            }
        }

        return reporte;
    }
}
