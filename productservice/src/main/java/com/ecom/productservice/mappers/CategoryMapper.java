package com.ecom.productservice.mappers;

import org.springframework.stereotype.Service;

import com.ecom.productservice.dtos.CategoryDTO;
import com.ecom.productservice.entities.Category;

import lombok.NoArgsConstructor;
@Service
public class CategoryMapper {

	public Category formatCategoryDtoToCategory(CategoryDTO categoryDTO) {
		Category c = Category.builder()
				.name(categoryDTO.getName())
				.statu(categoryDTO.getStatu())
				.build();
		return c;
	}

}
