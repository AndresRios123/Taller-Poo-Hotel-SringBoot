package com.hotel.Hotel.dto.request;

public record CrearSuitePresidencialRequest (
    String numero,
    double precioPorNoche,
    Integer capacidadMaxima,
    boolean incluyeMayordomo,
    boolean jacuzziPrivado
){}