package com.jsp.BookReviewer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.BookReviewer.dto.ReviewRequest;
import com.jsp.BookReviewer.dto.ReviewResponse;
import com.jsp.BookReviewer.service.ReviewService;
import com.jsp.BookReviewer.util.ResponseStructure;

@RestController
@RequestMapping("/review")
public class ReviewController<ResponseReview> {
	
	@Autowired
	private ReviewService service;
	
	@PostMapping("/bookId/{bookId}")
	public ResponseEntity<ResponseStructure<ReviewResponse>> saveReview(@RequestBody ReviewRequest requestBody, @PathVariable int bookId){
		return service.saveReview(requestBody,bookId);
	}

}
