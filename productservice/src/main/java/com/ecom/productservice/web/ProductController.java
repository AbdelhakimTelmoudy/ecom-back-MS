package com.ecom.productservice.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.productservice.models.Category;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.repositorys.ProductRepository;
import com.ecom.productservice.services.CategoryRestClientService;
import com.ecom.productservice.services.IProductService;
import com.ecom.productservice.services.ProductServiceImp;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductController {
	
	IProductService productService;
	CategoryRestClientService categoryRestClientService;
	
	@GetMapping("/products")
	public List<Product> getProductByReferenc(@RequestParam(name = "r",defaultValue = "") String r) {
		return productService.getProductByReference(r);
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	@GetMapping("/products/categorys")
	public List<Category> getCategorys() {
		return (List<Category>) categoryRestClientService.getCategorys();
	}
	
}
