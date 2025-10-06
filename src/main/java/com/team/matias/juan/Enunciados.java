package com.team.matias.juan;

import com.team.matias.juan.dto.estudiante.EstudianteRequestDTO;
import com.team.matias.juan.dto.inscripcion.InscripcionRequestDTO;
import com.team.matias.juan.services.*;

import java.util.Date;

public class Enunciados {

    public static void enunciado1() {
        System.out.println("Punto 1: Dar de alta un estudiante");
        EstudianteRequestDTO requestEstudiante = new EstudianteRequestDTO(
                "F", 31,
                "Gomes",
                "Lucía",
                42987654,
                "Tandil",
                1016,
                false);

        EstudianteService es = EstudianteServiceImpl.getInstance();

        try {
            es.altaEstudiante(requestEstudiante);
            System.out.println("✅ Estudiante creado exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        System.out.println("\n\n\n");
    }

    public static void enunciado2() {
        System.out.println("Punto 2: Matricular un estudiante en una carrera");

        InscripcionRequestDTO requestInscripcion = new InscripcionRequestDTO(4L, 5L, new Date());

        InscripcionService is = InscripcionServiceImpl.getInstance();
        is.matricularEstudiante(requestInscripcion);
        System.out.println("\n\n\n");

    }

    public static void enunciado3() {
        System.out.println(
                "Punto 3: Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple");

        EstudianteService es = EstudianteServiceImpl.getInstance();

        for (int i = 0; i < es.obtenerTodosOrdenados().size(); i++) {
            System.out.println(es.obtenerTodosOrdenados().get(i));
        }
        System.out.println("\n\n\n");

    }

    public static void enunciado4() {
        System.out.println("Enunciado 4 : Recuperar un estudiante, en base a su número de libreta universitaria.");

        EstudianteService es = EstudianteServiceImpl.getInstance();

        System.out.println(es.buscarPorLibreta(1008));
        System.out.println("\n\n\n");

    }

    public static void enunciado5(String genero) {
        System.out.println("Enunciado 5 : Recuperar todos los estudiantes, en base a su género");

        EstudianteService es = EstudianteServiceImpl.getInstance();

        for (int i = 0; i < es.obtenerPorGenero(genero).size(); i++) {
            System.out.println(es.obtenerPorGenero(genero).get(i));
        }
        System.out.println("\n\n\n");

    }

    public static void enunciado6() {
        System.out.println(
                "Enunciado 6 : Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos");

        CarreraService cs = CarreraServiceImpl.getInstance();

        for (int i = 0; i < cs.obtenerCarrerasConInscriptos().size(); i++) {
            System.out.println(cs.obtenerCarrerasConInscriptos().get(i));
        }
        System.out.println("\n\n\n");

    }

    public static void enunciado7(String carrera, String ciudad) {
        System.out.println(
                "Enunciado 7 : recuperar los estudiantes de una determinada carrera, filtrado por ciudad de Residencia");

        EstudianteService es = EstudianteServiceImpl.getInstance();
        for (int i = 0; i < es.obtenerEstudiantesPorCarreraYCiudad(carrera, ciudad).size(); i++) {
            System.out.println(es.obtenerEstudiantesPorCarreraYCiudad(carrera, ciudad).get(i));
        }
        System.out.println("\n\n\n");

    }

    public static void enunciado8() {

        InscripcionService is = InscripcionServiceImpl.getInstance();

        for (int i = 0; i < is.generarReporteCarreras().size(); i++) {
            System.out.println(is.generarReporteCarreras().get(i));
        }
        System.out.println("\n\n\n");

    }

}
