package com.codecool.myrestaurantapp.controller;

import com.codecool.myrestaurantapp.model.Order;
import com.codecool.myrestaurantapp.model.Receipt;
import com.codecool.myrestaurantapp.service.OrderService;
import com.codecool.myrestaurantapp.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/")
public class ApiController {

    OrderService orderService;
    ReceiptService receiptService;

    @Autowired
    public ApiController(OrderService orderService, ReceiptService receiptService) {
        this.orderService = orderService;
        this.receiptService = receiptService;
    }

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
    public Order addOrder(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        String customerName = parameterMap.get("customer")[0];
        String[] foods = parameterMap.get("foods");
        return orderService.addNewOrder(foods,customerName);
    }

    @CrossOrigin
    @GetMapping(value = "/api/get-all-receipt")
    public Set<Receipt> getAllReceipt() {
        return receiptService.getAllReceipt();
    }

    @CrossOrigin
    @PostMapping(value = "/api/add-receipt")
    public Receipt addReceipt(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        String name = parameterMap.get("name")[0];
        String[] ingredients = parameterMap.get("ingredients");
        int price = Integer.parseInt(parameterMap.get("price")[0]);
        return receiptService.addNewReceipt(name, ingredients, price);
    }

    @CrossOrigin
    @PostMapping(value = "/api/add-ingredient")
    public String addIngredient(){
        return "";
    }

    @CrossOrigin
    @GetMapping(value = "/api/get-orders")
    public Set<Order> getActiveOrders(){
        return orderService.getActiveOrders();
    }

    @CrossOrigin
    @GetMapping(value = "/api/get-all-ingredient")
    public  String getAllIngredient(){
        return "";
    }


}
