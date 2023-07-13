package com.ecom.categoryservice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ecom.categoryservice.enums.Statu;
import com.ecom.categoryservice.models.Category;
import com.ecom.categoryservice.repositorys.CategoryRepository;

@SpringBootApplication
public class CategoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run( CategoryRepository categoryRepository) {
		return args -> {
			String[] list = {"Mobile phones","Game consoles","Household furniture","Home appliances","Clothing"};
			
			for (int i = 0; i < list.length; i++) {
				categoryRepository.save(Category.builder()
						.name(list[i])
						.statu((Math.random()<0.5?Statu.ACTIVE:Statu.INACTIVE))
						.build());
				
			}
		
		};
		
	}

}
