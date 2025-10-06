package com.team.matias.juan.services;

import com.team.matias.juan.daos.EstudianteCarreraDAO;
import com.team.matias.juan.daos.EstudianteCarreraDAOImpl;
import com.team.matias.juan.dto.carrera.CarreraReporteDTO;
import com.team.matias.juan.dto.inscripcion.InscripcionRequestDTO;
import com.team.matias.juan.dto.inscripcion.InscripcionResponseDTO;
import com.team.matias.juan.entities.Estudiante_carrera;
import com.team.matias.juan.factory.DAOFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<Object[]> resultado = inscripcionDAO.generarReporteCarreras();
        Map<String, CarreraReporteDTO> reporteMap = new HashMap<>();

        for (Object[] row : resultado) {
            String nombreCarrera = (String) row[0];
            Integer anio = (Integer) row[1];
            Long inscriptos = (Long) row[2];
            Long egresados = (Long) row[3];

            // Si el año es null, significa que la carrera no tiene inscripciones
            if (anio == null) {
                CarreraReporteDTO carreraDTO = reporteMap.get(nombreCarrera);
                if (carreraDTO == null) {
                    carreraDTO = new CarreraReporteDTO(nombreCarrera);
                    reporteMap.put(nombreCarrera, carreraDTO);
                }
                // No agregamos ningún año para carreras sin inscripciones
                continue;
            }

            CarreraReporteDTO carreraDTO = reporteMap.get(nombreCarrera);
            if (carreraDTO == null) {
                carreraDTO = new CarreraReporteDTO(nombreCarrera);
                reporteMap.put(nombreCarrera, carreraDTO);
            }

            carreraDTO.agregarAnio(new CarreraReporteDTO.AnioReporteDTO(anio, inscriptos, egresados));
        }

        return new ArrayList<>(reporteMap.values());
    }
}