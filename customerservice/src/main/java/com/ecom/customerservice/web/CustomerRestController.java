package com.ecom.customerservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
	
	@GetMapping("index")
	public String index() {
		return "hello i'm form customer service";
	}
}
