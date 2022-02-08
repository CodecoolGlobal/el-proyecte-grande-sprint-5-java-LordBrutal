package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressEntityRepository extends JpaRepository<AddressEntity, Long> {
}