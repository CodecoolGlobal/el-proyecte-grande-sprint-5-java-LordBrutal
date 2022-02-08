package com.codecool.myrestaurantapp.controller;

import com.codecool.myrestaurantapp.model.Customer;
import com.codecool.myrestaurantapp.model.Ingredient;
import com.codecool.myrestaurantapp.model.Order;
import com.codecool.myrestaurantapp.model.Receipt;
import com.codecool.myrestaurantapp.service.CustomerService;
import com.codecool.myrestaurantapp.service.IngredientsService;
import com.codecool.myrestaurantapp.service.OrderService;
import com.codecool.myrestaurantapp.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ApiController {

    CustomerService customerService;
    IngredientsService ingredientsService;
    OrderService orderService;
    ReceiptService receiptService;

    @Autowired
    public ApiController(CustomerService customerService, IngredientsService ingredientsService, OrderService orderService, ReceiptService receiptService) {
        this.customerService = customerService;
        this.ingredientsService = ingredientsService;
        this.orderService = orderService;
        this.receiptService = receiptService;
    }

    /**Ingredient related endpoints*/

    @PostMapping(value = "/api/add-ingredient")
    public void addIngredient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ingredientsService.addIngredient(request.getParameterMap());
        response.sendRedirect("http://localhost:3000/");
    }

    @GetMapping(value = "/api/get-all-ingredient")
    public Set<Ingredient> getAllIngredient(){
        return ingredientsService.getAllIngredients();
    }

    /**Receipt related endpoints*/

    @PostMapping(value = "/api/add-receipt")
    public void addReceipt(HttpServletRequest request, HttpServletResponse response) throws IOException {
        receiptService.addNewReceipt(request.getParameterMap());
        response.sendRedirect("http://localhost:3000/");
    }

    @GetMapping(value = "/api/get-all-receipt")
    public Set<Receipt> getAllReceipt() {
        return receiptService.getAllReceipt();
    }

    /**Customer related endpoint*/

    @PostMapping(value = "/api/add-customer")
    public void addNewCustomer(HttpServletResponse response, HttpServletRequest request) throws IOException {
        customerService.addCustomer(request.getParameterMap());
        response.sendRedirect("http://localhost:3000/");
    }

    @GetMapping(value = "/api/get-all-customer")
    public Set<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    /**Order related endpoints*/

    @GetMapping(value = "/api/change-order-status/{orderId}")
    public void changeOrderStatus(@PathVariable String orderId, HttpServletResponse response) throws IOException {
        orderService.changeOrderStatus(Long.parseLong(orderId));
        response.sendRedirect("http://localhost:3000/list-active-orders");
    }

    @PostMapping(value = "/api/add-order")
    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        orderService.addNewOrder(request.getParameterMap());
        response.sendRedirect("http://localhost:3000/list-active-orders");
    }

    @GetMapping(value = "/api/get-orders")
    public Set<Order> getActiveOrders(){
        return orderService.getActiveOrders();
    }

    @GetMapping(value = "/api/delete-order/{orderId}")
    public void deleteOrder(@PathVariable String orderId, HttpServletResponse response) throws IOException {
        orderService.deleteOrder(Long.parseLong(orderId));
        response.sendRedirect("http://localhost:3000/list-active-orders");
    }

    @PostMapping(value = "/api/update-order/{orderId}")
    public void updateOrder(@PathVariable String orderId, HttpServletResponse response, HttpServletRequest request) throws IOException {
        orderService.updateOrder(orderId, request.getParameterMap());
        response.sendRedirect("/");
    }



}
