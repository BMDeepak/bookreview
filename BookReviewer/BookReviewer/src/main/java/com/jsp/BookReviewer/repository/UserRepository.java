package com.jsp.BookReviewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.BookReviewer.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.userEmail=?1")
	public Optional<User> findByUserEmail(String userEmail);
	
//	public Optional<User> findByUserId(int userId);
	 @Query("select u from User u where u.userEmail=?1 and u.userPassword=?2 ")
	public Optional<User> findUserByEmailAndPassword(String userEmail, String userPassword);

}
