package com.codecool.myrestaurantapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppiController {

    @PostMapping(value = "/api/change-order-status")
    public String changeOrderStatus(){
        return "";
    }

    @PostMapping(value = "/api/add-user")
    public String addNewUser(){
        return "";
    }

    @PostMapping(value = "/api/add-order")
    public String addOrder(){
        return "";
    }

    @PostMapping(value = "/api/add-reciept")
    public String addReciept(){
        return "";
    }

    @PostMapping(value = "/api/add-ingredient")
    public String addIngredient(){
        return "";
    }

    @GetMapping(value = "/api/get-orders")
    public  String getOrders(){
        return "";
    }


}
