package com.ecom.productservice.mappers;

import com.ecom.productservice.dto.ProductRequestDTO;
import com.ecom.productservice.models.Product;

public class ProductMapper {

	public Product formatProductRequestDtoToProduct(ProductRequestDTO productDTO) {
		
		Product p = Product.builder().label(productDTO.getLabel()).reference(productDTO.getReference())
				.description(productDTO.getDescription()).price(productDTO.getPrice()).build();
		return p;
	}

}
