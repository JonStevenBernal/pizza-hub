package com.pizzaHub.pizzahub.persitence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.pizzaHub.pizzahub.persitence.entity.PizzaEntity;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
	List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
	
//	PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);

	Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);
	List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

	List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
	List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
	int countByVeganTrue();
}
