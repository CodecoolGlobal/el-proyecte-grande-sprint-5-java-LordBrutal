package com.codecool.myrestaurantapp.model;

import com.codecool.myrestaurantapp.model.entity.StorageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Storage {

    private Long id;
    private Ingredient ingredient;
    private Long quanity;


    public Storage(StorageEntity storageEntity) {
        this.id = storageEntity.getId();
        this.ingredient = new Ingredient(storageEntity.getIngredient());
        this.quanity = storageEntity.getQuantity();
    }


}
