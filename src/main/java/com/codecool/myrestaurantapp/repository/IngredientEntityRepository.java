package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientEntityRepository extends JpaRepository<IngredientEntity, Long> {

    IngredientEntity findIngredientEntityById(Long id);
}