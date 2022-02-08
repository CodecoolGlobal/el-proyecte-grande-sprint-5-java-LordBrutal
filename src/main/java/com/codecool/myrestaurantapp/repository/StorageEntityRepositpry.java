package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageEntityRepositpry extends JpaRepository<StorageEntity, Long> {
}
