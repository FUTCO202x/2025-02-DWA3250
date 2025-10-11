package com.example.kener.dto;

public class NombreCompletoDTO {
    private String nombreCompleto;

    // Constructores
    public NombreCompletoDTO() {
    }

    public NombreCompletoDTO(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    // Getters y Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}

