package com.team.matias.juan.dto.inscripcion;

import java.util.Date;

public class InscripcionResponseDTO {
    
    private Long estudianteId;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private Long carreraId;
    private String nombreCarrera;
    private Date fechaDeInscripcion;

    public InscripcionResponseDTO() {
    }

    public InscripcionResponseDTO(Long estudianteId, String nombreEstudiante, String apellidoEstudiante,
                                  Long carreraId, String nombreCarrera, Date fechaDeInscripcion) {
        this.estudianteId = estudianteId;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.carreraId = carreraId;
        this.nombreCarrera = nombreCarrera;
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
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

    public Date getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public void setFechaDeInscripcion(Date fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    @Override
    public String toString() {
        return "InscripcionResponseDTO{" +
               "estudiante='" + apellidoEstudiante + ", " + nombreEstudiante + '\'' +
               ", carrera='" + nombreCarrera + '\'' +
               ", fecha=" + fechaDeInscripcion +
               '}';
    }
}
