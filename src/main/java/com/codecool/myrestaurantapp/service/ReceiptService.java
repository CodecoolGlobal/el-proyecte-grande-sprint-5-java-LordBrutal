package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.Receipt;
import com.codecool.myrestaurantapp.service.dao.ReceiptDaoMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class ReceiptService {

    ReceiptDaoMem receiptDaoMem;

    @Autowired
    public ReceiptService(ReceiptDaoMem receiptDaoMem) {
        this.receiptDaoMem = receiptDaoMem;
    }

    public void addNewReceipt(Map<String, String[]> parameterMap) {
        String name = parameterMap.get("name")[0];
        String[] ingredients = parameterMap.get("ingredient");
        String[] quantity = parameterMap.get("quantity");
        String price = parameterMap.get("price")[0];

        HashMap<String, Integer> ingredientsList = new HashMap<>();

        for (int i = 0; i < ingredients.length; i++) {
            ingredientsList.put(ingredients[i], Integer.valueOf(quantity[i]));
        }

        Receipt newReceipt = Receipt.builder()
                .id(receiptDaoMem.getAllReceipt().size()+1)
                .ingredients(ingredientsList)
                .isAvailable(true)
                .name(name)
                .price(BigDecimal.valueOf(Long.parseLong(price)))
                .build();
        receiptDaoMem.addNewReceipt(newReceipt);
    }

    public Set<Receipt> getAllReceipt() {
        return receiptDaoMem.getAllReceipt();
    }
}
