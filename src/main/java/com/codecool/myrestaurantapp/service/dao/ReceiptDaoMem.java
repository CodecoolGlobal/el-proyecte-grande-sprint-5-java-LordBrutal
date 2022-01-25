package com.codecool.myrestaurantapp.service.dao;

import com.codecool.myrestaurantapp.model.Receipt;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ReceiptDaoMem implements ReceiptDAO{

    private Set<Receipt> receipts = new HashSet<>();

    @Override
    public void addNewReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    @Override
    public Receipt modifyReceipt(int receiptId) {
        for (Receipt receipt : receipts) {
            if (receiptId==receipt.getId()) {
                return receipt;
            }
        }
        return null;
    }

    @Override
    public void deleteReceipt(int receiptId) {
        receipts.removeIf(receipt -> receiptId == receipt.getId());
    }

    @Override
    public Set<Receipt> getAllReceipt() {
        return receipts;
    }
}
