package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServices {

	
	@Autowired
	ProductRepo productRepo;
	
	
	public void addProduct(Product product)
	{
		productRepo.save(product);
	}
	
	public List<ProductDto> getProducts()
	{
		
		List<Product> products= productRepo.findAll();
		
		List<ProductDto> result=new ArrayList<>();
		
		for (Product product : products) {
			
			ProductDto productDto=new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setPrice(product.getPrice());
			
			result.add(productDto);
			
		}
		return result;
				
	}
	
	public Product findByProductId(Integer productId)
	{
		return productRepo.findById(productId).orElse(null);
	}
}
