package com.team.matias.juan.services;

import com.team.matias.juan.daos.CarreraDAO;
import com.team.matias.juan.daos.CarreraDAOImpl;
import com.team.matias.juan.dto.carrera.CarreraInscriptosDTO;
import com.team.matias.juan.dto.inscripcion.EstudiantePorCarreraDTO;
import com.team.matias.juan.factory.DAOFactory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class CarreraServiceImpl implements CarreraService {
    
    private static CarreraServiceImpl instance;
    private CarreraDAO carreraDAO;
    private EntityManager em;
    
    private CarreraServiceImpl() {
        DAOFactory factory = DAOFactory.getInstance();
        this.em = factory.getEntityManagerMariaDB();
        this.carreraDAO = new CarreraDAOImpl(this.em);
    }
    
    public static CarreraServiceImpl getInstance() {
        if (instance == null) {
            instance = new CarreraServiceImpl();
        }
        return instance;
    }
    
    @Override
    public List<CarreraInscriptosDTO> obtenerCarrerasConInscriptos() {
        List<Object[]> resultado = carreraDAO.buscarCarrerasConInscriptos();
        List<CarreraInscriptosDTO> carreras = new ArrayList<>();
        
        for (Object[] row : resultado) {
            CarreraInscriptosDTO dto = new CarreraInscriptosDTO(
                (Long) row[0],
                (String) row[1],
                (String) row[2],
                (Long) row[3]
            );
            carreras.add(dto);
        }
        
        return carreras;
    }
    

}