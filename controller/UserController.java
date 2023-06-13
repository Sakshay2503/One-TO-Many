package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RatingDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.services.RatingServices;
import com.example.demo.services.UserServices;

@RestController
public class UserController {

	@Autowired
	UserServices userServices;
	@Autowired
	RatingServices ratingServices;
	
	
	@GetMapping("/getUser")
	
	public List<UserDto> getAll()
	{
		return userServices.getUsers();
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user)
	{
		userServices.addUser(user);
		return "user added...";
	}
	
	@GetMapping("/user/{userId}")
    public User getRatingById(@PathVariable Integer userId) {
        return userServices.findUserById(userId);
    }
	@GetMapping("/getUserRattings/{id}")
	public List<RatingDto> getUserRattings(@PathVariable("id") int id ){
		return ratingServices.findRattingsByUserId(id);
	}
}
