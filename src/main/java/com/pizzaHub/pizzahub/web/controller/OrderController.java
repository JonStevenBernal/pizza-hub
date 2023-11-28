package com.pizzaHub.pizzahub.web.controller;

import java.util.List;

import com.pizzaHub.pizzahub.persitence.projection.OrderSummary;
import com.pizzaHub.pizzahub.service.dto.RandomOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/outside")
	public ResponseEntity<List<OrderEntity>> getOutsideOrders() {
		return ResponseEntity.ok(this.orderService.getOutsideOrders());
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<List<OrderEntity>> getOutsideOrders(@PathVariable String id) {
		return ResponseEntity.ok(this.orderService.getCustomerOrders(id));
	}

	@GetMapping("/summary/{id}")
	public ResponseEntity<OrderSummary> getSummary(@PathVariable int id) {
		return ResponseEntity.ok(this.orderService.getSummary(id));
	}

	@PostMapping("/random")
	public ResponseEntity<Boolean> randomOrder(@RequestBody RandomOrderDto dto) {
		return ResponseEntity.ok(this.orderService.saveRandomOrder(dto));
	}
	

}
