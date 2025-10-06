package com.team.matias.juan.services;

import com.team.matias.juan.daos.EstudianteDAO;
import com.team.matias.juan.daos.EstudianteDAOImpl;
import com.team.matias.juan.dto.estudiante.EstudianteRequestDTO;
import com.team.matias.juan.dto.estudiante.EstudianteResponseDTO;
import com.team.matias.juan.dto.inscripcion.EstudiantePorCarreraDTO;
import com.team.matias.juan.entities.Estudiante;
import com.team.matias.juan.factory.DAOFactory;
import java.util.ArrayList;
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
        Estudiante estudiante = estudianteDAO.buscarPorLibreta(numeroLibreta);
        return estudiante != null ? toDTO(estudiante) : null;
    }
    
    @Override
    public List<EstudianteResponseDTO> obtenerTodosOrdenados() {
        List<Estudiante> estudiantes = estudianteDAO.buscarTodosOrdenadoPorApellido();
        List<EstudianteResponseDTO> resultado = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            resultado.add(toDTO(e));
        }
        return resultado;
    }
    
    @Override
    public List<EstudianteResponseDTO> obtenerPorGenero(String genero) {
        List<Estudiante> estudiantes = estudianteDAO.buscarPorGenero(genero);
        List<EstudianteResponseDTO> resultado = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            resultado.add(toDTO(e));
        }
        return resultado;
    }

    @Override
    public List<EstudiantePorCarreraDTO> obtenerEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudad) {
        List<Object[]> resultado = estudianteDAO.buscarEstudiantesPorCarreraYCiudad(nombreCarrera, ciudad);
        List<EstudiantePorCarreraDTO> estudiantes = new ArrayList<>();

        for (Object[] row : resultado) {
            EstudiantePorCarreraDTO dto = new EstudiantePorCarreraDTO(
                    (Long) row[0],
                    (String) row[1],
                    (String) row[2],
                    (Integer) row[3],
                    (String) row[4],
                    (String) row[5]
            );
            estudiantes.add(dto);
        }

        return estudiantes;
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