package com.codecool.myrestaurantapp.service.dao;

import com.codecool.myrestaurantapp.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Repository
public class CustomerDaoMem implements CustomerDAO{
    private Set<Customer> customers = new HashSet<>();

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findCustomer(String name) {
        for (Customer customer: customers) {
            if (Objects.equals(customer.getName(), name)){
                return customer;
            }
        };
        return null;
    }

    @Override
    public void editCustomer(String name) {

    }

    @Override
    public void deleteCustomer(String name) {
        customers.removeIf(customer -> Objects.equals(customer.getName(), name));
    }


}
