package com.pizzaHub.pizzahub.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaHub.pizzahub.persitence.entity.PizzaEntity;
import com.pizzaHub.pizzahub.service.PizzaService;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
	
	private final PizzaService pizzaService;

	@Autowired
	public PizzaController(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}
	
	@GetMapping
	public ResponseEntity<List<PizzaEntity>> getAll() {
		return ResponseEntity.ok(this.pizzaService.getAll());
	}
	
	@GetMapping("/{idPizza}")
	// @PathVariable le indica que enlazaremos este elemento 
	public ResponseEntity<PizzaEntity> get(@PathVariable int idPizza) {
		return ResponseEntity.ok(this.pizzaService.get(idPizza));
	}
	
	@GetMapping("/available")
	public ResponseEntity<List<PizzaEntity>> getAvailable() {
		return ResponseEntity.ok(this.pizzaService.getAvailable());
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<PizzaEntity> getByName(@PathVariable String name) {
		return ResponseEntity.ok(this.pizzaService.getByName(name));
	}
	
	@GetMapping("/with/{ingredient}")
	public ResponseEntity<List<PizzaEntity>> getWith(@PathVariable String ingredient) {
		return ResponseEntity.ok(this.pizzaService.getWith(ingredient));
	}
	
	@GetMapping("/without/{ingredient}")
	public ResponseEntity<List<PizzaEntity>> getWithout(@PathVariable String ingredient) {
		return ResponseEntity.ok(this.pizzaService.getWithout(ingredient));
	}
	
	@PostMapping
	public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizza) {
		
		if (pizza.getIdPizza() == null || !this.pizzaService.exists(pizza.getIdPizza())) {
			return ResponseEntity.ok(this.pizzaService.save(pizza));
		}
		
		return ResponseEntity.badRequest().build();
		
	}
	
	@PutMapping
	public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza) {
		
		if (pizza.getIdPizza() != null || this.pizzaService.exists(pizza.getIdPizza())) {
			return ResponseEntity.ok(this.pizzaService.save(pizza));
		}
		
		return ResponseEntity.badRequest().build();
		
	}
	
	@DeleteMapping("/{idPizza}")
	public ResponseEntity<Void> delete(@PathVariable int idPizza) {
		if (this.pizzaService.exists(idPizza)) {
			this.pizzaService.delete(idPizza);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	

}
