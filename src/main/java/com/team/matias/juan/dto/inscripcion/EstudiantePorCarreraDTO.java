package com.team.matias.juan.dto.inscripcion;

public class EstudiantePorCarreraDTO {
    
    private Long estudianteId;
    private String nombre;
    private String apellido;
    private int numeroLibretaUniversitaria;
    private String ciudadDeRecidencia;
    private String nombreCarrera;

    public EstudiantePorCarreraDTO() {
    }

    public EstudiantePorCarreraDTO(Long estudianteId, String nombre, String apellido, 
                                   int numeroLibretaUniversitaria, String ciudadDeRecidencia, String nombreCarrera) {
        this.estudianteId = estudianteId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
        this.ciudadDeRecidencia = ciudadDeRecidencia;
        this.nombreCarrera = nombreCarrera;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroLibretaUniversitaria() {
        return numeroLibretaUniversitaria;
    }

    public void setNumeroLibretaUniversitaria(int numeroLibretaUniversitaria) {
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
    }

    public String getCiudadDeRecidencia() {
        return ciudadDeRecidencia;
    }

    public void setCiudadDeRecidencia(String ciudadDeRecidencia) {
        this.ciudadDeRecidencia = ciudadDeRecidencia;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    @Override
    public String toString() {
        return "EstudiantePorCarreraDTO{" +
               "estudiante='" + apellido + ", " + nombre + '\'' +
               ", libreta=" + numeroLibretaUniversitaria +
               ", ciudad='" + ciudadDeRecidencia + '\'' +
               ", carrera='" + nombreCarrera + '\'' +
               '}';
    }
}
