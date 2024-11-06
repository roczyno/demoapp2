package com.roczyno.demo2.controller;


import com.roczyno.demo2.entity.User;
import com.roczyno.demo2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class UserController {
	private final UserService userService;

	@GetMapping("/")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<>("WELCOME TO MY APP: JACOB SABBATH ADIABA. " +
				"for easy testing, I have included  swagger ui so head on to /swagger-ui/index.html to access the swagger ui for " +
				"testing without using postman", HttpStatus.OK);
	}
	@GetMapping("/hello")
	public ResponseEntity<String> hello1(){
		return new ResponseEntity<>("Hello from CI/CD", HttpStatus.OK);
	}
	@GetMapping("/jacob")
	public ResponseEntity<String> jacob(){
		return new ResponseEntity<>("Hello jacob", HttpStatus.OK);
	}

	@GetMapping("/hi")
	public ResponseEntity<String> hi(){
		return new ResponseEntity<>("Hi from CI/CD", HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody User user){
		return ResponseEntity.ok(userService.createUser(user));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable Integer userId){
		return ResponseEntity.ok(userService.getUser(userId));
	}
	@GetMapping("/user/")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUses());
	}

	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User request, @PathVariable Integer userId){
		return ResponseEntity.ok(userService.updateUser(userId,request));
	}

	@DeleteMapping("/user/{userId}")
	public String deleteUser(@PathVariable Integer userId){
		return userService.deleteUser(userId);
	}

}
