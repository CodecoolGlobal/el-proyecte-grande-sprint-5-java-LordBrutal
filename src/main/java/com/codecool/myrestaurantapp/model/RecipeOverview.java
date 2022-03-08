package com.codecool.myrestaurantapp.model;

import com.codecool.myrestaurantapp.model.entity.RecipeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class RecipeOverview {

    private Long id;
    private String name;
    private BigDecimal price;
    private boolean isAvailable;

    public RecipeOverview(RecipeEntity recipeEntity) {
        this.id = recipeEntity.getId();
        this.name = recipeEntity.getName();
        this.price = recipeEntity.getPrice();
        this.isAvailable = recipeEntity.isAvailable();
    }
}
