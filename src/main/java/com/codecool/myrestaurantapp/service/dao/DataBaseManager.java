package com.codecool.myrestaurantapp.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataBaseManager {

    private CustomerDAO customerDAO;
    private IngredientsDAO ingredientsDAO;
    private OrderDAO orderDAO;
    private ReceiptDAO receiptDAO;

    @Autowired
    public DataBaseManager(CustomerDAO customerDAO, IngredientsDAO ingredientsDAO, OrderDAO orderDAO, ReceiptDAO receiptDAO) {
        this.customerDAO = customerDAO;
        this.ingredientsDAO = ingredientsDAO;
        this.orderDAO = orderDAO;
        this.receiptDAO = receiptDAO;
    }
}
