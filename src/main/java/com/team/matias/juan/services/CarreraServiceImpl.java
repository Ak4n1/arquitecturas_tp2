package com.team.matias.juan.services;

import com.team.matias.juan.daos.CarreraDAO;
import com.team.matias.juan.daos.CarreraDAOImpl;
import com.team.matias.juan.dto.carrera.CarreraInscriptosDTO;
import com.team.matias.juan.factory.DAOFactory;
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
        return carreraDAO.buscarCarrerasConInscriptos();
    }
    

}