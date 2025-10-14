package com.team.matias.juan.services;

import com.team.matias.juan.daos.EstudianteDAO;
import com.team.matias.juan.daos.EstudianteDAOImpl;
import com.team.matias.juan.dto.estudiante.EstudianteRequestDTO;
import com.team.matias.juan.dto.estudiante.EstudianteResponseDTO;
import com.team.matias.juan.dto.inscripcion.EstudiantePorCarreraDTO;
import com.team.matias.juan.entities.Estudiante;
import com.team.matias.juan.factory.DAOFactory;
import java.util.List;
import javax.persistence.EntityManager;

public class EstudianteServiceImpl implements EstudianteService {
    
    private static EstudianteServiceImpl instance;
    private EstudianteDAO estudianteDAO;

    private EntityManager em;
    
    private EstudianteServiceImpl() {
        DAOFactory factory = DAOFactory.getInstance();
        this.em = factory.getEntityManagerMariaDB();
        this.estudianteDAO = new EstudianteDAOImpl(this.em);
    }
    
    public static EstudianteServiceImpl getInstance() {
        if (instance == null) {
            instance = new EstudianteServiceImpl();
        }
        return instance;
    }

    //Chekear inserccion por dni
    @Override
    public EstudianteResponseDTO altaEstudiante(EstudianteRequestDTO request) {
        Estudiante estudiante = new Estudiante(
            request.getGenero(),
            request.getEdad(),
            request.getApellido(),
            request.getNombre(),
            request.getDni(),
            request.getCiudadDeRecidencia(),
            request.getNumeroLibretaUniversitaria(),
            request.isGraduado()
        );
        try {
            estudianteDAO.insertar(estudiante);
            return toDTO(estudiante);
        } catch (IllegalArgumentException e) {
            throw e; // Re-lanzar la excepción para que la maneje el llamador
        }
    }
    
    @Override
    public EstudianteResponseDTO buscarPorLibreta(int numeroLibreta) {
        return estudianteDAO.buscarPorLibreta(numeroLibreta);
    }
    
    @Override
    public List<EstudianteResponseDTO> obtenerTodosOrdenados() {
        return estudianteDAO.buscarTodosOrdenadoPorApellido();
    }
    
    @Override
    public List<EstudianteResponseDTO> obtenerPorGenero(String genero) {
        return estudianteDAO.buscarPorGenero(genero);
    }

    @Override
    public List<EstudiantePorCarreraDTO> obtenerEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudad) {
        return estudianteDAO.buscarEstudiantesPorCarreraYCiudad(nombreCarrera, ciudad);
    }
    
    private EstudianteResponseDTO toDTO(Estudiante e) {
        return new EstudianteResponseDTO(
            e.getId(),
            e.getGenero(),
            e.getEdad(),
            e.getApellido(),
            e.getNombre(),
            e.getDni(),
            e.getCiudadDeRecidencia(),
            e.getNumeroLibretaUniversitaria(),
            e.isGraduado()
        );
    }
}