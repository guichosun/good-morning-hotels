package com.challenge.gmh.hotel.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class HotelResponse {

    private String id;

    private String name;

    private String description;

    private Integer stars;

    private List<RoomResponse> rooms;
}

