package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.RecipeIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientEntityRepository extends JpaRepository<RecipeIngredientEntity, Long> {
}