package com.challenge.gmh.hotel.sevice;

import com.challenge.gmh.hotel.model.HotelRequest;
import com.challenge.gmh.hotel.model.entity.Hotel;

import java.util.List;
import java.util.Optional;

/**
 * Hotel's Service definition.
 *
 * @author guichosun
 */
public interface HotelService {

    /**
     * Creates a new Hotel whit its room
     * @param hotel
     * @return
     */
    Optional<Hotel> create(HotelRequest hotel);

    /**
     * Retrieve all Hotels
     *
     * @return A list with all Hotel
     */
    Optional<List<Hotel>> retrieveAll();

    /**
     * Recupera el hotel + todos sus rooms
     *
     * @param id
     * @return
     */
    Optional<Hotel> retrieveById(String id);

    void delHoel(Hotel hotel);
}
