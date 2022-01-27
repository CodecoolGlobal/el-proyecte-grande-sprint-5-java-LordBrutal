package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.Address;
import com.codecool.myrestaurantapp.model.Customer;
import com.codecool.myrestaurantapp.service.dao.CustomerDaoMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class CustomerService {
    CustomerDaoMem customerDaoMem;

    @Autowired
    public CustomerService(CustomerDaoMem customerDaoMem) {
        this.customerDaoMem = customerDaoMem;
    }

    public void addCustomer(Map<String, String[]> parameters){
        String[] name = parameters.get("name");
        String[] email = parameters.get("email");
        String[] phoneNumber = parameters.get("phoneNumber");
        String[] cityName = parameters.get("cityName");
        String[] streetName = parameters.get("streetName");
        String[] houseNumberString =parameters.get("houseNumber");
        Address adress = Address.builder()
                .cityName(cityName[0])
                .streetName(streetName[0])
                .houseNumber(Integer.parseInt(houseNumberString[0]))
                .build();
        Customer customer = Customer.builder().name(name[0]).email(email[0]).phoneNumber(phoneNumber[0]).address(adress).build();
        System.out.println(customer);
        customerDaoMem.addCustomer(customer);
    }

    public Set<Customer> getAllCustomer(){
        return customerDaoMem.listAllCustomer();
    }
}
