package com.codecool.myrestaurantapp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToMany
    private List<RecipeEntity> foods;
    @ManyToOne
    private CustomerEntity customer;
    private LocalDateTime orderTime;
    private BigDecimal totalPrice;
    private OrderStatus orderStatus;

    public OrderEntity(List<RecipeEntity> foods, CustomerEntity customer, LocalDateTime orderTime, OrderStatus orderStatus) {
        this.foods = foods;
        this.customer = customer;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
    }

    public OrderEntity() {
    }

    public void countTotalPrice() {
        totalPrice = BigDecimal.ZERO;
        for (RecipeEntity food : foods) {
            totalPrice = totalPrice.add(food.getPrice());
        }
    }
}
