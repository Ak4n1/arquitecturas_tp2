package com.team.matias.juan.helpers;

import com.team.matias.juan.entities.Carrera;
import com.team.matias.juan.entities.Estudiante;
import com.team.matias.juan.entities.Estudiante_carrera;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CargarDatosMariaDB {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static List<Carrera> carreras;
    private static List<Estudiante> estudiantes;

    public static void main(String[] args) {
        System.out.println("=== CARGANDO DATOS EN MARIADB ===\n");

        try {
            emf = Persistence.createEntityManagerFactory("tp2_arquitectura_MariaDB");
            em = emf.createEntityManager();

            cargarCarreras();
            cargarEstudiantes();
            cargarInscripciones();

            System.out.println("\n✅ DATOS CARGADOS EXITOSAMENTE EN MARIADB");

        } catch (Exception e) {
            System.err.println("❌ ERROR al cargar datos:");
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }

    private static void cargarCarreras() {
        System.out.println("📚 Cargando carreras de UNICEN...");
        
        carreras = new ArrayList<>();
        em.getTransaction().begin();

        carreras.add(persistirCarrera("TUDAI", "Facultad de Ciencias Exactas"));
        carreras.add(persistirCarrera("Licenciatura en Sistemas", "Facultad de Ciencias Exactas"));
        carreras.add(persistirCarrera("Licenciatura en Matemática", "Facultad de Ciencias Exactas"));
        carreras.add(persistirCarrera("Ingeniería Civil", "Facultad de Ingeniería"));
        carreras.add(persistirCarrera("Ingeniería Industrial", "Facultad de Ingeniería"));
        carreras.add(persistirCarrera("Ingeniería Electromecánica", "Facultad de Ingeniería"));
        carreras.add(persistirCarrera("Contador Público", "Facultad de Ciencias Económicas"));
        carreras.add(persistirCarrera("Licenciatura en Administración", "Facultad de Ciencias Económicas"));
        carreras.add(persistirCarrera("Licenciatura en Economía", "Facultad de Ciencias Económicas"));
        carreras.add(persistirCarrera("Veterinaria", "Facultad de Ciencias Veterinarias"));
        carreras.add(persistirCarrera("Ingeniería Agronómica", "Facultad de Agronomía"));
        carreras.add(persistirCarrera("Licenciatura en Comunicación Social", "Facultad de Ciencias Humanas"));
        carreras.add(persistirCarrera("Licenciatura en Trabajo Social", "Facultad de Ciencias Humanas"));
        carreras.add(persistirCarrera("Licenciatura en Arte", "Facultad de Arte"));

        em.getTransaction().commit();
        System.out.println("\n📊 Total de carreras cargadas: 14");
    }

    private static Carrera persistirCarrera(String nombre, String facultad) {
        Carrera carrera = new Carrera(nombre, facultad);
        em.persist(carrera);
        System.out.println("  ✓ " + nombre);
        return carrera;
    }

    private static void cargarEstudiantes() {
        System.out.println("\n👥 Cargando estudiantes...");
        
        estudiantes = new ArrayList<>();
        em.getTransaction().begin();

        estudiantes.add(persistirEstudiante("M", 20, "González", "Juan", 42123456, "Tandil", 1001, false));
        estudiantes.add(persistirEstudiante("F", 22, "Martínez", "María", 41234567, "Tandil", 1002, false));
        estudiantes.add(persistirEstudiante("M", 25, "López", "Carlos", 40345678, "Azul", 1003, true));
        estudiantes.add(persistirEstudiante("F", 21, "Fernández", "Ana", 42456789, "Olavarría", 1004, false));
        estudiantes.add(persistirEstudiante("M", 23, "Rodríguez", "Pedro", 41567890, "Tandil", 1005, false));
        estudiantes.add(persistirEstudiante("F", 24, "García", "Laura", 40678901, "Azul", 1006, true));
        estudiantes.add(persistirEstudiante("M", 19, "Sánchez", "Diego", 42789012, "Tandil", 1007, false));
        estudiantes.add(persistirEstudiante("F", 22, "Ramírez", "Sofia", 41890123, "Olavarría", 1008, false));
        estudiantes.add(persistirEstudiante("M", 26, "Torres", "Martín", 39901234, "Azul", 1009, true));
        estudiantes.add(persistirEstudiante("F", 20, "Díaz", "Valentina", 42012345, "Tandil", 1010, false));
        estudiantes.add(persistirEstudiante("M", 21, "Morales", "Lucas", 41123456, "Olavarría", 1011, false));
        estudiantes.add(persistirEstudiante("F", 23, "Castro", "Camila", 40234567, "Tandil", 1012, false));
        estudiantes.add(persistirEstudiante("M", 22, "Ruiz", "Facundo", 41345678, "Azul", 1013, false));
        estudiantes.add(persistirEstudiante("F", 24, "Álvarez", "Florencia", 40456789, "Tandil", 1014, true));
        estudiantes.add(persistirEstudiante("M", 20, "Romero", "Tomás", 42567890, "Olavarría", 1015, false));

        em.getTransaction().commit();
        System.out.println("\n📊 Total de estudiantes cargados: 15");
    }

    private static Estudiante persistirEstudiante(String genero, int edad, String apellido, String nombre, 
                                                   int dni, String ciudad, int libreta, boolean graduado) {
        Estudiante estudiante = new Estudiante(genero, edad, apellido, nombre, dni, ciudad, libreta, graduado);
        em.persist(estudiante);
        System.out.println("  ✓ " + nombre + " " + apellido + " - " + ciudad);
        return estudiante;
    }

    private static void cargarInscripciones() {
        System.out.println("\n📝 Cargando inscripciones...");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            em.getTransaction().begin();

            persistirInscripcion(estudiantes.get(0), carreras.get(0), sdf.parse("2020-03-01"));
            persistirInscripcion(estudiantes.get(1), carreras.get(0), sdf.parse("2021-03-01"));
            persistirInscripcion(estudiantes.get(2), carreras.get(1), sdf.parse("2018-03-01"));
            persistirInscripcion(estudiantes.get(3), carreras.get(3), sdf.parse("2020-03-01"));
            persistirInscripcion(estudiantes.get(4), carreras.get(0), sdf.parse("2019-03-01"));
            persistirInscripcion(estudiantes.get(5), carreras.get(6), sdf.parse("2017-03-01"));
            persistirInscripcion(estudiantes.get(6), carreras.get(0), sdf.parse("2022-03-01"));
            persistirInscripcion(estudiantes.get(7), carreras.get(4), sdf.parse("2021-03-01"));
            persistirInscripcion(estudiantes.get(8), carreras.get(1), sdf.parse("2016-03-01"));
            persistirInscripcion(estudiantes.get(9), carreras.get(0), sdf.parse("2021-03-01"));
            persistirInscripcion(estudiantes.get(10), carreras.get(5), sdf.parse("2020-03-01"));
            persistirInscripcion(estudiantes.get(11), carreras.get(0), sdf.parse("2020-03-01"));
            persistirInscripcion(estudiantes.get(12), carreras.get(7), sdf.parse("2021-03-01"));
            persistirInscripcion(estudiantes.get(13), carreras.get(1), sdf.parse("2018-03-01"));
            persistirInscripcion(estudiantes.get(14), carreras.get(3), sdf.parse("2022-03-01"));
            persistirInscripcion(estudiantes.get(0), carreras.get(1), sdf.parse("2021-03-01"));
            persistirInscripcion(estudiantes.get(4), carreras.get(1), sdf.parse("2020-03-01"));

            em.getTransaction().commit();
            System.out.println("\n📊 Total de inscripciones cargadas: 17");

        } catch (Exception e) {
            System.err.println("❌ ERROR al cargar inscripciones:");
            e.printStackTrace();
        }
    }

    private static void persistirInscripcion(Estudiante estudiante, Carrera carrera, java.util.Date fecha) {
        Estudiante_carrera inscripcion = new Estudiante_carrera(estudiante.getId(), carrera.getId(), fecha);
        em.persist(inscripcion);
        System.out.println("  ✓ " + estudiante.getNombre() + " " + estudiante.getApellido() + " → " + carrera.getNombre());
    }
}
