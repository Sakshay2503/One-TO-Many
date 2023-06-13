package com.example.demo.services;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.RatingDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Rating;
import com.example.demo.repo.RatingRepo;

@Service
public class RatingServices {

	@Autowired
	RatingRepo ratingRepo;

	public void addRating(Rating rating) {
		ratingRepo.save(rating);
	}

	public List<Map<String, Object>> getRatings() {

		List<Map<String, Object>> allRattings = new LinkedList<>();
		List<Rating> r = ratingRepo.findAll();

		for (Rating rating : r) {
			Map<String, Object> map = new LinkedHashMap<>();
			RatingDto dto = new RatingDto();
			dto.setRatingId(rating.getRatingId());
			dto.setReview(rating.getReview());

			ProductDto productDto = new ProductDto();
			productDto.setProductId(rating.getProducts().getProductId());
			productDto.setPrice(rating.getProducts().getPrice());
			productDto.setProductName(rating.getProducts().getProductName());

			dto.setProducts(productDto);
			
			UserDto userDto = new UserDto();
			userDto.setUserId(rating.getUser().getUserId());
			userDto.setUserName(rating.getUser().getUserName());

			map.put("rating", dto);
			map.put("user", userDto);

			allRattings.add(map);

		}

		return allRattings;

	}

	public Rating findByRatingId(Integer ratingId) {
		return ratingRepo.findById(ratingId).orElse(null);
	}

	public List<RatingDto> findRattingsByUserId(int id) {
		List<Rating> ratings = ratingRepo.findByUsersUserIdEquals(id);
		List<RatingDto> dtos = new LinkedList<>();
		for (Rating rating : ratings) {
			RatingDto dto = new RatingDto();
			dto.setRatingId(rating.getRatingId());
			dto.setReview(rating.getReview());

			ProductDto productDto = new ProductDto();
			productDto.setProductId(rating.getProducts().getProductId());
			productDto.setPrice(rating.getProducts().getPrice());
			productDto.setProductName(rating.getProducts().getProductName());

			dto.setProducts(productDto);

			dtos.add(dto);
		}

		return dtos;
	}

	public List<Map<String, Object>> findRattingByProductId(int id) {
		List<Map<String, Object>> allRattings = new LinkedList<>();
		List<Rating> r = ratingRepo.findByUsersUserIdEquals(id);

		for (Rating rating : r) {
			Map<String, Object> map = new LinkedHashMap<>();
			RatingDto dto = new RatingDto();
			dto.setRatingId(rating.getRatingId());
			dto.setReview(rating.getReview());

			UserDto userDto = new UserDto();

			userDto.setUserId(rating.getUser().getUserId());
			userDto.setUserName(rating.getUser().getUserName());

			map.put("rating", dto);
			map.put("user", userDto);

			allRattings.add(map);

		}

		return allRattings;

	}
}
