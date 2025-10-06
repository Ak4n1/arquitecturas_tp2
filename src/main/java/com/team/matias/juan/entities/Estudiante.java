package com.team.matias.juan.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String genero;
    private int edad;
    @NotNull
    private String apellido;
    @NotNull
    private String nombre;
    private int dni;
    private String ciudadDeRecidencia;
    private int numeroLibretaUniversitaria;
    private boolean graduado;

    @OneToMany(mappedBy = "estudiante",fetch = FetchType.LAZY)
    private List<Estudiante_carrera> inscripciones = new ArrayList<>();

    public Estudiante() {
    }

    public Estudiante(String genero, int edad, String apellido, String nombre, int dni,
                      String ciudadDeRecidencia, int numeroLibretaUniversitaria, boolean graduado) {
        this.genero = genero;
        this.edad = edad;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.ciudadDeRecidencia = ciudadDeRecidencia;
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
        this.graduado = graduado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCiudadDeRecidencia() {
        return ciudadDeRecidencia;
    }

    public void setCiudadDeRecidencia(String ciudadDeRecidencia) {
        this.ciudadDeRecidencia = ciudadDeRecidencia;
    }

    public int getNumeroLibretaUniversitaria() {
        return numeroLibretaUniversitaria;
    }

    public void setNumeroLibretaUniversitaria(int numeroLibretaUniversitaria) {
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public List<Estudiante_carrera> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Estudiante_carrera> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void agregarInscripcion(Estudiante_carrera inscripcion) {
        inscripciones.add(inscripcion);
        inscripcion.setEstudiante(this);
    }

    public void removerInscripcion(Estudiante_carrera inscripcion) {
        inscripciones.remove(inscripcion);
        inscripcion.setEstudiante(null);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}' ;
    }
}