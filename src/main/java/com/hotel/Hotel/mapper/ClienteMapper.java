package com.hotel.Hotel.mapper;

import com.hotel.Hotel.domain.Cliente;
import com.hotel.Hotel.domain.Reserva;
import com.hotel.Hotel.dto.request.CrearClienteRequest;
import com.hotel.Hotel.dto.response.ClienteResponse;
import com.hotel.Hotel.dto.response.ClienteResumenResponse;
import com.hotel.Hotel.dto.response.ReservaItemResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteResponse toResponse(Cliente cliente);

    List<ClienteResponse> toResponseList(List<Cliente> clientes);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "penalizaciones", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    Cliente toEntity(CrearClienteRequest request);


    default ClienteResumenResponse toResumen(Cliente cliente) {

        List<Reserva> reservas = cliente.getReservas();

        int totalReservas = reservas.size();

        double montoTotal = reservas.stream()
                .mapToDouble(Reserva::getCostoTotal)
                .sum();

        List<ReservaItemResponse> reservasRecientes = reservas.stream()
                .sorted((r1, r2) ->
                        r2.getPeriodo().fechaInicio()
                                .compareTo(r1.getPeriodo().fechaInicio()))
                .limit(5)
                .map(this::toReservaItem)
                .toList();

        return new ClienteResumenResponse(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.isActivo(),
                cliente.getPenalizaciones(),
                totalReservas,
                montoTotal,
                reservasRecientes
        );
    }


    default ReservaItemResponse toReservaItem(Reserva reserva) {

        return new ReservaItemResponse(
                reserva.getId(),
                reserva.getHabitacion().getNumero(),
                reserva.getPeriodo().fechaInicio(),
                reserva.getPeriodo().fechaFin(),
                reserva.getEstado(),
                reserva.getCostoTotal()
        );
    }
}