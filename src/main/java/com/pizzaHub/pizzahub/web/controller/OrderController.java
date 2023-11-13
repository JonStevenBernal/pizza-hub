package com.pizzaHub.pizzahub.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaHub.pizzahub.persitence.entity.OrderEntity;
import com.pizzaHub.pizzahub.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping
	public ResponseEntity<List<OrderEntity>> getAll() {
		return ResponseEntity.ok(this.orderService.getAll());
	}
	
	@GetMapping("/today")
	public ResponseEntity<List<OrderEntity>> getTodayOrders() {
		return ResponseEntity.ok(this.orderService.getTodayOrders());
	}
	

}
