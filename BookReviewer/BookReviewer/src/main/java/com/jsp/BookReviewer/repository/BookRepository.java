package com.jsp.BookReviewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.BookReviewer.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
