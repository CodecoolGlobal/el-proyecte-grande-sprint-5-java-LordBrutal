package com.codecool.myrestaurantapp.model.entity;

import com.codecool.myrestaurantapp.model.type.UnitOfMeasureType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ingredient")
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private BigDecimal price;
    private UnitOfMeasureType unitType;

    public IngredientEntity(String name, BigDecimal price, UnitOfMeasureType unitType) {
        this.name = name;
        this.price = price;
        this.unitType = unitType;
    }

    public IngredientEntity() {
    }
}
