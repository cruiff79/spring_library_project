package com.spring.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.library.dao.BookDAO;
import com.spring.library.dto.BookDTO;
import com.spring.library.dto.CategoryDTO;

@Service
public class BookListService implements BookService {
	
	@Autowired
	BookDAO bookDAO;

	@Override
	public List<BookDTO> listBook() {
		// TODO Auto-generated method stub
		return bookDAO.listBook();
	}

	@Override
	public BookDTO bookInfo(int book_id) {
		// TODO Auto-generated method stub
		return bookDAO.bookInfo(book_id);
	}

	@Override
	public List<BookDTO> searchBook(String search) {
		// TODO Auto-generated method stub
		return bookDAO.searchBook(search);
	}

	@Override
	public void insertBook(BookDTO bookDTO) {
		// TODO Auto-generated method stub
		bookDAO.insertBook(bookDTO);
	}

	@Override
	public List<CategoryDTO> allCategory() {
		// TODO Auto-generated method stub
		return bookDAO.allCategory();
	}

	@Override
	public void insertCategory(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		bookDAO.insertCategory(categoryDTO);
	}

	@Override
	public CategoryDTO searchCategory(String category_name) {
		// TODO Auto-generated method stub
		return bookDAO.searchCategory(category_name);
	}

	@Override
	public List<BookDTO> bookCategory(int category_id) {
		// TODO Auto-generated method stub
		return bookDAO.bookCategory(category_id);
	}

}
