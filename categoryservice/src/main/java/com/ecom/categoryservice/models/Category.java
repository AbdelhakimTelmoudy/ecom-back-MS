package com.ecom.categoryservice.models;

import com.ecom.categoryservice.enums.Statu;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	

}
