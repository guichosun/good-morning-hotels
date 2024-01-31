package com.challenge.gmh.guests.service;

import com.challenge.gmh.guests.model.entity.Guest;

import java.util.List;
import java.util.Optional;

/**
 * Definición of the service features.
 *
 * @author guichosun
 */
public interface GuestService {

    /**
     * Save a Guest on the repository.
     *
     * @param guest
     * @return
     */
    Optional<Guest> save(Guest guest);

    /**
     * Retrieve a Guest by firstNamr and lastName from the repo.
     *
     * @param firstName
     * @param lastName
     * @return
     */
    Optional<Guest> retrieveGuest(String firstName, String lastName);

    /**
     * Retrieve all Guests
     *
     * @return
     */
    List<Guest> retrieleAll();

}
