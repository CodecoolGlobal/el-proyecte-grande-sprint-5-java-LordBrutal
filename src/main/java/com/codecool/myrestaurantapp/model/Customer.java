package com.codecool.myrestaurantapp.model;

import com.codecool.myrestaurantapp.model.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Address address;

    public Customer(CustomerEntity customerEntity) {
        this.id = customerEntity.getId();
        this.name = customerEntity.getName();
        this.email = customerEntity.getEmail();
        this.address = new Address(customerEntity.getAddress());
        this.phoneNumber = customerEntity.getPhoneNumber();
    }
}
