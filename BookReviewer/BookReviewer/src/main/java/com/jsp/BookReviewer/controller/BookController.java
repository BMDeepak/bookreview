package com.jsp.BookReviewer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.BookReviewer.dto.BookRequest;
import com.jsp.BookReviewer.dto.BookResponse;
import com.jsp.BookReviewer.model.Book;
import com.jsp.BookReviewer.service.BookService;
import com.jsp.BookReviewer.util.ResponseStructure;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService service;
	
	
	@PostMapping("/userId/{userId}")
	public ResponseEntity<ResponseStructure<BookResponse>> saveBook(@RequestBody BookRequest bookRequest,@PathVariable int userId ){
		return service.saveBook(bookRequest,userId);

	}
	@GetMapping("/bookid/{bookId}") // (add request)
	public Book findBookById(@PathVariable int bookId) {
		return service.findBookById(bookId);
	}
	@PutMapping("/bookid/{bookId}")
	public ResponseEntity<ResponseStructure<BookResponse>> updateBook(@RequestBody BookRequest bookRequest,@PathVariable int bookId){
		return service.updateBook(bookRequest,bookId);
	}
	@GetMapping("/getall")
	public List<Book> findAllBooks(){
		return service.getBooks();
	}
	
	

}
