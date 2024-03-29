package com.challenge.gmh.hotel.sevice;

import com.challenge.gmh.hotel.client.RoomsFeignClient;
import com.challenge.gmh.hotel.model.entity.Hotel;
import com.challenge.gmh.hotel.repository.HotelRepository;
import com.challenge.gmh.hotel.sevice.HotelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@Slf4j
@AllArgsConstructor
public class FeignHotelService implements HotelService {

    // Cliente feign
    private final RoomsFeignClient feignClient;

    private final HotelRepository hotelRepository;

    @Override
    public Optional<Hotel> create(Hotel hotel) {
        log.info("El hotel  a guardar {}",hotel);

        // Check  if doesn't exist by name
        List<Hotel> hotels = hotelRepository.findByNameAndStars(hotel.getName(), hotel.getStars());
        log.info("Hoteles existendes {}",hotels.size());

        if(hotels.isEmpty()) {
            log.info("Ya existe un hotel con ese nombre y stars");
            return Optional.empty();
        }

        Hotel hotelSaved = hotelRepository.save(hotel);

        log.info("el hotelSaved.id {}",hotelSaved.getId());
        return Optional.of(hotelSaved);
    }

    @Override
    public Optional<Hotel> retrieveById(String id) {

        log.info(String.format("El id %s",id));
        Hotel hotel = hotelRepository.findById(id).orElseThrow(RuntimeException::new);
        log.info("El hotel encontrado {}",hotel);
        hotel.setRooms(feignClient.getRoomsByHotel(hotel.getId()));
        return Optional.of(hotel);
    }

    @Override
    public List<Hotel> retrieleAll() {
        return null;
    }

    @Override
    public void delHoel(Hotel hotel) {
hotelRepository.delete(hotel);
    }
}
