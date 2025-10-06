package com.team.matias.juan.dto.inscripcion;

import java.util.Date;

public class InscripcionRequestDTO {
    
    private Long estudianteId;
    private Long carreraId;
    private Date fechaDeInscripcion;

    public InscripcionRequestDTO() {
    }

    public InscripcionRequestDTO(Long estudianteId, Long carreraId, Date fechaDeInscripcion) {
        this.estudianteId = estudianteId;
        this.carreraId = carreraId;
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }

    public Date getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public void setFechaDeInscripcion(Date fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    @Override
    public String toString() {
        return "InscripcionRequestDTO{" +
               "estudianteId=" + estudianteId +
               ", carreraId=" + carreraId +
               ", fecha=" + fechaDeInscripcion +
               '}';
    }
}
