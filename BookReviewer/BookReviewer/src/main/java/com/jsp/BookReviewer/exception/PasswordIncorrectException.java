package com.jsp.BookReviewer.exception;

public class PasswordIncorrectException extends RuntimeException{
	private String message;

	public PasswordIncorrectException(String message) {
		super();
		this.message = message;
	}
	 public String getMessage() {
		 return message;
	 }


}
