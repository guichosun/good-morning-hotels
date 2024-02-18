package com.challenge.gmh.hotel.sevice;

import com.challenge.gmh.hotel.client.RoomsFeignClient;
import com.challenge.gmh.hotel.model.HotelRequest;
import com.challenge.gmh.hotel.model.RoomRequest;
import com.challenge.gmh.hotel.model.entity.Hotel;
import com.challenge.gmh.hotel.repository.HotelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
@Slf4j
@AllArgsConstructor
public class FeignHotelService implements HotelService {

    // Cliente feign
    private final RoomsFeignClient feignClient;

    private final HotelRepository hotelRepository;

    @Override
    public Optional<Hotel> create(HotelRequest hotel) {
        log.info("El hotel  a guardar {}",hotel);

        // Check  if doesn't exist by name
        List<Hotel> hotels = hotelRepository.findByNameAndStars(hotel.getHotelName(), hotel.getStars());
        log.info("Hoteles existendes {}",hotels.size());

        if(!hotels.isEmpty()) {
            log.info("Ya existe un hotel con ese nombre y stars");
            return Optional.empty();
        }

        // TODO Antes de guardar el hotel, primero hay que guardar los rooms. Si es que trae
        Optional<List<RoomRequest>> optionalRooms = Optional.ofNullable(hotel.getRooms());

        List<Integer> roomsids = List.of();
        if(optionalRooms.isPresent()) {
            roomsids = optionalRooms.get().stream()
                    .map(m -> m.getRoomNo())
                    .collect(Collectors.toList());
        }
        // Mapping
        Hotel hotelToSave = Hotel.builder().description(hotel.getDescription())
                .name(hotel.getHotelName())
                .stars(hotel.getStars())
                .rooms(roomsids)
                .build();

        Hotel hotelSaved = hotelRepository.save(hotelToSave);

        log.info("el hotelSaved.id {}",hotelSaved.getId());
        return Optional.of(hotelSaved);
    }

    /**
     * @see HotelService#retrieveAll()
     */
    @Override
    public Optional<List<Hotel>> retrieveAll() {
        log.info("va a recuperar todos los hoteles");
        Optional<List<Hotel>> opt = Optional.ofNullable(hotelRepository.findAll());
        opt.ifPresent(lst -> log.info("Hoteles encontrados {}",lst.size()));
        return opt;
    }

    @Override
    public Optional<Hotel> retrieveById(String id) {

        log.info(String.format("El id %s",id));
        Hotel hotel = hotelRepository.findById(id).orElseThrow(RuntimeException::new);
        log.info("El hotel encontrado {}",hotel);
        //hotel.setRooms(feignClient.getRoomsByHotel(hotel.getId()));
        return Optional.of(hotel);
    }


    @Override
    public void delHoel(Hotel hotel) {
hotelRepository.delete(hotel);
    }
}
