package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.OrderEntity;
import com.codecool.myrestaurantapp.model.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByOrderStatusIs(OrderStatus orderStatus);
    OrderEntity findOrderEntityById(Long id);
}
