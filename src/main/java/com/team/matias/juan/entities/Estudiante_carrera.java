package com.team.matias.juan.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "estudiante_carrera")
public class Estudiante_carrera {

    @EmbeddedId
    private EstudianteCarreraId id;

    @Temporal(TemporalType.DATE)
    private Date fechaDeInscripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrera_id", insertable = false, updatable = false)
    private Carrera carrera;

    public Estudiante_carrera() {
    }

    public Estudiante_carrera(EstudianteCarreraId id, Date fechaDeInscripcion) {
        this.id = id;
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    public Estudiante_carrera(Long estudianteId, Long carreraId, Date fechaDeInscripcion) {
        this.id = new EstudianteCarreraId(estudianteId, carreraId);
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    // Getters y Setters
    public EstudianteCarreraId getId() {
        return id;
    }

    public void setId(EstudianteCarreraId id) {
        this.id = id;
    }

    public Date getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public void setFechaDeInscripcion(Date fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    public Long getEstudianteId() {
        return id != null ? id.getEstudianteId() : null;
    }

    public Long getCarreraId() {
        return id != null ? id.getCarreraId() : null;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante_carrera{" +
                "id=" + id +
                ", fechaDeInscripcion=" + fechaDeInscripcion +
                '}';
    }
}
