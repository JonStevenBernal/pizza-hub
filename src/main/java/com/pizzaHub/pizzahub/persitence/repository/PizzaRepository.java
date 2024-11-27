package com.pizzaHub.pizzahub.persitence.repository;

import java.util.List;
import java.util.Optional;

import com.pizzaHub.pizzahub.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.pizzaHub.pizzahub.persitence.entity.PizzaEntity;
import org.springframework.data.repository.query.Param;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
	List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
	
//	PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);

	Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);
	List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

	List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
	List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
	int countByVeganTrue();

	@Query(value = "UPDATE pizza " +
			"SET price = :#{#newPizzaPrice.newPrice} " +
			"WHERE id_pizza = :#{#newPizzaPrice.pizzaId}", nativeQuery = true)
	@Modifying
	void updatePrice(@Param("newPizzaPrice") UpdatePizzaPriceDto newPizzaPrice);
}
