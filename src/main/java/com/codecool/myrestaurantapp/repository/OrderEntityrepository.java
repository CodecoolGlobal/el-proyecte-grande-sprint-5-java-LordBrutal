package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityrepository extends JpaRepository<OrderEntity, Long> {
}
