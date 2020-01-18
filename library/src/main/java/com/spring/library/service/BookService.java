package com.spring.library.service;

import java.util.List;

import com.spring.library.dto.BookDTO;

public interface BookService {
	
	List<BookDTO> listBook();
	BookDTO bookInfo(int book_id);
}
