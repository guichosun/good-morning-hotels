package com.challenge.gmh.hotels.service;

import com.challenge.gmh.hotel.client.RoomsFeignClient;
import com.challenge.gmh.hotel.model.entity.Hotel;
import com.challenge.gmh.hotel.model.response.RoomResponse;
import com.challenge.gmh.hotel.repository.HotelRepository;
import com.challenge.gmh.hotel.sevice.FeignHotelService;
import com.challenge.gmh.hotels.data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)// Habilita el uso de las annotation. Es necesaria la dependencia mockito-junit-jupiter
class FeignHotelServiceWithAnnotationsTest {

    @Mock
    HotelRepository repoMock;

    @Mock
    RoomsFeignClient feignClientMock;

    @InjectMocks
    FeignHotelService service;

    @BeforeEach
    void setUp() {
        // una forma Para habilitar el uso de las annotations
        // MockitoAnnotations.openMocks(this);
    }

    @Test
    void retrieleAll() {
        List<RoomResponse> datosRoomsEmpty = Collections.emptyList();

        when(repoMock.findById(anyString())).thenReturn(Data.OPTIONAL_HOTEL);
        when(feignClientMock.getRoomsByHotel(anyString())).thenReturn(datosRoomsEmpty);

        Optional<Hotel> hotel = service.retrieveById("2");

        // Verifica que se haya ejecutado este mock
        verify(feignClientMock).getRoomsByHotel(anyString());
        assertTrue(hotel.isPresent());
        assertEquals("1",hotel.orElseThrow(RuntimeException::new).getId());
    }

    @Test
    void retrieveAll_EmptyList() {

        when(repoMock.findById(Mockito.anyString())).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> {
           service.retrieveById("2");
        });
    }

    @Test
    void createHotel_HP() {

        when(repoMock.findByNameAndStars(anyString(), anyInt()))
                .thenReturn(Data.HOTELS);
        when(repoMock.save(any(Hotel.class))).thenReturn(Data.HOTEL);

        Optional<Hotel> hotelSaved = service.create(Data.HOTEL_REQUEST);

        verify(repoMock).save(any(Hotel.class));
        assertNotNull(hotelSaved);
        assertTrue(hotelSaved.isPresent());
    }

    @Test
    void del_test() {

        // para mockear un metodo void es con doThrowzaqqaqmk,

        doThrow(RuntimeException.class).when(repoMock).delete(any(Hotel.class));

        assertThrows(RuntimeException.class, () ->{
            service.delHoel(Data.HOTEL);
        });

        verify(repoMock).delete(any(Hotel.class));
    }
}
