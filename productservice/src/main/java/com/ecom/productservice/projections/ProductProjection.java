package com.ecom.productservice.projections;

//import org.springframework.data.rest.core.config.Projection;

import com.ecom.productservice.entities.Category;
import com.ecom.productservice.entities.Product;



//@Projection(name = "fullProduct",types = Product.class)
public interface ProductProjection {
	public Long getId();
	public String getReference();
	public String getLabel();
	public String getDescription();
	public Double getPrice();
	public Category getCategory();

}
