package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.Customer;
import com.codecool.myrestaurantapp.model.Order;
import com.codecool.myrestaurantapp.model.Receipt;
import com.codecool.myrestaurantapp.service.dao.CustomerDaoMem;
import com.codecool.myrestaurantapp.service.dao.OrderDaoMem;
import com.codecool.myrestaurantapp.service.dao.ReceiptDaoMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class OrderService {

    OrderDaoMem orderDaoMem;
    ReceiptDaoMem receiptDaoMem;
    CustomerDaoMem customerDaoMem;

    @Autowired
    public OrderService(OrderDaoMem orderDaoMem, ReceiptDaoMem receiptDaoMem, CustomerDaoMem customerDaoMem) {
        this.orderDaoMem = orderDaoMem;
        this.receiptDaoMem = receiptDaoMem;
        this.customerDaoMem = customerDaoMem;
    }

    public Set<Order> getActiveOrders() {
         return orderDaoMem.getActiveOrders();
    }

    public Set<Order> getFulfilledOrders() {
        return orderDaoMem.getFulfilledOrders();
    }

    public void addNewOrder(Map<String, String[]> parameterMap) {
        String[] foods = parameterMap.get("food");
        String customerName = parameterMap.get("customer")[0];
        List<Receipt> orderElements = getReceipts(foods);
        Customer customer = customerDaoMem.findCustomer(customerName);
        Order newOrder = Order.builder()
                .foods(orderElements)
                .id(orderDaoMem.getStoredOrdersNumber()+1)
                .orderTime(LocalDateTime.now())
                .customer(customer)
                .build();
        newOrder.countTotalPrice();
        orderDaoMem.addOrder(newOrder);
    }

    private List<Receipt> getReceipts(String[] foods) {
        List<Receipt> orderElements = new ArrayList<>();
        for (String food : foods) {
            for (Receipt receipt : receiptDaoMem.getAllReceipt()) {
                if (food.equals(receipt.getName())) {
                    orderElements.add(receipt);
                }
            }
        }
        return orderElements;
    }

    public void deleteOrder(int orderId) {
        orderDaoMem.deleteOrder(orderId);
    }

    public void updateOrder(String oderId, Map<String, String[]> parameterMap) {
        Order orderToUpdate = orderDaoMem.getOrderById(Integer.parseInt(oderId));
        List<Receipt> newFoods = getReceipts(parameterMap.get("food"));
        orderToUpdate.getFoods().addAll(newFoods);
        orderToUpdate.countTotalPrice();
    }

    public Set<Order> changeOrderStatus(int orderId) {
        orderDaoMem.changeOrderStatus(orderId);
        return orderDaoMem.getActiveOrders();
    }
}
