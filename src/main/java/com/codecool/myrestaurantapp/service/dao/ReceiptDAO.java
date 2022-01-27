package com.codecool.myrestaurantapp.service.dao;

import com.codecool.myrestaurantapp.model.Receipt;

import java.util.Set;

public interface ReceiptDAO {

    void addNewReceipt(Receipt receipt);
    Receipt modifyReceipt(int receiptId);
    void deleteReceipt(int receiptId);
    Set<Receipt> getAllReceipt();
}
