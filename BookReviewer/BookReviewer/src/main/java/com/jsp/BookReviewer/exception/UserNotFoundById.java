package com.jsp.BookReviewer.exception;

public class UserNotFoundById extends RuntimeException{
	private String message;

	public UserNotFoundById(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		 return message;
	 }

}
