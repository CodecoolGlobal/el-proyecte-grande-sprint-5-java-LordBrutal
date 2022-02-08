package com.codecool.myrestaurantapp.model;

import com.codecool.myrestaurantapp.model.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Order {

    private Long id;
    private List<RecipeOverview> foods;
    private Customer customer;
    private LocalDateTime orderTime;
    private BigDecimal totalPrice;
    private String formattedDateTime;

    public Order(OrderEntity orderEntity) {
        this.id = orderEntity.getId();
        this.foods = orderEntity.getFoods().stream().map(RecipeOverview::new).toList();
        this.customer = new Customer(orderEntity.getCustomer());
        this.orderTime = orderEntity.getOrderTime();
        this.totalPrice = orderEntity.getTotalPrice();
        formatDate();
    }
    private void formatDate() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    formattedDateTime = orderTime.format(format);
    }
}
