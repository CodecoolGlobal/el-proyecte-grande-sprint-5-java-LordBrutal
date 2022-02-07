package com.codecool.myrestaurantapp.model.entity;

import com.codecool.myrestaurantapp.model.type.UnitOfMeasureType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "ingredient")
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private BigDecimal price;
    private UnitOfMeasureType quantity;
}
