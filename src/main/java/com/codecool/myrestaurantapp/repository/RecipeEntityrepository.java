package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeEntityrepository extends JpaRepository<RecipeEntity, Long> {
}
