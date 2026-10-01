package com.hotel.Hotel.controller;

import com.hotel.Hotel.dto.request.CrearSuitePresidencialRequest;
import com.hotel.Hotel.dto.response.HabitacionResponse;
import com.hotel.Hotel.service.HabitacionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @PostMapping("/suites")
    public ResponseEntity<HabitacionResponse> crearSuite(
            @RequestBody CrearSuitePresidencialRequest request,
            UriComponentsBuilder uriBuilder) {

        HabitacionResponse response =
                habitacionService.crearSuite(request);

        URI uri = uriBuilder
                .path("/api/habitaciones/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<HabitacionResponse>> obtenerHabitaciones() {

        return ResponseEntity.ok(
                habitacionService.listarTodas()
        );
    }
}