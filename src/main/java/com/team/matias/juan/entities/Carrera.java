package com.team.matias.juan.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carreras")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String nombre;

    private String facultad;


    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<Estudiante_carrera> estudiantesInscritos = new ArrayList<>();

    public Carrera() {
    }
    public Carrera(String nombre, String facultad) {
        this.nombre = nombre;
        this.facultad = facultad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }


    public List<Estudiante_carrera> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void setEstudiantesInscritos(List<Estudiante_carrera> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    public void agregarEstudiante(Estudiante_carrera inscripcion) {
        estudiantesInscritos.add(inscripcion);
        inscripcion.setCarrera(this);
    }

    public void removerEstudiante(Estudiante_carrera inscripcion) {
        estudiantesInscritos.remove(inscripcion);
        inscripcion.setCarrera(null);
    }

    @Override
    public String toString() {
        return "Carrera{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", facultad='" + facultad + '\'' +
               '}';
    }
}