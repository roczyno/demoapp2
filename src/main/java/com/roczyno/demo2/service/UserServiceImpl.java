package com.roczyno.demo2.service;


import com.roczyno.demo2.entity.User;
import com.roczyno.demo2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;

	@Override
	public String createUser(User user) {
		user.setCreatedAt(LocalDateTime.now());
		userRepository.save(user);
		return "User added successfully";
	}

	@Override
	public List<User> getAllUses() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Integer userId, User request) {
		User user=getUser(userId);
		if(request.getUsername()!=null){
			user.setUsername(request.getUsername());
		}
		if(request.getEmail()!=null){
			user.setEmail(request.getEmail());
		}
		if(request.getPhone()!=null){
			user.setPhone(request.getPhone());
		}
		return userRepository.save(user);
	}

	@Override
	public String deleteUser(Integer userId) {
		User user=getUser(userId);
		userRepository.delete(user);
		return "User Deleted successfully";
	}

	@Override
	public User getUser(Integer userId) {
		return userRepository.findById(userId)
				.orElseThrow(()-> new IllegalStateException("User not found"));
	}
}
