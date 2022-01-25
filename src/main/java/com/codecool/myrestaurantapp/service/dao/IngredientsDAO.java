package com.codecool.myrestaurantapp.service.dao;

import com.codecool.myrestaurantapp.model.Ingredient;

import java.util.Set;

public interface IngredientsDAO {
    void addIngredient(Ingredient ingredient);
    Set<Ingredient> getAllingredients();
}
