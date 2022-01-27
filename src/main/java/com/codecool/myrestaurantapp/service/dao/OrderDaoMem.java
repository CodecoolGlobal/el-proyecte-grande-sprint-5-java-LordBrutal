package com.codecool.myrestaurantapp.service.dao;

import com.codecool.myrestaurantapp.model.Order;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class OrderDaoMem implements OrderDAO{

    private Set<Order> activeOrders = new HashSet<>();
    private Set<Order> fulfilledOrders = new HashSet<>();

    public int getStoredOrdersNumber () {
        return activeOrders.size() + fulfilledOrders.size();
    }

    @Override
    public void addOrder(Order order) {
        activeOrders.add(order);
    }

    @Override
    public Set<Order> getActiveOrders() {
        return activeOrders;
    }

    @Override
    public Set<Order> getFulfilledOrders() {
        return fulfilledOrders;
    }

    @Override
    public void deleteOrder(int orderId) {
        activeOrders.removeIf(activeOrder -> activeOrder.getId() == orderId);
    }

    @Override
    public void changeOrderStatus(int orderId) {
        Order fulfilledOrder = getOrderById(orderId);

        if (fulfilledOrder!=null) {
            fulfilledOrders.add(fulfilledOrder);
            activeOrders.remove(fulfilledOrder);
        }
    }

    @Override
    public Order getOrderById(int orderId) {

        return activeOrders.stream().filter(order -> order.getId()==orderId).findFirst().orElse(null);

    }
}
