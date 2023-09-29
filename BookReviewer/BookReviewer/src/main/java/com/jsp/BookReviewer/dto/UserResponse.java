package com.jsp.BookReviewer.dto;

import java.util.List;

import com.jsp.BookReviewer.model.Book;
import com.jsp.BookReviewer.model.Review;
import com.jsp.BookReviewer.model.UserRole;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class UserResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotEmpty(message="Name should not be null")
	private String userName;
	@NotEmpty(message="Email should be not empty")
	@Email(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}",message="invalid email address")
	private String userEmail;
	@NotEmpty
	@Pattern(regexp = "(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{8,}",message="minimum 8 characters mandatory(1 uppercase, 1 lower case, 1 special character,1 number)")
	private String userPassword;
	UserRole userRole;
	@OneToMany
	List<Book>books;
	@OneToMany
	List<Review>reviews;
	public int getUserId() {
		return userId;
	}
	public UserResponse setUserId(int userId) {
		this.userId = userId;
		return this;
	}
	public String getUserName() {
		return userName;
	}
	public UserResponse setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public UserResponse setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public UserResponse setUserPassword(String userPassword) {
		this.userPassword = userPassword;
		return this;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public UserResponse setUserRole(UserRole userRole) {
		this.userRole = userRole;
		return this;
	}
	public List<Book> getBooks() {
		return books;
	}
	public UserResponse setBooks(List<Book> books) {
		this.books = books;
		return this;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public UserResponse setReviews(List<Review> reviews) {
		this.reviews = reviews;
		return this;
	}
	
	

}
