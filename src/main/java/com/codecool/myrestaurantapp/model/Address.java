package com.codecool.myrestaurantapp.model;

import com.codecool.myrestaurantapp.model.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Address {

    private String cityName;
    private String streetName;
    private int houseNumber;

    public Address(AddressEntity addressEntity) {
        this.cityName = addressEntity.getCityName();
        this.streetName = addressEntity.getStreetName();
        this.houseNumber = addressEntity.getHouseNumber();
    }
}
