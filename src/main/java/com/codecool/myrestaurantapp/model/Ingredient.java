package com.codecool.myrestaurantapp.model;

import com.codecool.myrestaurantapp.model.entity.IngredientEntity;
import com.codecool.myrestaurantapp.model.type.UnitOfMeasureType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class Ingredient {

    private String name;
    private BigDecimal price;
    private UnitOfMeasureType unitType;

    public Ingredient(IngredientEntity ingredientEntity){
        this.name = ingredientEntity.getName();
        this.price = ingredientEntity.getPrice();
        this.unitType = ingredientEntity.getUnitType();
    }
}
