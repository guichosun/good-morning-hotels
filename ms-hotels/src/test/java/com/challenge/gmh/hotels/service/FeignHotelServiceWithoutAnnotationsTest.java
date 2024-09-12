package com.challenge.gmh.hotels.service;

import com.challenge.gmh.hotel.client.RoomsFeignClient;
import com.challenge.gmh.hotel.model.entity.Hotel;
import com.challenge.gmh.hotel.model.response.RoomResponse;
import com.challenge.gmh.hotel.repository.HotelRepository;
import com.challenge.gmh.hotel.sevice.FeignHotelService;
import com.challenge.gmh.hotel.sevice.HotelService;
import com.challenge.gmh.hotels.data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class FeignHotelServiceWithoutAnnotationsTest {

    HotelRepository repoMock;

    RoomsFeignClient feignClientMock;

    HotelService service;

    @BeforeEach
    void setUp() {
        // Se crea un mock en runtime
        repoMock = mock(HotelRepository.class);

        // Se crea un mock en runtime
        feignClientMock = mock(RoomsFeignClient.class);

        service = new FeignHotelService(feignClientMock, repoMock);
    }

    @Test
    void retrieleAll() {
        List<RoomResponse> datosRoomsEmpty = Collections.emptyList();

        when(repoMock.findById(anyString())).thenReturn(Data.OPTIONAL_HOTEL);
        when(feignClientMock.getRoomsByHotel(anyString())).thenReturn(datosRoomsEmpty);

        Optional<Hotel> hotel = service.retrieveById("2");

        // Verifica que se haya ejecutado, 1 vez, este mock
        verify(feignClientMock, times(1)).getRoomsByHotel(anyString());
        assertTrue(hotel.isPresent());
        assertEquals("1",hotel.orElseThrow(RuntimeException::new).getId());
    }

    @Test
    void retrieveAll_EmptyList() {

//        HotelRepository repoMock = new HotelRepositoryImpl();

        // Se crea un mock en runtime
        HotelRepository repoMock = mock(HotelRepository.class);

        RoomsFeignClient feignClientMock = mock(RoomsFeignClient.class);

        when(repoMock.findById(Mockito.anyString())).thenThrow(RuntimeException.class);

        HotelService service = new FeignHotelService(feignClientMock, repoMock);

        assertThrows(RuntimeException.class, () -> {
           service.retrieveById("2");
        });

        // Por la exception nunca se invocaria
        verify(feignClientMock, never()).getRoomsByHotel(anyString());
    }
}