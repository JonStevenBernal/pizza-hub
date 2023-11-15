package com.pizzaHub.pizzahub.persitence.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.pizzaHub.pizzahub.persitence.entity.PizzaEntity;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
	List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
	
	PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);
	
	List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String descripption);

	List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String descripption);
	int countByVeganTrue();
}
