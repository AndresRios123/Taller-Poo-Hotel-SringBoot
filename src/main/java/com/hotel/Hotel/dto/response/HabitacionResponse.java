package com.hotel.Hotel.dto.response;

import java.util.UUID;

public abstract class HabitacionResponse {

    private UUID id;
    private String numero;
    private double precioPorNoche;
    private Integer capacidadMaxima;
    private String tipo;

    protected HabitacionResponse() {
    }

    protected HabitacionResponse(
            UUID id,
            String numero,
            double precioPorNoche,
            Integer capacidadMaxima,
            String tipo) {

        this.id = id;
        this.numero = numero;
        this.precioPorNoche = precioPorNoche;
        this.capacidadMaxima = capacidadMaxima;
        this.tipo = tipo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}