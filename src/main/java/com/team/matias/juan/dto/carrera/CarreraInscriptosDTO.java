package com.team.matias.juan.dto.carrera;

public class CarreraInscriptosDTO {
    
    private Long carreraId;
    private String nombreCarrera;
    private String facultad;
    private Long cantidadInscriptos;

    public CarreraInscriptosDTO() {
    }

    public CarreraInscriptosDTO(Long carreraId, String nombreCarrera, String facultad, Long cantidadInscriptos) {
        this.carreraId = carreraId;
        this.nombreCarrera = nombreCarrera;
        this.facultad = facultad;
        this.cantidadInscriptos = cantidadInscriptos;
    }

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public Long getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(Long cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    @Override
    public String toString() {
        return "CarreraInscriptosDTO{" +
               "carrera='" + nombreCarrera + '\'' +
               ", facultad='" + facultad + '\'' +
               ", inscriptos=" + cantidadInscriptos +
               '}';
    }
}
