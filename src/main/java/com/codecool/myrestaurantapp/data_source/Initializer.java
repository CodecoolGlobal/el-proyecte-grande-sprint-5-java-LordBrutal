package com.codecool.myrestaurantapp.data_source;

import com.codecool.myrestaurantapp.model.*;
import com.codecool.myrestaurantapp.model.type.UnitOfMeasureType;
import com.codecool.myrestaurantapp.service.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class Initializer {

    private CustomerDaoMem customerDaoMem;
    private IngredientsDaoMem ingredientsDaoMem;
    private OrderDaoMem orderDaoMem;
    private ReceiptDaoMem receiptDaoMem;



    private void initializer() {
        Address addressOne = Address.builder().cityName("Budapest").streetName("Nagymezo utca").houseNumber(66).build();
        Customer customerOne = Customer.builder().address(addressOne).email("alma@gmail.com").name("Kis Pista").phoneNumber("06201111111").build();
        Address addressTwo = Address.builder().cityName("Miskolc").streetName("Balint utca").houseNumber(50).build();
        Customer customerTwo = Customer.builder().address(addressTwo).email("zoli11@gmail.com").name("Zoltan tamas").phoneNumber("06204758888").build();
        Address addressThree = Address.builder().cityName("Nyíregyháza").streetName("Megmondo utca").houseNumber(1).build();
        Customer customerThree = Customer.builder().address(addressThree).email("tothirenke@gmail.com").name("Toth Irenke").phoneNumber("06505050213").build();
        customerDaoMem.addCustomer(customerOne);
        customerDaoMem.addCustomer(customerTwo);
        customerDaoMem.addCustomer(customerThree);
        Ingredient ingredientOne = Ingredient.builder().name("salt").price(BigDecimal.valueOf(200)).quantity(UnitOfMeasureType.GRAM).build();
        Ingredient ingredientTwo = Ingredient.builder().name("pepper").price(BigDecimal.valueOf(200)).quantity(UnitOfMeasureType.GRAM).build();
        Ingredient ingredientThree = Ingredient.builder().name("egg").price(BigDecimal.valueOf(1400)).quantity(UnitOfMeasureType.PIECE).build();
        Ingredient ingredientFour = Ingredient.builder().name("red wine").price(BigDecimal.valueOf(5000)).quantity(UnitOfMeasureType.MILLILITRE).build();
        Ingredient ingredientFive = Ingredient.builder().name("flour").price(BigDecimal.valueOf(310)).quantity(UnitOfMeasureType.GRAM).build();
        Ingredient ingredientSix = Ingredient.builder().name("beef").price(BigDecimal.valueOf(8000)).quantity(UnitOfMeasureType.GRAM).build();
        ingredientsDaoMem.addIngredient(ingredientOne);
        ingredientsDaoMem.addIngredient(ingredientTwo);
        ingredientsDaoMem.addIngredient(ingredientThree);
        ingredientsDaoMem.addIngredient(ingredientFour);
        ingredientsDaoMem.addIngredient(ingredientFive);
        ingredientsDaoMem.addIngredient(ingredientSix);
        HashMap<Ingredient, Integer> friedEggIngredients = new HashMap<>();
        friedEggIngredients.put(ingredientOne, 2);
        friedEggIngredients.put(ingredientThree, 3);
        HashMap<Ingredient, Integer> beefStewIngredients = new HashMap<>();
        beefStewIngredients.put(ingredientOne, 3);
        beefStewIngredients.put(ingredientTwo, 3);
        beefStewIngredients.put(ingredientSix, 200);
        beefStewIngredients.put(ingredientFour, 5);
        Receipt receiptFriedEggs = Receipt.builder().id(receiptDaoMem.getAllReceipt().size()).name("Fried eggs").isAvailable(true).ingredients(friedEggIngredients).build();
        Receipt receiptBeefStew = Receipt.builder().id(receiptDaoMem.getAllReceipt().size()).name("Beef stew").isAvailable(true).ingredients(beefStewIngredients).build();
        receiptDaoMem.addNewReceipt(receiptFriedEggs);
        receiptDaoMem.addNewReceipt(receiptBeefStew);
        List<Receipt> orderReceipt = new ArrayList<>();
        orderReceipt.add(receiptBeefStew);
        orderReceipt.add(receiptFriedEggs);
        Order order1 = Order.builder().id(orderDaoMem.getStoredOrdersNumber()).orderTime(LocalDateTime.now()).customer(customerOne).foods(orderReceipt).build();
        orderDaoMem.addOrder(order1);


    }

    @Autowired
    public Initializer(CustomerDaoMem customerDaoMem, IngredientsDaoMem ingredientsDaoMem, OrderDaoMem orderDaoMem, ReceiptDaoMem receiptDaoMem) {
        this.customerDaoMem = customerDaoMem;
        this.ingredientsDaoMem = ingredientsDaoMem;
        this.orderDaoMem = orderDaoMem;
        this.receiptDaoMem = receiptDaoMem;
        initializer();
    }
}
