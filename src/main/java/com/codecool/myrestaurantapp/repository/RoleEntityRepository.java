package com.codecool.myrestaurantapp.repository;

import com.codecool.myrestaurantapp.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findRoleByName(String name);
}