package com.challenge.gmh.guests.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Secondary document. Represents a guest type
 */
@Document
@Data
public class GuestType {

    @Id
    private String idType;

    @Field
    private String name;
}
