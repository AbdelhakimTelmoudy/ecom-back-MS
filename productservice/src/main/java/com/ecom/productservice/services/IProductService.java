package com.ecom.productservice.services;


import org.springframework.data.domain.Page;
import com.ecom.productservice.dtos.ProductDTO;
import com.ecom.productservice.entities.Product;
import com.ecom.productservice.exceptions.CategoryException;
import com.ecom.productservice.exceptions.ProductException;

public interface IProductService {
	public Product getProductById(Long id);
	public Page<Product> getProductByReference(String reference,int page,int size);
	public void deleteProduct(Long id) throws ProductException ;
	public Product saveProduct(ProductDTO productDTO) throws CategoryException;
	public Product updateProduct(Long id,ProductDTO productDTO) throws ProductException,CategoryException;

}
