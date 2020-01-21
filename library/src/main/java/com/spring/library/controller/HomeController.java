package com.spring.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.library.dto.BookDTO;
import com.spring.library.service.BookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BookService bookService;
	
	/**
	 * index page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<BookDTO> bookList = bookService.listBook();
		model.addAttribute("list", bookList);
		
		return "index";
	}
	
	// book info
	@RequestMapping(value = "/bookInfo", method = RequestMethod.GET)
	public String book_info(HttpServletRequest request, Model model) {
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		BookDTO bookInfo = bookService.bookInfo(book_id);
		model.addAttribute("bookInfo", bookInfo);
		
		return "bookInfo";
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String book_list(Model model) {
		return "books";
	}
	
	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public String subject_list(Model model) {
		return "subjects";
	}
	
	@RequestMapping(value = "/sign_in", method = RequestMethod.GET)
	public String sign_in(Model model) {
		return "sign_in";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search_book(HttpServletRequest request, Model model) {
		String search = request.getParameter("search");
		List<BookDTO> list = bookService.searchBook(search);
		model.addAttribute("list", list);
		
		return "search";
	}
	
}
