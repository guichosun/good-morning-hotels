package com.challenge.gmh.hotel.controller;

import com.challenge.gmh.hotel.model.entity.Hotel;
import com.challenge.gmh.hotel.sevice.HotelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Slf4j
@AllArgsConstructor
@RefreshScope
@RestController
@RequestMapping(value = "${api.base.hoteles}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelController {

    private final HotelService hotelService;

    private final CircuitBreakerFactory cbFactory;

    /* Para inyectar el bean que tiene los profiles activos */
    private final Environment env;

    /**
     * Regresar una list con todos los hoteles registrados
     */
    @GetMapping()
    public ResponseEntity<List<Hotel>> getHotels() {
        log.info("Recuperar todos los hoteles");

        /*
        TODO Hacer para regresar todos los hoteles
         */

        return ResponseEntity.noContent().build();
    }

    /**
     * Regresar un hotel mas todos los rooms
     */
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
        log.info("El hotel {}", id);

        /*
        Una implementacion programaticamente del CB
         */
        Hotel hotel =  cbFactory.create("hotelWithRooms").run(() -> hotelService.retrieveById(id)
                .orElseThrow(RuntimeException::new));

        return ResponseEntity.ok(hotel);
    }

    /**
     * Para actualizar el Hotel.
     * @param hotel
     * @return
     */
    @PostMapping()
    public ResponseEntity<Hotel> post(@RequestBody Hotel hotel) {

        Hotel hotelSaved = hotelService.create(hotel).orElseThrow(RuntimeException::new);

        return ResponseEntity.ok(hotelSaved);
    }

    /**
     * Para actualizar un hotel existente.
     *
     * @param hotel
     */
    @PutMapping("/{hotelId}")
    public void put(@RequestBody Hotel hotel) {
        log.info("El hotel {}", hotel);

        // TODO Hacer un update del Hotel.
    }

    /**
     * Para actualizar en bloque a todos los hoteles,
     * @return
     */
    @PutMapping()
    public ResponseEntity<?> putBatch() {

        // TODO Hacer un update batch de todo los hoteles

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Hotel> delete(@PathVariable String hoteñId) {
        log.info("El hotel {}", hoteñId);

        // TODO Borrar el hotel.

        return ResponseEntity.noContent().build();
    }

}
