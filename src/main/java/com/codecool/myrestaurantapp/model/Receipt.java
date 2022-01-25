package com.codecool.myrestaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class Receipt {

    private String name;
    private Set<Ingredient> ingredients;
    private BigDecimal price;
    private boolean isAvailable;
}
