package com.codecool.myrestaurantapp.model;

import com.codecool.myrestaurantapp.model.entity.RecipeIngredientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredient {

    private Long id;
    private Ingredient ingredient;
    private Long quantity;

    public RecipeIngredient(RecipeIngredientEntity recipeIngredientEntity) {
        this.id = recipeIngredientEntity.getId();
        this.ingredient = new Ingredient(recipeIngredientEntity.getIngredientEntity());
        this.quantity = recipeIngredientEntity.getQuantity();
    }
}
