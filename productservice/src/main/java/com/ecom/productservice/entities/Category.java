package com.ecom.productservice.entities;

import java.util.List;

import com.ecom.productservice.enums.Statu;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Category {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Statu statu;
	@OneToMany(mappedBy = "category")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Product> products;
	
	

}
