package com.jsp.BookReviewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.BookReviewer.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
