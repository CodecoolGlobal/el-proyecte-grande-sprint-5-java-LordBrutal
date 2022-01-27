package com.codecool.myrestaurantapp.controller;

import com.codecool.myrestaurantapp.model.Customer;
import com.codecool.myrestaurantapp.model.Ingredient;
import com.codecool.myrestaurantapp.service.CustomerService;
import com.codecool.myrestaurantapp.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ApiController {

    CustomerService customerService;
    IngredientsService ingredientsService;

    @Autowired
    public ApiController(CustomerService customerService, IngredientsService ingredientsService) {
        this.customerService = customerService;
        this.ingredientsService = ingredientsService;
    }

    @PostMapping(value = "/api/change-order-status")
    public String changeOrderStatus(){
        return "";
    }

    @PostMapping(value = "/api/add-customer")
    public String addNewUser(HttpServletResponse response, HttpServletRequest request){
        customerService.addCustomer(request.getParameterMap());
        return "";
    }

    @GetMapping(value = "/api/get-all-customer")
    public Set<Customer> getAllCustomer(){
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
    public String addIngredient(HttpServletRequest request){
        ingredientsService.addIngredient(request.getParameterMap());
        return "";
    }

    @GetMapping(value = "/api/get-orders")
    public String getActiveOrders(){
        return "";
    }

    @GetMapping(value = "/api/get-all-ingredient")
    public Set<Ingredient> getAllIngredient(){
        return ingredientsService.getAllIngredients();
    }


}
