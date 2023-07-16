package com.ecom.productservice.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.productservice.dtos.ProductDTO;
import com.ecom.productservice.entities.Product;
import com.ecom.productservice.exceptions.CategoryException;
import com.ecom.productservice.services.ICategoryService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Service
@AllArgsConstructor
public class ProductMapper {
	@Autowired
	ICategoryService categoryService;
	
	public Product formatProductRequestDtoToProduct(ProductDTO productDTO) throws CategoryException {
		Product p = Product.builder().label(productDTO.getLabel()).reference(productDTO.getReference())
				.description(productDTO.getDescription()).price(productDTO.getPrice())
				.category(categoryService.getCategoryById(productDTO.getId_category()))
				.build();
		return p;
	}

}
