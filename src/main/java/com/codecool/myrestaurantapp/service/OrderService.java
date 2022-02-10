package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.*;
import com.codecool.myrestaurantapp.model.entity.*;
import com.codecool.myrestaurantapp.repository.CustomerEntityRepository;
import com.codecool.myrestaurantapp.repository.OrderEntityRepository;
import com.codecool.myrestaurantapp.repository.RecipeEntityrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

    OrderEntityRepository orderEntityrepository;
    RecipeEntityrepository recipeEntityrepository;
    CustomerEntityRepository customerEntityRepository;
    StorageService service;

    @Autowired
    public OrderService(OrderEntityRepository orderEntityrepository,
                        RecipeEntityrepository recipeEntityrepository,
                        CustomerEntityRepository customerEntityRepository,
                        StorageService service) {
        this.orderEntityrepository = orderEntityrepository;
        this.recipeEntityrepository = recipeEntityrepository;
        this.customerEntityRepository = customerEntityRepository;
        this.service = service;
    }

    public List<Order> getActiveOrders() {
         List<OrderEntity> orderEntities= orderEntityrepository.findAllByOrderStatusIsOrderByOrderTime(OrderStatus.IN_PROGRESS);
        return orderEntities.stream().map(Order::new).collect(Collectors.toList());
    }

    public Set<Order> getFulfilledOrders() {
        List<OrderEntity> orderEntities = orderEntityrepository.findAllByOrderStatusIsOrderByOrderTime(OrderStatus.COMPLETED);
        return orderEntities.stream().map(Order::new).collect(Collectors.toSet());
    }

    public HttpStatus addNewOrder(Map<String, String[]> parameterMap) {
        String[] foods = parameterMap.get("food");
        String customerId = parameterMap.get("customer")[0];
        List<RecipeEntity> orderElements = getReceipts(foods);
        CustomerEntity customer = customerEntityRepository.findCustomerEntityById(Long.parseLong(customerId));
        OrderEntity orderEntity = new OrderEntity(orderElements, customer, LocalDateTime.now(), OrderStatus.IN_PROGRESS);
        orderEntity.countTotalPrice();
        orderEntityrepository.save(orderEntity);
        modifyOrderRelatedIngredients(orderElements);
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

    private void modifyOrderRelatedIngredients(List<RecipeEntity> recipeEntityList) {
        for (RecipeEntity recipeEntity : recipeEntityList) {
            service.decreaseIngredientQuantity(recipeEntity.getIngredientEntityList());
        }
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
