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

        RecipeEntity newRecipe = new RecipeEntity();
        newRecipe.setAvailable(true);
        newRecipe.setName(name);
        newRecipe.setPrice(BigDecimal.valueOf(Long.parseLong(price)));
        List<RecipeIngredientEntity> recipeIngredientEntityList = new ArrayList<>();
        newRecipe.setIngredientEntityList(recipeIngredientEntityList);

        newRecipe = recipeEntityrepository.save(newRecipe);

        for (int i = 0; i < ingredients.length; i++) {
            Long ingredientId = Long.parseLong(ingredients[i]);
            Long ingredientQuantity = Long.parseLong(quantity[i]);
            RecipeIngredientEntity recipeIngredientEntity = new RecipeIngredientEntity();
            recipeIngredientEntity.setIngredientEntity(ingredientEntityRepository.findIngredientEntityById(ingredientId));
            recipeIngredientEntity.setRecipeEntity(newRecipe);
            recipeIngredientEntity.setQuantity(ingredientQuantity);
            recipeIngredientEntityList.add(recipeIngredientEntity);
        }
        recipeIngredientEntityRepository.saveAll(recipeIngredientEntityList);
    }

    public Set<Receipt> getAllReceipt() {
        return receiptDaoMem.getAllReceipt();
    }
}
