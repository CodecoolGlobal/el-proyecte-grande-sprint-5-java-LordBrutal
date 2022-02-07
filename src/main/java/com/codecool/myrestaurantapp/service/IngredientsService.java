package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.Ingredient;
import com.codecool.myrestaurantapp.model.type.UnitOfMeasureType;
import com.codecool.myrestaurantapp.service.dao.IngredientsDaoMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
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

    private UnitOfMeasureType findType(String typename){
        if (Objects.equals(typename, "GRAM")){
            return UnitOfMeasureType.GRAM;
        }else if (Objects.equals(typename, "MILLILITRE")){
            return UnitOfMeasureType.MILLILITRE;
        }else {
            return UnitOfMeasureType.PIECE;
        }
    }

    public void addIngredient(Map<String, String[]> parameters){
        String[] ingredientName = parameters.get("name");
        String[] priceAsString = parameters.get("price");
        String[] type = parameters.get("type");
        BigDecimal price =  BigDecimal.valueOf(Long.parseLong(priceAsString[0]));
        UnitOfMeasureType ingredientType = findType(type[0]);
        ingredientsDaoMem.addIngredient(Ingredient.builder()
                .name(ingredientName[0])
                .price(price)
                .quantity(ingredientType)
                .build());
    }
}
