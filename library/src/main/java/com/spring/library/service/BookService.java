package com.spring.library.service;

import java.util.List;

import org.springframework.ui.Model;

import com.spring.library.dto.BookDTO;

public interface BookService {
	
	List<BookDTO> listBook();

}
