package com.challenge.gmh.rooms.service;


import com.challenge.gmh.rooms.model.entity.Room;

import java.util.List;

public interface RoomService {

    /**
     * Obtiene todos los Rooms que pertenecen a un Hotel.
     *
     * @param hotelId
     * @return
     */
    List<Room> getRoomsFromHotel(String hotelId);
}
