package com.codecool.myrestaurantapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ApiController {

    @CrossOrigin
    @PostMapping(value = "/api/change-order-status")
    public String changeOrderStatus(){
        return "";
    }

    @CrossOrigin
    @PostMapping(value = "/api/add-user")
    public String addNewUser(){
        return "";
    }

    @CrossOrigin
    @PostMapping(value = "/api/add-order")
    public String addOrder(){
        return "";
    }

    @CrossOrigin
    @GetMapping(value = "/api/get-all-receipt")
    public String getAllReceipt() {
        return "";
    }

    @CrossOrigin
    @PostMapping(value = "/api/add-receipt")
    public String addReceipt(){
        return "";
    }

    @CrossOrigin
    @PostMapping(value = "/api/add-ingredient")
    public String addIngredient(){
        return "";
    }

    @CrossOrigin
    @GetMapping(value = "/api/get-orders")
    public String getActiveOrders(){
        return "";
    }

    @CrossOrigin
    @GetMapping(value = "/api/get-all-ingredient")
    public  String getAllIngredient(){
        return "";
    }


}
