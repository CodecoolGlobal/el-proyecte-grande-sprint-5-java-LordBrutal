package com.codecool.myrestaurantapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

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
}
