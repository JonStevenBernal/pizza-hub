package com.pizzaHub.pizzahub.persitence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.pizzaHub.pizzahub.persitence.entity.OrderEntity;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {

	List<OrderEntity> findAllByDateAfter(LocalDateTime date);
	
}
