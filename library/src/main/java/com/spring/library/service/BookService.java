package com.spring.library.service;

import java.util.HashMap;
import java.util.List;

import com.spring.library.common.paging.Criteria;
import com.spring.library.vo.Book;
import com.spring.library.vo.Category;
import com.spring.library.vo.User;
import com.spring.library.vo.UserType;

public interface BookService {
	
	/**
	 * @Method Name : listBestBook
	 * @Description : list best books in index page
	 * @return
	 */
	List<Book> listBestBook();
	
	/**
	 * @Method Name : listNewBook
	 * @Description : list new books
	 * @return
	 */
	List<Book> listNewBook();
	
	/**
	 * @Method Name : bookInfo
	 * @Description : show book information
	 * @param book_id
	 * @return
	 */
	Book bookInfo(int book_id);
	
	/**
	 * @Method Name : searchBook
	 * @Description : process search books
	 * @param criteria
	 * @return
	 */
	List<Book> searchBook(Criteria criteria);
	
	/**
	 * @Method Name : insertBook
	 * @Description : insert books from google api into database
	 * @param book
	 */
	void insertBook(Book book);
	
	/**
	 * @Method Name : allCategory
	 * @Description : list all Categories
	 * @return
	 */
	List<Category> allCategory();
	
	/**
	 * @Method Name : insertCategory
	 * @Description : insert categories into database
	 * @param category
	 */
	void insertCategory(Category category);
	
	/**
	 * @Method Name : searchCategory
	 * @Description : search category to avoid duplicate category
	 * @param category_name
	 * @return
	 */
	Category searchCategory(String category_name);
	
	/**
	 * @Method Name : bookCategory
	 * @Description : list books selected category
	 * @param category_id
	 * @return
	 */
	List<Book> bookCategory(int category_id);
	
	/**
	 * @Method Name : createUser
	 * @Description : process user register
	 * @param user
	 */
	void createUser(User user);
	
	/**
	 * @Method Name : updateUser
	 * @Description : process update user
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * @Method Name : loginUser
	 * @Description : process log in
	 * @param user
	 * @return
	 */
	User loginUser(User user);
	
	/**
	 * @Method Name : myBookList
	 * @Description : list my borrowed books
	 * @param user_id
	 * @return
	 */
	List<Book> myBookList(String user_id);
	
	/**
	 * @Method Name : borrowBook
	 * @Description : process borrowing book
	 * @param map
	 */
	void borrowBook(HashMap<Object, Object> map);
	
	
	/**
	 * @Method Name : list_all_user
	 * @Description : list all user
	 * @return
	 */
	List<User> list_all_user();
	
	/**
	 * @Method Name : userInfo
	 * @Description : show user information
	 * @param user_id
	 * @return
	 */
	User userInfo(String user_id);
	
	/**
	 * @Method Name : allUserType
	 * @Description : list all user type
	 * @return
	 */
	List<UserType> userType();
	
	/**
	 * @Method Name : updateUserAdmin
	 * @Description : update user info as admin
	 * @param user
	 */
	void updateUserAdmin(User user);
}
