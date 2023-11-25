package com.pizzaHub.pizzahub.persitence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "pizza")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class PizzaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pizza", nullable = false)
	private Integer idPizza;
	
	@Column(nullable = false, length = 30, unique = true)
	private String name;
	
	@Column(nullable = false, length = 150)
	private String description;
	
	@Column(nullable = false, columnDefinition = "Decimal(5,2)")
	private Double price;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean vegetarian;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean vegan;
	
	@Column(columnDefinition = "TINYINT", nullable = false)
	private Boolean available;

	@Column(name = "created_date")
	@CreatedDate
	@JsonIgnore
	private LocalDateTime createdDate;

	@Column(name = "modified_date")
	@LastModifiedDate
	@JsonIgnore
	private LocalDateTime modifiedDate;

}
