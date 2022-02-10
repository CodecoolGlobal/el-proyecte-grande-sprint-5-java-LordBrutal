package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.*;
import com.codecool.myrestaurantapp.model.entity.*;
import com.codecool.myrestaurantapp.repository.CustomerEntityRepository;
import com.codecool.myrestaurantapp.repository.OrderEntityRepository;
import com.codecool.myrestaurantapp.repository.RecipeEntityrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

    OrderEntityRepository orderEntityrepository;
    RecipeEntityrepository recipeEntityrepository;
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    public OrderService(OrderEntityRepository orderEntityrepository, RecipeEntityrepository recipeEntityrepository, CustomerEntityRepository customerEntityRepository) {
        this.orderEntityrepository = orderEntityrepository;
        this.recipeEntityrepository = recipeEntityrepository;
        this.customerEntityRepository = customerEntityRepository;
    }

    public Set<Order> getActiveOrders() {
         List<OrderEntity> orderEntities= orderEntityrepository.findAllByOrderStatusIs(OrderStatus.IN_PROGRESS);
        return orderEntities.stream().map(Order::new).collect(Collectors.toSet());
    }

    public Set<Order> getFulfilledOrders() {
        List<OrderEntity> orderEntities = orderEntityrepository.findAllByOrderStatusIs(OrderStatus.COMPLETED);
        return orderEntities.stream().map(Order::new).collect(Collectors.toSet());
    }

    public void addNewOrder(Map<String, String[]> parameterMap) {
        String[] foods = parameterMap.get("food");
        String customerId = parameterMap.get("customer")[0];
        List<RecipeEntity> orderElements = getReceipts(foods);
        CustomerEntity customer = customerEntityRepository.findCustomerEntityById(Long.parseLong(customerId));
        OrderEntity orderEntity = new OrderEntity(orderElements, customer, LocalDateTime.now(), OrderStatus.IN_PROGRESS);
        orderEntity.countTotalPrice();
        orderEntityrepository.save(orderEntity);
    }

    private List<RecipeEntity> getReceipts(String[] foods) {
        List<RecipeEntity> orderElements = new ArrayList<>();
        for (String food : foods) {
            for (RecipeEntity receipt : recipeEntityrepository.findAll()) {
                if (food.equals(receipt.getName())) {
                    orderElements.add(receipt);
                }
            }
        }
        return orderElements;
    }

    public void deleteOrder(Long orderId) {
        OrderEntity orderToDelete = orderEntityrepository.findOrderEntityById(orderId);
        orderEntityrepository.delete(orderToDelete);
    }

    public void updateOrder(String oderId, Map<String, String[]> parameterMap) {
        OrderEntity orderToUpdate = orderEntityrepository.findOrderEntityById(Long.parseLong(oderId));
        List<RecipeEntity> newFoods = getReceipts(parameterMap.get("food"));
        orderToUpdate.getFoods().addAll(newFoods);
        orderToUpdate.countTotalPrice();
        orderEntityrepository.save(orderToUpdate);
    }

    public Set<Order> changeOrderStatus(Long orderId) {
        OrderEntity orderToChangeStatus = orderEntityrepository.findOrderEntityById(orderId);
        orderToChangeStatus.setOrderStatus(OrderStatus.COMPLETED);
        orderEntityrepository.save(orderToChangeStatus);
        return getActiveOrders();
    }
}
