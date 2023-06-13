package com.example.demo.dto;

public class RatingDto {

	private int ratingId;

	private String review;

	private ProductDto products;


	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public ProductDto getProducts() {
		return products;
	}

	public void setProducts(ProductDto products) {
		this.products = products;
	}

}
