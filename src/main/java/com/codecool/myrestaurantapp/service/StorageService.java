package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.entity.IngredientEntity;
import com.codecool.myrestaurantapp.model.entity.StorageEntity;
import com.codecool.myrestaurantapp.repository.IngredientEntityRepository;
import com.codecool.myrestaurantapp.repository.StorageEntityRepositpry;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class StorageService {


    StorageEntityRepositpry storageEntityRepositpry;
    IngredientEntityRepository ingredientEntityRepository;

    public StorageService(StorageEntityRepositpry storageEntityRepositpry, IngredientEntityRepository ingredientEntityRepository) {
        this.storageEntityRepositpry = storageEntityRepositpry;
        this.ingredientEntityRepository = ingredientEntityRepository;
    }

    public void addIngredient(Map<String, String[]> parameters){
        String[] ingredientId = parameters.get("ingredient");
        String[] quantity = parameters.get("quantity");
        if(storageEntityRepositpry.findByIngredientId(Long.parseLong(ingredientId[0])).isPresent()){
            System.out.println("van benne");
            StorageEntity storageEntity = storageEntityRepositpry.findByIngredientId(Long.parseLong(ingredientId[0])).get();
            storageEntity.addQuantity(Long.parseLong(quantity[0]));
            storageEntityRepositpry.save(storageEntity);
        }else {
            IngredientEntity ingredientEntity = ingredientEntityRepository.findIngredientEntityById(Long.parseLong(ingredientId[0]));
            StorageEntity storageEntity = new StorageEntity(ingredientEntity,Long.parseLong(quantity[0]));
            storageEntityRepositpry.save(storageEntity);
        }

    }
}
