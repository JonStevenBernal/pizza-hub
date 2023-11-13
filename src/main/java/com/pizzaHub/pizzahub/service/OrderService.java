package com.pizzaHub.pizzahub.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaHub.pizzahub.persitence.entity.OrderEntity;
import com.pizzaHub.pizzahub.persitence.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public List<OrderEntity> getAll() {
		
		List<OrderEntity> orders = this.orderRepository.findAll();
		
		orders.forEach(o -> System.out.println(o.getCustomer().getName()));
		
		return orders;
	}
	
	public List<OrderEntity> getTodayOrders() {
		LocalDateTime today = LocalDate.now().atTime(0, 0);
		return this.orderRepository.findAllByDateAfter(today);
	}
	
	

}
