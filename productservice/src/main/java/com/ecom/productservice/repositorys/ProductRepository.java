package com.ecom.productservice.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecom.productservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	 Page<Product> findByReferenceContaining(String name,Pageable pageable);


}
