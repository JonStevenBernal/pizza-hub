package com.pizzaHub.pizzahub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pizzaHub.pizzahub.persitence.entity.PizzaEntity;
import com.pizzaHub.pizzahub.persitence.repository.PizzaRepository;

@Service
public class PizzaService {
	// consultas dentro del servicio
//	private final JdbcTemplate jdbcTemplate;
	private final PizzaRepository pizzaRepository;

	@Autowired
	public PizzaService(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}
	
	// traer todos los registros
	public List<PizzaEntity> getAll() {
		// traer todo lo de la tabla pízza
//		return this.jdbcTemplate.query("SELECT * FROM pizza WHERE available = 1", new BeanPropertyRowMapper<>(PizzaEntity.class));
		return pizzaRepository.findAll();
	}
	
	public List<PizzaEntity> getAvailable() {
		return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
	}
	
	public PizzaEntity getByName(String name) {
		return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
	}
	
	// Traer solo un registro
	public PizzaEntity get(int idPizza) {
		// orElse usamos el optional programacion funcional, indicado que si no encuentra nada retorne null
		return this.pizzaRepository.findById(idPizza).orElse(null);
	}
	
	public PizzaEntity save(PizzaEntity pizza) {
		return this.pizzaRepository.save(pizza);
	}
	
	public void delete(int idPizza) {
		this.pizzaRepository.deleteById(idPizza);
	}
	
	public boolean exists(int idPizza) {
		return this.pizzaRepository.existsById(idPizza);
	}
	
}
