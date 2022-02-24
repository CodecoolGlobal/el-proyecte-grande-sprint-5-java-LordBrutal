package com.codecool.myrestaurantapp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @OneToMany(mappedBy = "customer")
    List<OrderEntity> orders;

    public CustomerEntity(String name, String email, String phoneNumber, AddressEntity address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public CustomerEntity() {
    }
}
