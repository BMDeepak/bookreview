package com.jsp.BookReviewer.serviceimpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.BookReviewer.dto.ReviewRequest;
import com.jsp.BookReviewer.dto.ReviewResponse;
import com.jsp.BookReviewer.model.Book;
import com.jsp.BookReviewer.model.Review;
import com.jsp.BookReviewer.repository.BookRepository;
import com.jsp.BookReviewer.repository.ReviewRepository;
import com.jsp.BookReviewer.service.ReviewService;
import com.jsp.BookReviewer.util.ResponseStructure;
@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ResponseStructure<ReviewResponse> responseStructure;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseEntity<ResponseStructure<ReviewResponse>> saveReview(ReviewRequest requestBody, int bookId) {
		Optional<Book> optional = bookRepository.findById(bookId);
		Book book = optional.get(); 
		if (optional.isPresent()) {
			Review review = mapper.map(requestBody, Review.class);
			review.setBook(book);
			review = reviewRepository.save(review);
			responseStructure.setData(review);
			responseStructure.setMessage("saved review successfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());	
			return new ResponseEntity<ResponseStructure<ReviewResponse>>(responseStructure, HttpStatus.CREATED);
	}
		else
		{
			return null;
		}
	}

}
