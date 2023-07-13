package com.ecom.productservice;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.ecom.productservice.models.Product;
import com.ecom.productservice.repositorys.ProductRepository;

@SpringBootApplication
@EnableFeignClients
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProductRepository productRepo) {
		return args -> {

			for (int i = 1; i < 11; i++) {

				new Product();
				productRepo.save(Product.builder().label("p" + i).reference(UUID.randomUUID().toString())
						.description("p" + i).price((double) Math.round((Math.random() * 1000))).build());
				new Product();
				productRepo.save(
						Product.builder().label("p" + (i * 2)).price((double) Math.round((Math.random() * 1000)))
								.reference(UUID.randomUUID().toString()).description("p" + (i * 2)).build());

			}
		};
	}

}
