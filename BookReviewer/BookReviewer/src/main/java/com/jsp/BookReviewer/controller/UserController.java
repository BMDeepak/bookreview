package com.jsp.BookReviewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.BookReviewer.dto.UserRequest;
import com.jsp.BookReviewer.dto.UserResponse;
import com.jsp.BookReviewer.model.User;
import com.jsp.BookReviewer.service.UserService;
import com.jsp.BookReviewer.util.ResponseStructure;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(@RequestBody  UserRequest userRequest)
	{
		return service.saveUser(userRequest);
	}
	
	@GetMapping("/login/userEmail/{userEmail}/userPassword/{userPassword}")
	public User userLogin(@PathVariable String userEmail,@PathVariable String userPassword){
		return service.userLogin( userEmail,userPassword);
	}
	@PutMapping("/userId/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest userRequest,@PathVariable int userId)
	{
		return service.updateUser(userRequest, userId);
	}
	@GetMapping("/userId/{userId}")
	public User FindByUserId(@PathVariable int userId)
	{
		return service.findByUserId( userId);
	}
	@DeleteMapping("/userId/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> DeleteByUserId(@PathVariable int userId)
	{
		return service.deleteByUserId(userId);
	}
}
