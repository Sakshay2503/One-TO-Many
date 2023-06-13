package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.services.ProductServices;

@RestController
public class ProductController {

	@Autowired
	ProductServices productServices;

	@GetMapping("/getProduct")

	public List<ProductDto> getAll() {
		return productServices.getProducts();
	}

	@PostMapping("/addProduct")
	public String addUser(@RequestBody Product product) {
		productServices.addProduct(product);
		return "Product added...";
	}
	
	@GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable Integer productId) {
        return productServices.findByProductId(productId);
    }
}
