package com.challenge.gmh.hotel.client;

import com.challenge.gmh.hotel.model.response.RoomResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-rooms")
public interface RoomsFeignClient {

    /**
     * Para traer todos los rooms de un hotel
     *
     * @param hotelId
     * @return
     */
    @GetMapping(value = "/rooms/hotel/{hotelId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<RoomResponse> getRoomsByHotel(@PathVariable("hotelId") String hotelId);
}
