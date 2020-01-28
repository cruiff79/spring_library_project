package com.spring.library.dao;

import java.util.List;

import com.spring.library.dto.BookDTO;
import com.spring.library.dto.CategoryDTO;
import com.spring.library.dto.UserDTO;

public interface BookDAO {
	List<BookDTO> listBook();
	BookDTO bookInfo(int book_id);
	List<BookDTO> searchBook(String search);
	void insertBook(BookDTO bookDTO);
	List<CategoryDTO> allCategory();
	void insertCategory(CategoryDTO categoryDTO);
	CategoryDTO searchCategory(String category_name);
	List<BookDTO> bookCategory(int category_id);
	void createUser(UserDTO userDTO);
	UserDTO user(UserDTO userDTO);
}
