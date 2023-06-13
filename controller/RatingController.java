package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.Rating;
import com.example.demo.entity.User;
import com.example.demo.services.ProductServices;
import com.example.demo.services.RatingServices;
import com.example.demo.services.UserServices;

@RestController

public class RatingController {

	
	@Autowired
	RatingServices ratingServices;
	@Autowired
	UserServices userServices;
	@Autowired
	ProductServices productServices;
	
	
	@GetMapping("/getRating")
	public List<Map<String, Object>> getAll() {
		return ratingServices.getRatings();
	}

	@PostMapping("/addRating")
	public String addUser(@RequestBody Rating rating) {
		
		User user=userServices.findUserById(rating.getUser().getUserId());
		if(user!=null) {
			Product product =productServices.findByProductId(rating.getProducts().getProductId());
			if(product!=null) {
				rating.setProducts(product);
				rating.setUser(user);
				ratingServices.addRating(rating);
			}else{
				return "Product not found ...";
			}
		}else {
			return "user not found...";
		}
		
		return "ratting added...";
		
	}
	
	@GetMapping("/ratingByUser/{ratingId}")
    public Rating getRatingById(@PathVariable Integer ratingId) {
        return ratingServices.findByRatingId(ratingId);
    }
	
	@GetMapping("/ratingByProduct/{productId}")
	public List<Map<String, Object>> getRatingByProduct(@PathVariable("productId") Integer id)
	{
		return ratingServices.findRattingByProductId(id);
	}
}
