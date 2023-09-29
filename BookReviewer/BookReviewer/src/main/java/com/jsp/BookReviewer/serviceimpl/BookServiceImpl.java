package com.jsp.BookReviewer.serviceimpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.BookReviewer.dto.BookRequest;
import com.jsp.BookReviewer.dto.BookResponse;
import com.jsp.BookReviewer.exception.BookNotFoundException;
import com.jsp.BookReviewer.exception.UserNotFoundByIdException;
import com.jsp.BookReviewer.model.Book;
import com.jsp.BookReviewer.model.User;
import com.jsp.BookReviewer.repository.BookRepository;
import com.jsp.BookReviewer.repository.UserRepository;
import com.jsp.BookReviewer.service.BookService;
import com.jsp.BookReviewer.util.ResponseStructure;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ResponseStructure<BookResponse> responseStructure;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<ResponseStructure<BookResponse>> saveBook(BookRequest bookRequest, int userId) {
		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			User user = optional.get();
			Book book = mapper.map(bookRequest, Book.class);
			book.setUser(user);
			book = bookRepository.save(book);
			user.getBooks().add(book);
			userRepository.save(user);
			
			List<Book> books=user.getBooks();
			if(books!=null) {
				List<Book> newBooks=new LinkedList<>();
				for(Book book1:books) {
					newBooks.add(bookRepository.save(book1));
				}
			}
			BookResponse response = mapper.map(book, BookResponse.class);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Book saved successfully");
			responseStructure.setData(response);
			return new ResponseEntity<ResponseStructure<BookResponse>>(responseStructure, HttpStatus.CREATED);
		}
		else {
			throw new UserNotFoundByIdException("failed to find book by bookid!!");
		}
		

	}

	@Override
	public Book findBookById(int bookId) {
		Optional<Book> optional = bookRepository.findById(bookId);
		if(optional.isPresent()) {
		return optional.get();
		}
		else {
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<BookResponse>> updateBook(BookRequest bookRequest, int bookId) {
		Optional<Book> optional = bookRepository.findById(bookId);
		if(optional.isPresent()) {
			Book book = mapper.map(bookRequest, Book.class);
			book.setBookId(bookId);
			Book book2 = bookRepository.save(book);
			BookResponse response = mapper.map(book2, BookResponse.class);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("User Updated successfully");
			responseStructure.setData(book2);
			return new ResponseEntity<ResponseStructure<BookResponse>> (responseStructure,HttpStatus.CREATED);
		}
		else {
			throw new BookNotFoundException("Failed to update book");
		}
		
	}

	@Override
	public  List<Book> getBooks() {
		List<Book> books = bookRepository.findAll();
		if(books!=null) {
			return books;
		}
		return null;
	}

}
