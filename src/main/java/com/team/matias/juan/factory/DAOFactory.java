package com.team.matias.juan.factory;

import com.team.matias.juan.daos.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {

    private static DAOFactory instance;
    private EntityManagerFactory emfMariaDB;
    private EntityManagerFactory emfDerby;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public EntityManager getEntityManagerMariaDB() {
        if (emfMariaDB == null) {
            emfMariaDB = Persistence.createEntityManagerFactory("tp2_arquitectura_MariaDB");
        }
        return emfMariaDB.createEntityManager();
    }

    public EntityManager getEntityManagerDerby() {
        if (emfDerby == null) {
            emfDerby = Persistence.createEntityManagerFactory("tp2_arquitectura_Derby");
        }
        return emfDerby.createEntityManager();
    }

    public EstudianteDAO getEstudianteDAO(EntityManager em) {
        return new EstudianteDAOImpl(em);
    }

    public CarreraDAO getCarreraDAO(EntityManager em) {
        return new CarreraDAOImpl(em);
    }

    public EstudianteCarreraDAO getEstudianteCarreraDAO(EntityManager em) {
        return new EstudianteCarreraDAOImpl(em);
    }

    public void closeMariaDB() {
        if (emfMariaDB != null && emfMariaDB.isOpen()) {
            emfMariaDB.close();
        }
    }

    public void closeDerby() {
        if (emfDerby != null && emfDerby.isOpen()) {
            emfDerby.close();
        }
    }

    public void closeAll() {
        closeMariaDB();
        closeDerby();
    }
}
