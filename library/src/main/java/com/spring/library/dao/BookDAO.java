package com.spring.library.dao;

import java.util.List;

import com.spring.library.dto.BookDTO;
import com.spring.library.dto.CategoryDTO;

public interface BookDAO {
	List<BookDTO> listBook();
	BookDTO bookInfo(int book_id);
	List<BookDTO> searchBook(String search);
	void insertBook(BookDTO bookDTO);
	List<CategoryDTO> subject();
}
