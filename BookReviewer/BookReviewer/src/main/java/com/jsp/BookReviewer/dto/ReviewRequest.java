package com.jsp.BookReviewer.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jsp.BookReviewer.model.Book;

import jakarta.persistence.ManyToOne;

public class ReviewRequest {
	private int rating;
	private String review;
	@ManyToOne
	@JsonBackReference
	Book book;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

}
