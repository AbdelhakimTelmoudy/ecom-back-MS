package com.ecom.productservice.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecom.productservice.dtos.ProductDTO;
import com.ecom.productservice.entities.Product;
import com.ecom.productservice.exceptions.CategoryException;
import com.ecom.productservice.exceptions.ProductException;
import com.ecom.productservice.services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
@RestController
@AllArgsConstructor
@RequestMapping("products")
public class ProductRestController {
	
	IProductService productService;
	
	@GetMapping("/pagination")
	public Page<Product> getProductByReferenc(@RequestParam(name = "r",defaultValue = "") String r,
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "size",defaultValue = "6") int size) {
		return productService.getProductByReference(r,page,size);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@PostMapping("/")
	public Product saveProduct(@RequestBody ProductDTO productDTO) {
		return productService.saveProduct(productDTO);
	}
	@PutMapping("/{id}")
	public Product updateProductById(@PathVariable Long id,@RequestBody ProductDTO productDTO) throws ProductException, CategoryException {
		return productService.updateProduct(id,productDTO);
	}
	@DeleteMapping("/{id}")
	public void updateCategory(@PathVariable Long id) throws ProductException{
		productService.deleteProduct(id);
	}
	
}
