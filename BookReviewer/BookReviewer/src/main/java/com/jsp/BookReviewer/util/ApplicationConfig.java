package com.jsp.BookReviewer.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

}
