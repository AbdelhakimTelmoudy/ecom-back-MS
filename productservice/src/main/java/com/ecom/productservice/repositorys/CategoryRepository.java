package com.ecom.productservice.repositorys;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.productservice.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Page<Category> findCategoryByNameContaining(String name,Pageable pageable);

}
