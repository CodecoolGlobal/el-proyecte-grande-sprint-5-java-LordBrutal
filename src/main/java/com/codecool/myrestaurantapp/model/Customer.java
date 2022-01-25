package com.codecool.myrestaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Customer {

    private String name;
    private String email;
    private String phoneNumber;
    private Address address;
}
