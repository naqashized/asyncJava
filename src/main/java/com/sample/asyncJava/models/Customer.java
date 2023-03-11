package com.sample.asyncJava.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
}
