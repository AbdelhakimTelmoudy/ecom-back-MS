package com.ecom.productservice.services;


import org.springframework.data.domain.Page;
import com.ecom.productservice.dtos.CategoryDTO;
import com.ecom.productservice.entities.Category;
import com.ecom.productservice.exceptions.CategoryException;

public interface ICategoryService {
	public Category getCategoryById(Long id)  throws CategoryException  ;
	public  Page<Category> getCategoryByName(String name,int page,int size);
	public Category saveCategory(CategoryDTO categoryDTO) ;
	public Category updateCategory(Long id,CategoryDTO categoryDTO ) throws CategoryException ;
	public void deleteCategory(Long id) throws CategoryException ;

}
