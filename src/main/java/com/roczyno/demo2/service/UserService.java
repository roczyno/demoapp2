package com.roczyno.demo2.service;



import com.roczyno.demo2.entity.User;

import java.util.List;

public interface UserService {
	String createUser(User user);
	List<User> getAllUses();
	User updateUser(Integer userId, User request);
	String deleteUser(Integer userId);
	User getUser(Integer userId);
}
