package com.pizzaHub.pizzahub.service;

import java.util.List;

import com.pizzaHub.pizzahub.persitence.repository.PizzaPagSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pizzaHub.pizzahub.persitence.entity.PizzaEntity;
import com.pizzaHub.pizzahub.persitence.repository.PizzaRepository;

@Service
public class PizzaService {
	// consultas dentro del servicio
//	private final JdbcTemplate jdbcTemplate;
	private final PizzaRepository pizzaRepository;

	private final PizzaPagSortRepository pizzaPagSortRepository;

	@Autowired
	public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
		this.pizzaRepository = pizzaRepository;
		this.pizzaPagSortRepository = pizzaPagSortRepository;
	}
	
	// traer todos los registros
	public Page<PizzaEntity> getAll(int page, int elements) {
		// traer todo lo de la tabla pízza
//		return this.jdbcTemplate.query("SELECT * FROM pizza WHERE available = 1", new BeanPropertyRowMapper<>(PizzaEntity.class));
//		return pizzaRepository.findAll();

		Pageable pageRequest = PageRequest.of(page, elements);
		return this.pizzaPagSortRepository.findAll(pageRequest);
	}
	
	public Page<PizzaEntity> getAvailable(int page, int elements, String sortBy, String sortDirection) {
		System.out.println(this.pizzaRepository.countByVeganTrue());
//		return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
		Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);

		Pageable pageRequest = PageRequest.of(page, elements, sort);
		return this.pizzaPagSortRepository.findByAvailableTrue(pageRequest);
	}
	
	public List<PizzaEntity> getWith(String ingredient) {
		return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
	}
	
	public List<PizzaEntity> getWithout(String ingredient) {
		return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
	}

	public List<PizzaEntity> getCheapest(double price) {
		return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
	}
	
	public PizzaEntity getByName(String name) {
		return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow( () -> new RuntimeException("La Pizza no existe"));
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
