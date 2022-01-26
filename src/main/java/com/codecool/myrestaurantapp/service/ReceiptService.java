package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.Receipt;
import com.codecool.myrestaurantapp.service.dao.ReceiptDaoMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

@Service
public class ReceiptService {

    ReceiptDaoMem receiptDaoMem;

    @Autowired
    public ReceiptService(ReceiptDaoMem receiptDaoMem) {
        this.receiptDaoMem = receiptDaoMem;
    }

    public Receipt addNewReceipt(String name, String[] ingredients, int price) {
        HashMap<String, Integer> ingredientsList = new HashMap<>();
        for (int i = 0; i < ingredients.length; i++) {
            if (i % 2 == 0) {
                ingredientsList.put(ingredients[i], Integer.valueOf(ingredients[i+1]));
            }
        }
        Receipt newReceipt = Receipt.builder()
                .id(receiptDaoMem.getAllReceipt().size()+1)
                .ingredients(ingredientsList)
                .isAvailable(true)
                .name(name)
                .price(BigDecimal.valueOf(price))
                .build();
        receiptDaoMem.addNewReceipt(newReceipt);
        return newReceipt;
    }

    public Set<Receipt> getAllReceipt() {
        return receiptDaoMem.getAllReceipt();
    }
}
