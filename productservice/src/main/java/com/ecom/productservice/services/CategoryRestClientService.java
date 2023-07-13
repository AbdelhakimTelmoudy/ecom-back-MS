package com.ecom.productservice.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecom.productservice.models.Category;

@FeignClient(name = "category-service",url = "http://localhost:8082")
public interface CategoryRestClientService {
    @GetMapping("/categorys")
    public List<Category> getCategorys();
}
