package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.Ingredient;
import com.codecool.myrestaurantapp.service.dao.IngredientsDaoMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class IngredientsService{

    IngredientsDaoMem ingredientsDaoMem;

    @Autowired
    public IngredientsService(IngredientsDaoMem ingredientsDaoMem) {
        this.ingredientsDaoMem = ingredientsDaoMem;
    }

    public Set<Ingredient> getAllIngredients(){
        return ingredientsDaoMem.getAllingredients();
    }
}
