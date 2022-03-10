package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.Customer;
import com.codecool.myrestaurantapp.model.entity.AddressEntity;
import com.codecool.myrestaurantapp.model.entity.CustomerEntity;
import com.codecool.myrestaurantapp.repository.AddressEntityRepository;
import com.codecool.myrestaurantapp.repository.CustomerEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    CustomerEntityRepository customerEntityRepository;
    AddressEntityRepository addressEntityRepository;

    @Autowired
    public CustomerService(CustomerEntityRepository customerEntityRepository, AddressEntityRepository addressEntityRepository) {
        this.customerEntityRepository = customerEntityRepository;
        this.addressEntityRepository = addressEntityRepository;
    }

    public void addCustomer(CustomerEntity customerEntity){
        AddressEntity addressEntity = customerEntity.getAddress();
        addressEntity = addressEntityRepository.save(addressEntity);
        CustomerEntity customerNew = new CustomerEntity(customerEntity.getName(),customerEntity.getEmail(),customerEntity.getPhoneNumber(), addressEntity);
        customerEntityRepository.save(customerEntity);
    }

    public Set<Customer> getAllCustomer(){
        List<CustomerEntity> customerEntities = customerEntityRepository.findAll();
        Set<Customer> customers = new HashSet<>();
        for (CustomerEntity customerEntity: customerEntities) {
            Customer customer = new Customer(customerEntity);
            customers.add(customer);
        }
        return customers;
    }
}
