package com.codecool.myrestaurantapp.model.entity;

import com.codecool.myrestaurantapp.model.Ingredient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@Table(name = "recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToMany(mappedBy = "foods")
    private List<OrderEntity> orders;

    private String name;

    @ManyToMany
    private List<IngredientEntity> ingredients;
    private BigDecimal price;
    private boolean isAvailable;

    public RecipeEntity(List<OrderEntity> orders, String name, List<IngredientEntity> ingredients, BigDecimal price, boolean isAvailable) {
        this.orders = orders;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public RecipeEntity() {
    }
}
