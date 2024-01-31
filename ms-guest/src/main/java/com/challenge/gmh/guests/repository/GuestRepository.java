package com.challenge.gmh.guests.repository;

import com.challenge.gmh.guests.model.entity.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * A simple mongo repository
 * @author guichosun
 */
@Repository
public interface GuestRepository extends MongoRepository<Guest, String> {

    /**
     * Para escribir simples queries, usar los nombres de las propiedades con las palabras findBy y And o Or.
     *
     * Find a guest by its name
     */
    Optional<Guest> findByFirstName(String firstName);

    /**
     * Query for name AND stars.
     *
     * @param fName
     *
     * @param email
     * @return a Guest
     */
    Optional<Guest> findByFirstNameAndEmail(String fName, Integer email);
}
