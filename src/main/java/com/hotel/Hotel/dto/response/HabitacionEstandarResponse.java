package com.hotel.Hotel.dto.response;

import java.util.UUID;

public class HabitacionEstandarResponse extends HabitacionResponse {

    private Integer camasIndividuales;

    public HabitacionEstandarResponse() {
    }

    public HabitacionEstandarResponse(
            UUID id,
            Integer camasIndividuales,
            String numero,
            double precioPorNoche,
            Integer capacidadMaxima) {

        super(
                id,
                numero,
                precioPorNoche,
                capacidadMaxima,
                "ESTANDAR"
        );

        this.camasIndividuales = camasIndividuales;
    }

    public Integer getCamasIndividuales() {
        return camasIndividuales;
    }
}