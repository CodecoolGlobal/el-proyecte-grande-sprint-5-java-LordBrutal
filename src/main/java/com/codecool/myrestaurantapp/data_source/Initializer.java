package com.codecool.myrestaurantapp.data_source;

import com.codecool.myrestaurantapp.service.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    private CustomerDaoMem customerDaoMem;
    private IngredientsDaoMem ingredientsDaoMem;
    private OrderDaoMem orderDaoMem;
    private ReceiptDaoMem receiptDaoMem;



    private void initializer() {

    }

    @Autowired
    public Initializer(CustomerDaoMem customerDaoMem, IngredientsDaoMem ingredientsDaoMem, OrderDaoMem orderDaoMem, ReceiptDaoMem receiptDaoMem) {
        this.customerDaoMem = customerDaoMem;
        this.ingredientsDaoMem = ingredientsDaoMem;
        this.orderDaoMem = orderDaoMem;
        this.receiptDaoMem = receiptDaoMem;
        initializer();
    }
}
