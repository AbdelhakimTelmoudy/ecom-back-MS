package com.ecom.productservice.services;

import java.util.List;


import com.ecom.productservice.models.Product;

public interface IProductService {
	public List<Product> getAllProducts();
	public Product getProductById(Long id);
	public List<Product> getProductByReference(String reference);
	public void deleteProduct(Long id);

}
