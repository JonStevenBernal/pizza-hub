package com.pizzaHub.pizzahub.persitence.repository;

import com.pizzaHub.pizzahub.persitence.entity.PizzaEntity;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer> {

}
