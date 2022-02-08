package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.Address;
import com.codecool.myrestaurantapp.model.Customer;
import com.codecool.myrestaurantapp.model.entity.AddressEntity;
import com.codecool.myrestaurantapp.model.entity.CustomerEntity;
import com.codecool.myrestaurantapp.repository.AddressEntityRepository;
import com.codecool.myrestaurantapp.repository.CustomerEntityRepository;
import com.codecool.myrestaurantapp.service.dao.CustomerDaoMem;
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

    public void addCustomer(Map<String, String[]> parameters){
        String[] name = parameters.get("name");
        String[] email = parameters.get("email");
        String[] phoneNumber = parameters.get("phoneNumber");
        String[] cityName = parameters.get("cityName");
        String[] streetName = parameters.get("streetName");
        String[] houseNumberString =parameters.get("houseNumber");
        AddressEntity addressEntity = new AddressEntity(cityName[0],streetName[0],Integer.parseInt(houseNumberString[0]));
        addressEntity = addressEntityRepository.save(addressEntity);
        CustomerEntity customerEntity = new CustomerEntity(name[0],email[0],phoneNumber[0], addressEntity);
        customerEntityRepository.save(customerEntity);
    }

    public Set<Customer> getAllCustomer(){
        List<CustomerEntity> customerEntities = customerEntityRepository.findAll();
        Set<Customer> customers = new HashSet<>();
        for (CustomerEntity customerEntity: customerEntities) {
            AddressEntity addressEntity = customerEntity.getAddress();
            Address customerAdress = Address.builder().cityName(addressEntity.getCityName()).streetName(addressEntity.getStreetName()).houseNumber(addressEntity.getHouseNumber()).build();
            Customer customerConvert = Customer.builder().name(customerEntity.getName()).email(customerEntity.getEmail()).phoneNumber(customerEntity.getPhoneNumber()).address(customerAdress).build();
            customers.add(customerConvert);
        }
        return customers;
    }
}
