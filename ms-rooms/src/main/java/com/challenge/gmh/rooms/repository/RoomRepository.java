package com.challenge.gmh.rooms.repository;

import com.challenge.gmh.rooms.model.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Te Mongo repository
 */
@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    Room getByRoomNo(String roomNo);

    /**
     * Todos los rooms de un hotel.
     *
     * @param hotelId
     * @return
     */
    Optional<List<Room>> getByHotelId(String hotelId);
}
