package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserByName(String name);
}