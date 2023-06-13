package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer>{
	List<Rating> findByUsersUserIdEquals(int id);
	
	List<Rating> findByProductsProductIdEquals(int id);
}
