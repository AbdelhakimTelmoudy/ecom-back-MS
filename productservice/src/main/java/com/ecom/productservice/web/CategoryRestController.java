package com.ecom.productservice.web;

 
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecom.productservice.dtos.CategoryDTO;
import com.ecom.productservice.entities.Category;
import com.ecom.productservice.exceptions.CategoryException;
import com.ecom.productservice.services.ICategoryService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("categories")
public class CategoryRestController {
	
	private ICategoryService categoryService;
	
	
	@GetMapping("/pagination")
	public Page<Category> getProductByReferenc(@RequestParam(name = "name",defaultValue = "") String name,
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "size",defaultValue = "6") int size) {
		return categoryService.getCategoryByName(name,page,size);
	}
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable Long id) throws CategoryException{
		return categoryService.getCategoryById(id);
	}
	@PostMapping("/")
	public Category saveCategory(@RequestBody CategoryDTO categoryDTO){
		return categoryService.saveCategory(categoryDTO);
	}
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id,@RequestBody CategoryDTO categoryDTO) throws CategoryException{
		return categoryService.updateCategory(id,categoryDTO);
	}

	@DeleteMapping("/{id}")
	public void updateCategory(@PathVariable Long id) throws CategoryException{
		categoryService.deleteCategory(id);
	}

}
