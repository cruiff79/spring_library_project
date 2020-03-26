package com.spring.library.dao;

import java.util.List;

import com.spring.library.vo.Book;
import com.spring.library.vo.Category;
import com.spring.library.vo.User;

public interface BookDAO {
	List<Book> listBook();
	Book bookInfo(int book_id);
	List<Book> searchBook(String search);
	void insertBook(Book book);
	List<Category> allCategory();
	void insertCategory(Category category);
	Category searchCategory(String category_name);
	List<Book> bookCategory(int category_id);
	void createUser(User user);
	void updateUser(User user);
	User user(User user);
	List<Book> myBookList(String user_id);
}
