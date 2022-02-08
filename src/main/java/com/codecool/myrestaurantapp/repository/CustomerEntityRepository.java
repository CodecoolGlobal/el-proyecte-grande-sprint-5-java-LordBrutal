package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {
}