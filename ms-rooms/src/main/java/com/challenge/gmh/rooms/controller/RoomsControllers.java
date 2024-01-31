package com.challenge.gmh.rooms.controller;

import com.challenge.gmh.rooms.model.entity.Room;
import com.challenge.gmh.rooms.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * The controller with several endpoints.
 */
@RestController()
@RequestMapping(value = "${api.base.rooms}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class RoomsControllers {

    private final Environment env;

    private final RoomService service;

    // Se usa de forma programatica el Circuit breaker
    private final CircuitBreakerFactory cbFactory;

    /**
     * Todos los cuartos
     *
     * @return
     */
    @GetMapping()
    public ResponseEntity<String> getRooms() {
        return ResponseEntity.ok()
                .build();
    }

    /**
     * Todos los cuartos de un Hotel
     *
     * @param hotelId
     * @return
     */
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Room>> getRoomsByHotel(@PathVariable("hotelId") String hotelId) throws InterruptedException {
        log.info("El hotel id {}",hotelId);

        // Una simulación de fallos
        if(hotelId.equals("10")) {
            throw new IllegalStateException("Producto no encontrado!");
        }
        if(hotelId.equals("7")) {
            TimeUnit.SECONDS.sleep(5L);
        }

        List<Room> rooms = service.getRoomsFromHotel(hotelId).stream()
                .map(r ->
                {
                    r.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                    return r;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(rooms);

    }

    private List<Room> metodoAlternativo() {
        return Collections.emptyList();
    }
}
