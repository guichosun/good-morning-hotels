package com.challenge.gmh.hotels.service;

import com.challenge.gmh.hotel.client.RoomsFeignClient;
import com.challenge.gmh.hotel.model.entity.Hotel;
import com.challenge.gmh.hotel.model.response.RoomResponse;
import com.challenge.gmh.hotel.repository.HotelRepository;
import com.challenge.gmh.hotel.repository.TestHotelRepository;
import com.challenge.gmh.hotel.sevice.FeignHotelService;
import com.challenge.gmh.hotel.sevice.HotelService;
import com.challenge.gmh.hotels.data.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsoDeSpiasHotelServiceTest {

    @Mock
    RoomsFeignClient feignClient;

    @Spy
    TestHotelRepository repository;
    @InjectMocks
    FeignHotelService service;

    @Test
    void create_CreacionEn_Runtime() {
        // given
        RoomsFeignClient feignClient = mock(RoomsFeignClient.class);
        HotelRepository repository = Mockito.spy(TestHotelRepository.class);
        HotelService service = new FeignHotelService(feignClient, repository);

        doReturn(Data.HOTELS).when(repository).findByNameAndStars(anyString(),anyInt());

        doReturn(Data.HOTEL).when(repository).save(any(Hotel.class));

        // when
        Optional<Hotel> hotel = service.create(Data.HOTEL_REQUEST);

        // return
        assertNotNull(hotel);
    }

    @Test
    void create_Creacion_UsamdoAnnotation() {
        // given

        // Asi llamo al metodo real
        when(repository.findByNameAndStars(anyString(),anyInt())).thenReturn(Data.HOTELS);
        //doReturn(Data.HOTELS).when(repository).findByNameAndStars(anyString(),anyInt());

        doReturn(Data.HOTEL).when(repository).save(any(Hotel.class));

        // when
        Optional<Hotel> hotel = service.create(Data.HOTEL_REQUEST);

        // return
        assertNotNull(hotel);
    }

    @Test
    void retrieveById_whenExist() {
        // Para usar spy, solo a clases concretas.
        HotelRepository hr = spy(TestHotelRepository.class);
        RoomsFeignClient feignClient = spy(RoomsFeignClient.class);
        HotelService hotelService = new FeignHotelService(feignClient, hr);

        // Mockeamos el spy hr
        when(hr.findById(anyString())).thenReturn(Optional.of(Data.HOTEL));

        List<RoomResponse> rooms = Arrays.asList(RoomResponse.builder()
                .id("1").roomNo(333).withJacussi(true).build());
        when(feignClient.getRoomsByHotel(anyString())).thenReturn(rooms);

        Optional<Hotel> optionalHotel = hotelService.retrieveById("666");

        // return
        assertTrue(optionalHotel.isPresent());
        assertFalse(optionalHotel.get().getRooms().isEmpty());
//
//        log.info(String.format("El id %s",id));
//        Hotel hotel = hotelRepository.findById(id).orElseThrow(RuntimeException::new);
//        hotel.setRooms(feignClient.getRoomsByHotel(hotel.getId()));
//        return Optional.of(hotel);
    }

    /**
     * Test para validar cuando un repositorio no encuentra un hotely devuelve una exception
     */
    @Test
    void retrieveById_whenNotExist() {
        // Para usar spy, solo a clases concretas.
        HotelRepository hr = spy(TestHotelRepository.class);
        RoomsFeignClient feignClient = spy(RoomsFeignClient.class);
        HotelService hotelService = new FeignHotelService(feignClient, hr);

        // Mockeamos el spy hr
        when(hr.findById(anyString())).thenThrow(RuntimeException.class);


        Exception exception = assertThrows(RuntimeException.class, () -> {
            Optional<Hotel> optionalHotel = hotelService.retrieveById("666");
        });
        verify(feignClient, never()).getRoomsByHotel("666");
        // return
        assertEquals(RuntimeException.class, exception.getClass());
    }
}