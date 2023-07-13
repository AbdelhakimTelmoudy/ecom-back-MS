package com.ecom.productservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.productservice.models.Product;
import com.ecom.productservice.repositorys.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
public class ProductServiceImp implements IProductService {

	@Autowired
	private ProductRepository productRepo;

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(Long id) {
		return productRepo.findById(id).get();
	}

	public  List<Product> getProductByReference(String reference) {
		 List<Product> list = (List<Product>) productRepo.findByReferenceContaining(reference);

		if (list.isEmpty())
			throw new RuntimeException("product " + reference + " not fond ");

		return list;
	}

	public void deleteProduct(Long id) {

		productRepo.findById(id).orElseThrow(() -> new RuntimeException("product " + id + " not fond "));

	}
}
