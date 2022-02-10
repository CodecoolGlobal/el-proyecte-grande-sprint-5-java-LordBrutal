package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.IngredientEntity;
import com.codecool.myrestaurantapp.model.entity.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StorageEntityRepositpry extends JpaRepository<StorageEntity, Long> {

    StorageEntity findStorageEntityById(Long id);

    @Query("SELECT s FROM StorageEntity s where s.ingredient.id = ?1")
    Optional<StorageEntity> findByIngredientId(Long id);

}
