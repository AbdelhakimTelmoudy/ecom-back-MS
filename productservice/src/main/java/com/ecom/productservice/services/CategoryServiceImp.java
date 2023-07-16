package com.ecom.productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecom.productservice.dtos.CategoryDTO;
import com.ecom.productservice.entities.Category;
import com.ecom.productservice.exceptions.CategoryException;
import com.ecom.productservice.mappers.CategoryMapper;
import com.ecom.productservice.repositorys.CategoryRepository;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
@Transactional
@AllArgsConstructor
public class CategoryServiceImp implements ICategoryService {

	private CategoryRepository categoryRepo;
	
	private CategoryMapper categoryMapper;
	

	public Category getCategoryById(Long id) {
		return categoryRepo.findById(id).get();
	}
	public  Page<Category> getCategoryByName(String name,int page,int size) {
		 Page<Category> pageCategories=
				 categoryRepo.findCategoryByNameContaining(name,PageRequest.of(page,size));
		return pageCategories;
	}
	public Category saveCategory(CategoryDTO categoryDTO) {
		Category category =categoryMapper.formatCategoryDtoToCategory(categoryDTO);
		return categoryRepo.save(category);
	}
	public Category updateCategory(Long id,CategoryDTO categoryDTO ) throws CategoryException {
		Category category =categoryRepo.findById(id).orElseThrow(()->new CategoryException(""));
		return categoryRepo.save(category);
	}
	public void deleteCategory(Long id)  throws CategoryException  {
		Category category=categoryRepo.findById(id).orElseThrow(() -> new CategoryException("category " + id + " not fond "));
		categoryRepo.delete(category);
	}
}
