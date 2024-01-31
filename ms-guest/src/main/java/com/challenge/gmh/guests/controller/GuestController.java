package com.challenge.gmh.guests.controller;

import com.challenge.gmh.guests.model.entity.Guest;
import com.challenge.gmh.guests.service.GuestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/guest",
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class GuestController {

    //private final GuestService service;

    @GetMapping("/{email}")
    public ResponseEntity<Guest> getGuests(@PathVariable String email) {
        log.info("Recuperar todos los guest registrados");

        /*
        TODO Hacer para regresar todos los guest
         */

        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Guest>> getGuests() {
        log.info("Recuperar todos los guest registrados");

        /*
        TODO Hacer para regresar todos los guest
         */

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Guest> postSave(@RequestBody Guest body) {
        log.info("Recuperar todos los guest registrados");

        /*
        TODO Llamar al servicio para guardar el guest.
         */

        return ResponseEntity.noContent().build();
    }
}
