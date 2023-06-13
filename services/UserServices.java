package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserServices {

	@Autowired
	UserRepo userRepo;

	public void addUser(User user) {
		userRepo.save(user);
	}

	public List<UserDto> getUsers() {
		List<User> users= userRepo.findAll();
		
		List<UserDto> result=new ArrayList<>();
		
		for (User user : users) {
			
			UserDto userDto=new UserDto();
			userDto.setUserId(user.getUserId());
			userDto.setUserName(user.getUserName());
			result.add(userDto);
			
		}
		return result;

	}

	public User findUserById(Integer userId) {
		return userRepo.findById(userId).orElse(null);

	}

}
