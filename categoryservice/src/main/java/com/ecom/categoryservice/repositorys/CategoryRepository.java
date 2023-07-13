package com.ecom.categoryservice.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecom.categoryservice.models.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
