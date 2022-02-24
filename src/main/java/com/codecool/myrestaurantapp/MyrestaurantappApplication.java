package com.codecool.myrestaurantapp;

import com.codecool.myrestaurantapp.model.entity.RoleEntity;
import com.codecool.myrestaurantapp.model.entity.UserEntity;
import com.codecool.myrestaurantapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;
import java.util.ArrayList;

@SpringBootApplication
public class MyrestaurantappApplication {

	private final static int ENCODER_STRENGTH = 10;

	public static void main(String[] args) {
		SpringApplication.run(MyrestaurantappApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(ENCODER_STRENGTH, new SecureRandom());
	}

	/** Initialize base roles, and default user */
/*
	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
			userService.saveRole(RoleEntity.builder().name("ROLE_USER").build());
			userService.saveRole(RoleEntity.builder().name("ROLE_MANAGER").build());
			userService.saveRole(RoleEntity.builder().name("ROLE_ADMIN").build());

			userService.saveUser(UserEntity.builder().name("user").password("1234").roleEntities(new ArrayList<>()).build());
		};
	}*/
}
