package com.ecom.categoryservice.web;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.categoryservice.models.Category;
import com.ecom.categoryservice.repositorys.CategoryRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CategoryRestController {
	
	private CategoryRepository categoryRepo;
	
	@GetMapping("/test")
	public String index(){
		return "hello i'm from category";
	}

	
	@GetMapping("/categorys")
	public List<Category> getCategorys(){
		return categoryRepo.findAll();
	}

}
