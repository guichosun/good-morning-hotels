package com.challenge.gmh.hotel.model.response;

import lombok.*;

/**
 * La respuesta de los Rooms
 */
@Data
@Builder
public class RoomResponse {

    private String id;

    private Integer roomNo;

    private Boolean withJacussi;

    private String hotelId;

    private Integer port;
}
