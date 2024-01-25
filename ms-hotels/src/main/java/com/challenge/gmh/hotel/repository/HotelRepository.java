package com.challenge.gmh.hotel.repository;

import com.challenge.gmh.hotel.model.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

    /*
    Para escribir simples queries, usar los nombres de las propiedades
    con   las palabras findBy y And o Or
     */

    Optional<Hotel> findById(String id);

    /**
     * Query for name.
     *
     * @param name
     * @return
     */
    List<Hotel> findByName(String name);

    /**
     * Query for name AND stars.
     *
     * @param name
     * @param stars
     * @return
     */
    List<Hotel> findByNameAndStars(String name, Integer stars);
}
