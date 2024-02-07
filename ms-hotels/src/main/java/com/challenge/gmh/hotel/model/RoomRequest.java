package com.challenge.gmh.hotel.model;

import lombok.Builder;
import lombok.Data;

/**
 * Represents a requesting room.
 *
 * @author guichosun
 */
@Data
@Builder
public class RoomRequest {

    private Integer roomNo;

    private Boolean withJacussi;
}
