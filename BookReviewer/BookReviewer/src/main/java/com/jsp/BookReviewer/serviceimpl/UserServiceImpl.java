package com.jsp.BookReviewer.serviceimpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.BookReviewer.dto.UserRequest;
import com.jsp.BookReviewer.dto.UserResponse;
import com.jsp.BookReviewer.exception.PasswordIncorrectException;
import com.jsp.BookReviewer.exception.UserNotFoundByEmailException;
import com.jsp.BookReviewer.exception.UserNotFoundById;
import com.jsp.BookReviewer.model.User;
import com.jsp.BookReviewer.repository.UserRepository;
import com.jsp.BookReviewer.service.UserService;
import com.jsp.BookReviewer.util.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ResponseStructure<UserResponse> responseStructure;

	@Autowired
	private UserRepository repository;

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequest userRequest) {
		User user = mapper.map(userRequest, User.class);
		user = repository.save(user);

		UserResponse response = mapper.map(user, UserResponse.class);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("User created successfully");
		responseStructure.setData(response);
		return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure, HttpStatus.CREATED);
	}
	
	@Override
	public User findByUserId(int userId) {
		Optional<User> user= repository.findById(userId);
		if(user.isPresent())
		{
			return user.get();
		}
		else {
			throw new UserNotFoundById("Failed to update ,User Id not found");
		}
	}
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> updateUser(UserRequest userRequest, int userId) {
		Optional<User> user= repository.findById(userId);
		if(user.isPresent())
		{
		User user1 = mapper.map(userRequest, User.class);
		user1.setUserId(userId);
		User user2 = repository.save(user1);

		UserResponse response = mapper.map(user2, UserResponse.class);
		responseStructure.setStatus(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Employee updated successfully");
		responseStructure.setData(response);
		return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure, HttpStatus.ACCEPTED);
		}
		else {
			throw new UserNotFoundById("Failed to update ,User Id not found");
		}

	}

	@Override
	public User userLogin(String userEmail, String userPassword) {
		if (repository.findByUserEmail(userEmail) != null) {
			Optional<User> user = repository.findByUserEmail(userEmail);
			if (user.get().getUserPassword().equals(userPassword)) {
				return user.get();
			} else {
				throw new PasswordIncorrectException("Failed to login , Pls Enter valid password!!");
			}
		} else {
			throw new UserNotFoundByEmailException("Failed to login,Pls Enter valid email!!");

		}
	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> deleteByUserId(int userId) {
		Optional<User> optional=repository.findById(userId);
		if(optional.isPresent()) {
			User user = optional.get();
			repository.delete(user);
			UserResponse response = new UserResponse().setUserId(user.getUserId())
					.setUserName(user.getUserName()).setUserEmail(user.getUserEmail())
					.setUserPassword(user.getUserPassword()).setUserRole(user.getUserRole())
					.setBooks(user.getBooks()).setReviews(user.getReviews());
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("User deleted successfully");
			responseStructure.setData(response);
			return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.CREATED);
		}
		else {
			throw new UserNotFoundById("Failed to update ,User Id not found");
		}
	}

	

}
