package com.codecool.myrestaurantapp.model;

import com.codecool.myrestaurantapp.model.entity.RecipeEntity;
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

    public Receipt(RecipeEntity recipeEntity) {
        this.id = recipeEntity.getId();
        this.name = recipeEntity.getName();
        this.ingredientList = recipeEntity.getIngredientEntityList()
                .stream()
                .map(RecipeIngredient::new)
                .toList();
        this.price = recipeEntity.getPrice();
        this.isAvailable = recipeEntity.isAvailable();
    }
}
