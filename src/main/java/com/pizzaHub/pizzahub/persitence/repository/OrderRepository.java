package com.pizzaHub.pizzahub.persitence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.pizzaHub.pizzahub.persitence.entity.OrderEntity;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {

}
