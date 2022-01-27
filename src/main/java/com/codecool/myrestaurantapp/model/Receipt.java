package com.codecool.myrestaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;

@Data
@AllArgsConstructor
@Builder
public class Receipt {

    private int id;
    private String name;
    private HashMap<String, Integer> ingredients;
    private BigDecimal price;
    private boolean isAvailable;
}
