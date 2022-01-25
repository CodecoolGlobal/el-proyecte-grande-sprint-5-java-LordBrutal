package com.codecool.myrestaurantapp.service.dao;

import com.codecool.myrestaurantapp.model.Customer;


public interface CustomerDAO {
    void addCustomer(Customer customer);
    Customer findCustomer(String name);
    void editCustomer(String name);
    void deleteCustomer(String name);

}
