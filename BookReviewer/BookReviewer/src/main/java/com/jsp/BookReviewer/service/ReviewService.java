package com.jsp.BookReviewer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.BookReviewer.dto.ReviewRequest;
import com.jsp.BookReviewer.dto.ReviewResponse;
import com.jsp.BookReviewer.util.ResponseStructure;
 

public interface ReviewService {

	public ResponseEntity<ResponseStructure<ReviewResponse>> saveReview(ReviewRequest requestBody, int bookId);

}
