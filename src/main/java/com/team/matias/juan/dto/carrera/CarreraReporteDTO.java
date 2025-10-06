package com.team.matias.juan.dto.carrera;

import java.util.ArrayList;
import java.util.List;

public class CarreraReporteDTO {
    
    private String nombreCarrera;
    private List<AnioReporteDTO> anios;

    public CarreraReporteDTO() {
        this.anios = new ArrayList<>();
    }

    public CarreraReporteDTO(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.anios = new ArrayList<>();
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public List<AnioReporteDTO> getAnios() {
        return anios;
    }

    public void setAnios(List<AnioReporteDTO> anios) {
        this.anios = anios;
    }

    public void agregarAnio(AnioReporteDTO anio) {
        this.anios.add(anio);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrera: ").append(nombreCarrera).append("\n");
        for (AnioReporteDTO anio : anios) {
            sb.append("  ").append(anio.toString()).append("\n");
        }
        return sb.toString();
    }

    public static class AnioReporteDTO {
        private int anio;
        private long inscriptos;
        private long egresados;

        public AnioReporteDTO() {
        }

        public AnioReporteDTO(int anio, long inscriptos, long egresados) {
            this.anio = anio;
            this.inscriptos = inscriptos;
            this.egresados = egresados;
        }

        public int getAnio() {
            return anio;
        }

        public void setAnio(int anio) {
            this.anio = anio;
        }

        public long getInscriptos() {
            return inscriptos;
        }

        public void setInscriptos(long inscriptos) {
            this.inscriptos = inscriptos;
        }

        public long getEgresados() {
            return egresados;
        }

        public void setEgresados(long egresados) {
            this.egresados = egresados;
        }

        @Override
        public String toString() {
            return "Año " + anio + ": " + inscriptos + " inscriptos, " + egresados + " egresados";
        }
    }
}
