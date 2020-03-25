package com.spring.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.library.dao.BookDAO;
import com.spring.library.vo.Book;
import com.spring.library.vo.Category;
import com.spring.library.vo.User;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDAO;

	@Override
	public List<Book> listBook() {
		// TODO Auto-generated method stub
		return bookDAO.listBook();
	}

	@Override
	public Book bookInfo(int book_id) {
		// TODO Auto-generated method stub
		return bookDAO.bookInfo(book_id);
	}

	@Override
	public List<Book> searchBook(String search) {
		// TODO Auto-generated method stub
		return bookDAO.searchBook(search);
	}

	@Override
	public void insertBook(Book book) {
		// TODO Auto-generated method stub
		bookDAO.insertBook(book);
	}

	@Override
	public List<Category> allCategory() {
		// TODO Auto-generated method stub
		return bookDAO.allCategory();
	}

	@Override
	public void insertCategory(Category category) {
		// TODO Auto-generated method stub
		bookDAO.insertCategory(category);
	}

	@Override
	public Category searchCategory(String category_name) {
		// TODO Auto-generated method stub
		return bookDAO.searchCategory(category_name);
	}

	@Override
	public List<Book> bookCategory(int category_id) {
		// TODO Auto-generated method stub
		return bookDAO.bookCategory(category_id);
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		bookDAO.createUser(user);
	}

	@Override
	public User user(User user) {
		// TODO Auto-generated method stub
		return bookDAO.user(user);
	}

	@Override
	public List<Book> myBookList(String user_id) {
		// TODO Auto-generated method stub
		return bookDAO.myBookList(user_id);
	}

}
