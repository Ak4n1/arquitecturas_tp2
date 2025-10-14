package com.team.matias.juan.services;

import com.team.matias.juan.daos.EstudianteCarreraDAO;
import com.team.matias.juan.daos.EstudianteCarreraDAOImpl;
import com.team.matias.juan.dto.carrera.CarreraReporteDTO;
import com.team.matias.juan.dto.inscripcion.InscripcionRequestDTO;
import com.team.matias.juan.dto.inscripcion.InscripcionResponseDTO;
import com.team.matias.juan.entities.Estudiante_carrera;
import com.team.matias.juan.factory.DAOFactory;

import java.util.List;
import javax.persistence.EntityManager;

public class InscripcionServiceImpl implements InscripcionService {

    private static InscripcionServiceImpl instance;
    private EstudianteCarreraDAO inscripcionDAO;
    private EntityManager em;

    private InscripcionServiceImpl() {
        DAOFactory factory = DAOFactory.getInstance();
        this.em = factory.getEntityManagerMariaDB();
        this.inscripcionDAO = new EstudianteCarreraDAOImpl(this.em);
    }

    public static InscripcionServiceImpl getInstance() {
        if (instance == null) {
            instance = new InscripcionServiceImpl();
        }
        return instance;
    }

    @Override
    public InscripcionResponseDTO matricularEstudiante(InscripcionRequestDTO request) {

        Estudiante_carrera inscripcion = new Estudiante_carrera(
                request.getEstudianteId(),
                request.getCarreraId(),
                request.getFechaDeInscripcion());

        if (estaInscripto(request.getEstudianteId(), request.getCarreraId())) {
            System.out.println("El estudiante ya esta inscripto en la carrera");
            return null;
        } else {
            inscripcionDAO.insertar(inscripcion);
        }
        return null;
    }

    @Override
    public boolean estaInscripto(Long estudianteId, Long carreraId) {
        List<Estudiante_carrera> inscripciones = inscripcionDAO.buscarPorEstudiante(estudianteId);
        for (Estudiante_carrera i : inscripciones) {
            if (i.getCarreraId().equals(carreraId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<CarreraReporteDTO> generarReporteCarreras() {
        return inscripcionDAO.generarReporteCarreras();
    }
}