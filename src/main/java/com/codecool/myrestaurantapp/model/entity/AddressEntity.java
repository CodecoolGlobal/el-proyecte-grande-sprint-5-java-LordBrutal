package com.codecool.myrestaurantapp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String cityName;
    private String streetName;
    private int houseNumber;
    @OneToMany(mappedBy = "address")
    private Set<CustomerEntity> customers;

    public AddressEntity(String cityName, String streetName, int houseNumber) {
        this.cityName = cityName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public AddressEntity() {
    }
}
