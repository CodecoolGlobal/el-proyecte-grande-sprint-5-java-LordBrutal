package com.codecool.myrestaurantapp.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ApiController {

    @PostMapping(value = "/api/change-order-status")
    public String changeOrderStatus(){
        return "";
    }

    @PostMapping(value = "/api/add-customer")
    public String addNewUser(){
        return "";
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
