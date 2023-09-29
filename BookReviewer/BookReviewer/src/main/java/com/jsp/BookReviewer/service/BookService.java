package com.jsp.BookReviewer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.BookReviewer.dto.BookRequest;
import com.jsp.BookReviewer.dto.BookResponse;
import com.jsp.BookReviewer.dto.ReviewResponse;
import com.jsp.BookReviewer.model.Book;
import com.jsp.BookReviewer.util.ResponseStructure;

public interface BookService {

	ResponseEntity<ResponseStructure<BookResponse>> saveBook(BookRequest bookRequest, int userId);

	Book findBookById(int bookId);

	ResponseEntity<ResponseStructure<BookResponse>> updateBook(BookRequest bookRequest, int bookId);

	List<Book> getBooks();


}
