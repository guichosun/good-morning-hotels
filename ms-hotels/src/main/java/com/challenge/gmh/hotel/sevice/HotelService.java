package com.challenge.gmh.hotel.sevice;

import com.challenge.gmh.hotel.model.entity.Hotel;

import java.util.List;
import java.util.Optional;

/**
 *
 */
public interface HotelService {
    Optional<Hotel> create(Hotel hotel);

    /**
     * Recupera el hotel + todos sus rooms
     *
     * @param id
     * @return
     */
    Optional<Hotel> retrieveById(String id);

    /**
     * Retrieve all Hotels
     *
     * @return
     */
    List<Hotel> retrieleAll();

    void delHoel(Hotel hotel);
}
