package com.team.matias.juan.dto.estudiante;

public class EstudianteRequestDTO {
    
    private String genero;
    private int edad;
    private String apellido;
    private String nombre;
    private int dni;
    private String ciudadDeRecidencia;
    private int numeroLibretaUniversitaria;
    private boolean graduado;

    public EstudianteRequestDTO() {
    }

    public EstudianteRequestDTO(String genero, int edad, String apellido, String nombre, int dni, 
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

    @Override
    public String toString() {
        return "EstudianteRequestDTO{" +
               "nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", dni=" + dni +
               '}';
    }
}
