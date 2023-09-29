package com.jsp.BookReviewer.dto;

import java.util.List;

import com.jsp.BookReviewer.model.Book;
import com.jsp.BookReviewer.model.Review;
import com.jsp.BookReviewer.model.UserRole;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {
	@NotEmpty(message="Invalid Name")
	private String userName;
	@NotEmpty(message="Invalid Name")
	@Email(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}",message="invalid email")
	private String userEmail;
	@NotNull
	@Pattern(regexp = "(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{8,}",message="minimum 8 characters manditory(1 upperCase,1 lower case,1 special character,1 number)")
	private String userPassword;
	UserRole userRole;
	@OneToMany
	List<Book>books;
	@OneToMany
	List<Review>reviews;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	
	

}
