package com.challenge.gmh.hotels.data;

import com.challenge.gmh.hotel.model.HotelRequest;
import com.challenge.gmh.hotel.model.entity.Hotel;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Data {
    public static final Hotel HOTEL = Hotel.builder().id("1").stars(5).name("Hotel Test").build();
    public static final HotelRequest HOTEL_REQUEST = HotelRequest.builder().stars(5)
            .hotelName("Hotel Test").build();
    public static final Optional<Hotel> OPTIONAL_HOTEL = Optional.of(Hotel.builder().id("1").stars(5).name("Hotel 1").build());
    public static final List<Hotel> HOTELS = Arrays.asList(Hotel.builder().id("1").stars(5).name("Hotel 1").build(),
            Hotel.builder().id("2").stars(5).name("Hotel 2").build());
}
