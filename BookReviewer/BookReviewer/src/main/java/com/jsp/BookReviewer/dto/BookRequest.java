package com.jsp.BookReviewer.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jsp.BookReviewer.model.Genre;
import com.jsp.BookReviewer.model.Review;
import com.jsp.BookReviewer.model.User;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class BookRequest {
	@NotEmpty(message="Invalid Name")
	private String bookName;
	@NotEmpty(message="Invalid description")
	String description;
	@NotEmpty(message="Invalid genre")
	Genre genre;
	@Min(value=20,message="Book Price cannot be less then 20")
	@Max(value=12000,message="Book Price cannot be more then 12000")
	double price;
	
	@ManyToOne
	User user;
	
	@OneToMany
	@JsonManagedReference
	@JsonIgnore
	List<Review>reviews;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	

}
