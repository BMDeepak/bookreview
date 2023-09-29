package com.jsp.BookReviewer.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jsp.BookReviewer.dto.UserRequest;
import com.jsp.BookReviewer.dto.UserResponse;
import com.jsp.BookReviewer.model.User;
import com.jsp.BookReviewer.util.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequest userRequest);
	ResponseEntity<ResponseStructure<UserResponse>> updateUser(UserRequest userRequest,int userId);
	User userLogin(String userEmail,String userPassword);
	User findByUserId(int userId);
	ResponseEntity<ResponseStructure<UserResponse>> deleteByUserId(int userId);
	
		
}
