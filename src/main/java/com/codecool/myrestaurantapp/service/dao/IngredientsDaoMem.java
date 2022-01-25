package com.codecool.myrestaurantapp.service.dao;

import com.codecool.myrestaurantapp.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class IngredientsDaoMem implements IngredientsDAO{
    Set<Ingredient> ingredients = new HashSet<>();

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public Set<Ingredient> getAllingredients() {
        return ingredients;
    }
}
