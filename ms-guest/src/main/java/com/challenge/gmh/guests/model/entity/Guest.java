package com.challenge.gmh.guests.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * Represent a Guest document
 *
 * @author guichosun
 */
@Document
@Data
public class Guest {

    @Id
    private String id;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field(name = "email")
    private String email;

    @Field(name = "type")
    // Se usa el campo name para buscar las entidades GuestType.
    @DocumentReference(lookup = "{ 'name' : ?#{#target} }")
    private GuestType guestType;
}
