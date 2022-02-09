package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.Receipt;
import com.codecool.myrestaurantapp.model.entity.RecipeEntity;
import com.codecool.myrestaurantapp.model.entity.RecipeIngredientEntity;
import com.codecool.myrestaurantapp.repository.IngredientEntityRepository;
import com.codecool.myrestaurantapp.repository.RecipeEntityrepository;
import com.codecool.myrestaurantapp.repository.RecipeIngredientEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ReceiptService {

    RecipeEntityrepository recipeEntityrepository;
    IngredientEntityRepository ingredientEntityRepository;
    RecipeIngredientEntityRepository recipeIngredientEntityRepository;

    @Autowired
    public ReceiptService(RecipeEntityrepository recipeEntityrepository, IngredientEntityRepository ingredientEntityRepository, RecipeIngredientEntityRepository recipeIngredientEntityRepository) {
        this.recipeEntityrepository = recipeEntityrepository;
        this.ingredientEntityRepository = ingredientEntityRepository;
        this.recipeIngredientEntityRepository = recipeIngredientEntityRepository;
    }

    public void addNewReceipt(Map<String, String[]> parameterMap) {
        String name = parameterMap.get("name")[0];
        String[] ingredients = parameterMap.get("ingredient");
        String[] quantity = parameterMap.get("quantity");
        String price = parameterMap.get("price")[0];

        HashMap<String, Integer> ingredientsList = new HashMap<>();

        for (int i = 0; i < ingredients.length; i++) {
            ingredientsList.put(ingredients[i], Integer.valueOf(quantity[i]));
        }

        Receipt newReceipt = Receipt.builder()
                .id(receiptDaoMem.getAllReceipt().size()+1)
                .ingredients(ingredientsList)
                .isAvailable(true)
                .name(name)
                .price(BigDecimal.valueOf(Long.parseLong(price)))
                .build();
        receiptDaoMem.addNewReceipt(newReceipt);
    }

    public Set<Receipt> getAllReceipt() {
        return receiptDaoMem.getAllReceipt();
    }
}
