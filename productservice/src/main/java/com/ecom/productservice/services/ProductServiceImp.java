package com.ecom.productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import com.ecom.productservice.dtos.ProductDTO;
import com.ecom.productservice.entities.Product;
import com.ecom.productservice.exceptions.CategoryException;
import com.ecom.productservice.exceptions.ProductException;
import com.ecom.productservice.mappers.CategoryMapper;
import com.ecom.productservice.mappers.ProductMapper;
import com.ecom.productservice.repositorys.ProductRepository;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
@Transactional
public class ProductServiceImp implements IProductService {
	@Autowired(required=true)
	private ProductRepository productRepo;
	
	@Autowired(required=true)
	private ProductMapper productMapper;
	
	@Autowired(required=true)
	private ICategoryService categoryService;

	public Product getProductById(Long id) {
		return productRepo.findById(id).get();
	}

	public  Page<Product> getProductByReference(String reference,int page,int size) {
		 Page<Product> pageProducts=
				 productRepo.findByReferenceContaining(reference,PageRequest.of(page,size));
		return pageProducts;
	}
	
	
	public Product saveProduct(ProductDTO productDTO) throws CategoryException {
		Product product =productMapper.formatProductRequestDtoToProduct(productDTO);
		return productRepo.save(product);
	}

	public Product updateProduct(Long id,@RequestBody ProductDTO productDTO) throws ProductException, CategoryException {
		Product product =productRepo.findById(id).orElseThrow(() ->new ProductException("product " + id + " not fond "));
		
		try {
			product.setLabel(productDTO.getLabel());
			product.setDescription(productDTO.getDescription());
			product.setReference(productDTO.getReference());
			product.setPrice(productDTO.getPrice());
			product.setCategory(
					categoryService.getCategoryById(productDTO.getId_category()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("completLy");
		return productRepo.save(product);
	}
	public void deleteProduct(Long id) throws ProductException  {
		Product product =productRepo.findById(id).orElseThrow(() -> new ProductException("product " + id + " not fond "));
		productRepo.delete(product);
	}
}
