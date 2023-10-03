package com.cafe.Fooddelivery.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.Fooddelivery.Entity.User;
import com.cafe.Fooddelivery.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean registerUser(User userEntity) {
		userRepository.save(userEntity);
		return true;
	}

	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id : "+id));
		return user;
	}

}
