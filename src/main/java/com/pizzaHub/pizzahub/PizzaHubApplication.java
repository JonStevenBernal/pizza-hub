package com.pizzaHub.pizzahub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class PizzaHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaHubApplication.class, args);
	}

}