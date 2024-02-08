package com.challenge.gmh.hotel.controller;

import com.challenge.gmh.hotel.model.HotelRequest;
import com.challenge.gmh.hotel.model.entity.Hotel;
import com.challenge.gmh.hotel.sevice.HotelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    //private final CircuitBreakerFactory cbFactory;

    /* Para inyectar el bean que tiene los profiles activos */
    private final Environment env;

    /**
     * Regresar una list con todos los hoteles registrados
     */
    @GetMapping()
    public ResponseEntity<List<Hotel>> getHotels() {
        log.info("Recuperar todos los hoteles en el puerto "+env.getProperty("local.server.port"));

        /*
        TODO Hacer para regresar todos los hoteles
         */
        Optional<List<Hotel>> optionalHotels = hotelService.retrieveAll();

        optionalHotels.ifPresent(lst -> lst.stream()
                .map(hotel -> {
                    //hotel.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                    return hotel;
                }).collect(Collectors.toList()));

        return ResponseEntity.of(optionalHotels);
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
        Hotel hotel = null; /*cbFactory.create("hotelWithRooms").run(() -> hotelService.retrieveById(id)
                .orElseThrow(RuntimeException::new));*/

        return ResponseEntity.ok(hotel);
    }

    /**
     * Save an Hotel.
     * @param hotel
     * @return
     */
    @PostMapping()
    public ResponseEntity<Hotel> post(@RequestHeader("Accept-Encoding") String encoding,
                                      @RequestHeader("Host") String host,
                                      @RequestHeader Map<String, String> allHeaders,
                                      @RequestHeader HttpHeaders allHeaders2,
                                      @RequestBody HotelRequest hotel) {

        allHeaders.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });
        log.info(String.format("Post en el puerto '%s' ",env.getProperty("local.server.port")));
        log.info(String.format("El hotel %s para guardar' ",hotel));

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
