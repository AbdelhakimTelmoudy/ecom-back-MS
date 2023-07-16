package com.ecom.productservice;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.ecom.productservice.entities.Category;
import com.ecom.productservice.entities.Product;
import com.ecom.productservice.enums.Statu;
import com.ecom.productservice.repositorys.CategoryRepository;
import com.ecom.productservice.repositorys.ProductRepository;

@SpringBootApplication
//@EnableFeignClients
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProductRepository productRepo,CategoryRepository categoryRepo) {
		return args -> {
			
			String[] names = {"Used Electronics","Cables","Mobile Phone","Computer Hardware","Software","Accessories"};
			

			for (int i = 1; i < names.length; i++) {
				categoryRepo.save(Category.builder()
						.name(names[i])
						.statu((Math.random()<0.5)? Statu.ACTIVE :Statu.INACTIVE)
						.build());}
			

			for (int i = 1; i < 11; i++) {

				new Product();
				productRepo.save(Product.builder().label("p" + i).reference(UUID.randomUUID().toString())
						.description("p" + i).price((double) Math.round((Math.random() * 1000)))
						.category(categoryRepo.findById(1L).get()).build());
			
				productRepo.save(
						Product.builder().label("p" + (i * 2)).price((double) Math.round((Math.random() * 1000)))
								.reference(UUID.randomUUID().toString()).description("p" + (i * 2))
								.category(categoryRepo.findById(2L).get()).build());

			}
		};
	}

}
