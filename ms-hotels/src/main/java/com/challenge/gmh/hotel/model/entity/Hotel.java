package com.challenge.gmh.hotel.model.entity;

import com.challenge.gmh.hotel.model.response.RoomResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Represents a hotels collection.
 *
 * @author guichosun.
 */
@Document(collection = "hotels")
@Getter
@Setter
@Builder
@ToString
public class Hotel {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field // Annotation Field is optional if the property name is same to the field name
    private String description;

    private Integer stars;

    @Transient
    private Integer port;

    @Field
    private List<Integer> rooms;
}
