package com.codecool.myrestaurantapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AppiController {

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
    @PostMapping(value = "/api/add-reciept")
    public String addReciept(){
        return "";
    }

    @CrossOrigin
    @PostMapping(value = "/api/add-ingredient")
    public String addIngredient(){
        return "";
    }

    @CrossOrigin
    @GetMapping(value = "/api/get-orders")
    public  String getOrders(){
        return "";
    }


}
