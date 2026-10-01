package com.hotel.Hotel.dto.response;

import java.util.UUID;

public class SuitePresidencialResponse extends HabitacionResponse {

    private boolean incluyeMayordomo;
    private boolean jacuzziPrivado;

    public SuitePresidencialResponse() {
    }

    public SuitePresidencialResponse(
            UUID id,
            boolean incluyeMayordomo,
            boolean jacuzziPrivado,
            String numero,
            double precioPorNoche,
            Integer capacidadMaxima) {

        super(
                id,
                numero,
                precioPorNoche,
                capacidadMaxima,
                "SUITE"
        );

        this.incluyeMayordomo = incluyeMayordomo;
        this.jacuzziPrivado = jacuzziPrivado;
    }

    public boolean isIncluyeMayordomo() {
        return incluyeMayordomo;
    }

    public void setIncluyeMayordomo(boolean incluyeMayordomo) {
        this.incluyeMayordomo = incluyeMayordomo;
    }

    public boolean isJacuzziPrivado() {
        return jacuzziPrivado;
    }

    public void setJacuzziPrivado(boolean jacuzziPrivado) {
        this.jacuzziPrivado = jacuzziPrivado;
    }
}