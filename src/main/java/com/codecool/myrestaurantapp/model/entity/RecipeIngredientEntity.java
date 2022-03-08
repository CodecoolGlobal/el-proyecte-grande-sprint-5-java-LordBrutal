package com.codecool.myrestaurantapp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "recipe_ingredient")
public class RecipeIngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredientEntity;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipeEntity;
    private Long quantity;

}
