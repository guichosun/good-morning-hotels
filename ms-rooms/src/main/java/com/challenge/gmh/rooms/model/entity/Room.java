package com.challenge.gmh.rooms.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Esta class represent a Collection
 */
@Document(collection = "rooms")
@Data
@Builder
public class Room {

    @Id
    private String id;

    @Field(name = "room-no")
    private Integer roomNo;

    @Field(name = "with-jacussi")
    private Boolean withJacussi;

    @Field(name = "hotel-id")
    private String hotelId;

    @Transient
    private Integer port;
}
