package com.codecool.myrestaurantapp.controller;

import com.codecool.myrestaurantapp.model.Customer;
import com.codecool.myrestaurantapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ApiController {

    CustomerService customerService;

    @Autowired
    public ApiController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/api/change-order-status")
    public String changeOrderStatus(){
        return "";
    }

    @PostMapping(value = "/api/add-customer")
    public String addNewUser(){
        return "";
    }

    @GetMapping(value = "/api/get-all-customer")
    public Set<Customer> gettAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PostMapping(value = "/api/add-order")
    public String addOrder(){
        return "";
    }

    @GetMapping(value = "/api/get-all-receipt")
    public String getAllReceipt() {
        return "";
    }

    @PostMapping(value = "/api/add-receipt")
    public String addReceipt(){
        return "";
    }

    @PostMapping(value = "/api/add-ingredient")
    public String addIngredient(){
        return "";
    }

    @GetMapping(value = "/api/get-orders")
    public String getActiveOrders(){
        return "";
    }

    @GetMapping(value = "/api/get-all-ingredient")
    public  String getAllIngredient(){
        return "";
    }


}
