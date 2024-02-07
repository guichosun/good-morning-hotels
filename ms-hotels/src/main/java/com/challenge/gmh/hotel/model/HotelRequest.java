package com.challenge.gmh.hotel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Esta class represent the request data.
 */
@Getter
@Setter
@Builder
@ToString
public class HotelRequest {

    @NotBlank
    private String hotelName;

    @NotBlank
    private String description;

    @NotBlank
    private Integer stars;

    private List<RoomRequest> rooms;
}
