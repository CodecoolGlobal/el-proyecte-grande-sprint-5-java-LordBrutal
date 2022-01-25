package com.codecool.myrestaurantapp.service.dao;

import com.codecool.myrestaurantapp.model.Customer;
import com.codecool.myrestaurantapp.model.Order;
import com.codecool.myrestaurantapp.model.Receipt;

import java.util.List;
import java.util.Set;

public interface OrderDAO {

    void addOrder(Order order);
    Set<Order> getActiveOrders();
    Set<Order> getFulfilledOrders();
    void deleteOrder(int orderId);
    void changeOrderStatus(int orderId);
}
