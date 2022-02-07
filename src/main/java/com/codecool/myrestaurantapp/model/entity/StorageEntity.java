package com.codecool.myrestaurantapp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "storage")
public class StorageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private IngredientEntity ingredient;

    private Long quantity;

    public StorageEntity(IngredientEntity ingredient, Long quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public StorageEntity() {
    }
}
