package com.codecool.myrestaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Receipt {

    private Long id;
    private String name;
    private List<RecipeIngredient> ingredientList;
    private BigDecimal price;
    private boolean isAvailable;
}
