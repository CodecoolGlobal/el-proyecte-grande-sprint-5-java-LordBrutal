package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.Ingredient;
import com.codecool.myrestaurantapp.model.entity.IngredientEntity;
import com.codecool.myrestaurantapp.model.type.UnitOfMeasureType;
import com.codecool.myrestaurantapp.repository.IngredientEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class IngredientsService{

    IngredientEntityRepository ingredientEntityRepository;


    @Autowired
    public IngredientsService(IngredientEntityRepository ingredientEntityRepository) {
        this.ingredientEntityRepository = ingredientEntityRepository;
    }

    public Set<Ingredient> getAllIngredients(){
        Set<Ingredient> ingredients = new HashSet<>();
        List<IngredientEntity> ingredientEntityList = ingredientEntityRepository.findAll();
        for (IngredientEntity ingredientEntity: ingredientEntityList) {
            Ingredient ingredient = new Ingredient(ingredientEntity);
            ingredients.add(ingredient);
        }
        return ingredients;
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
        IngredientEntity ingredientEntity = new IngredientEntity(ingredientName[0],price,ingredientType);
        ingredientEntityRepository.save(ingredientEntity);
    }
}
