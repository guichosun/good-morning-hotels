package com.challenge.gmh.rooms.service;

import com.challenge.gmh.rooms.model.entity.Room;
import com.challenge.gmh.rooms.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultRoomService implements RoomService{

    private final RoomRepository repository;

    @Override
    public List<Room> getRoomsFromHotel(String hotelId) {
        Optional<List<Room>> op = repository.getByHotelId(hotelId);
        log.info("Rooms {}",op);
        return op.orElse(Collections.emptyList());
    }
}
