package com.ecom.productservice.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.ecom.productservice.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	 List<Product> findByReferenceContaining(String reference);

}
