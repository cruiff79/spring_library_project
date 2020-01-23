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
import com.spring.library.dto.CategoryDTO;
import com.spring.library.service.BookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BookService bookService;
	
	@Autowired
	BookDTO bookDTO;
	
	@Autowired
	CategoryDTO categoryDTO;
	
	/**
	 * index page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("======== index ===========");
		List<BookDTO> bookList = bookService.listBook();
		model.addAttribute("list", bookList);
		
		return "index";
	}
	
	// book info
	@RequestMapping(value = "/bookInfo", method = RequestMethod.GET)
	public String book_info(HttpServletRequest request, Model model) {
		System.out.println("======== book_info ===========");
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		BookDTO bookInfo = bookService.bookInfo(book_id);
		model.addAttribute("bookInfo", bookInfo);
		
		return "bookInfo";
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String book_list(Model model) {
		System.out.println("======== book_list ===========");
		
		return "books";
	}
	
	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public String subject_list(Model model) {
		System.out.println("======== subject_list method ===========");
		List<CategoryDTO> categoryList = bookService.subject();
		model.addAttribute("list" , categoryList);
		
		return "subjects";
	}
	
	@RequestMapping(value = "/sign_in", method = RequestMethod.GET)
	public String sign_in(Model model) {
		System.out.println("======== sign_in method ===========");
		
		return "sign_in";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search_book(HttpServletRequest request, Model model) {
		System.out.println("======== search_book method ===========");
		String search = request.getParameter("search");
		List<BookDTO> searchList = bookService.searchBook(search);
		model.addAttribute("list", searchList);
		
		return "search";
	}
	
	@RequestMapping(value = "/google_books_api", method = RequestMethod.GET)
	public String google_books_api(Model model) {
		
		return "google_books_api";
	}
	
	@RequestMapping(value = "/google_books_api_insert", method = RequestMethod.POST)
	public String google_books_api_insert(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String publishedDate = request.getParameter("publishedDate");
		String description = request.getParameter("description");
		int page = Integer.parseInt(request.getParameter("page"));
		String isbn = request.getParameter("isbn");
		String img = request.getParameter("img");
		String categories = request.getParameter("categories");
		
		bookDTO.setTitle(title);
		bookDTO.setAuthor(author);
		bookDTO.setPublisher(publisher);
		bookDTO.setPublished_date(publishedDate);
		bookDTO.setDescription(description);
		bookDTO.setPage(page);
		bookDTO.setIsbn(isbn);
		bookDTO.setImage(img);
		bookDTO.setCategories(categories);

		bookService.insertBook(bookDTO);
		
		return "google_books_api";
	}
	
}
