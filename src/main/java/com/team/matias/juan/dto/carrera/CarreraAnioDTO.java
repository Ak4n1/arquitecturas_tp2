package com.team.matias.juan.dto.carrera;

public class CarreraAnioDTO {
    
    private String nombreCarrera;
    private Integer anio;
    private Long inscriptos;
    private Long egresados;

    public CarreraAnioDTO() {
    }

    public CarreraAnioDTO(String nombreCarrera, Integer anio, Long inscriptos, Integer egresados) {
        this.nombreCarrera = nombreCarrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados != null ? egresados.longValue() : 0L;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Long getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(Long inscriptos) {
        this.inscriptos = inscriptos;
    }

    public Long getEgresados() {
        return egresados;
    }

    public void setEgresados(Long egresados) {
        this.egresados = egresados;
    }
}
