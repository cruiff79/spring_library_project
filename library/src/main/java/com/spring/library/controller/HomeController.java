package com.spring.library.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.library.dto.BookDTO;
import com.spring.library.dto.CategoryDTO;
import com.spring.library.dto.UserDTO;
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
	
	@Autowired
	UserDTO userDTO;
	
	String sessionID;
	
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
		List<CategoryDTO> categoryList = bookService.allCategory();
		model.addAttribute("list" , categoryList);
		
		return "subjects";
	}
	
	@RequestMapping(value = "/sign_in", method = RequestMethod.GET)
	public String sign_in(Model model) {
		System.out.println("======== sign_in method ===========");
		
		return "sign_in";
	}
	
	@RequestMapping(value = "/sign_in_process", method = RequestMethod.POST)
	public String sign_in_process(HttpServletRequest request, Model model) {
		System.out.println("======== sign_in_process method ===========");
		String url = "";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		userDTO.setUser_id(email);
		userDTO.setPassword(password);
		
		UserDTO user = bookService.user(userDTO);
		
		if(user != null) {
			request.getSession().setAttribute("sessionID", request.getSession().getId());
			request.getSession().setAttribute("userName", user.getName());
			model.addAttribute("user", user);
			
			url = "redirect:/";
		} else {
			model.addAttribute("", "Login Fail");
			url = "redirect:sign_in";
		}
		
		return url;
	}
	
	@RequestMapping(value = "sign_up_insert", method = RequestMethod.POST)
	public String sign_up_insert(HttpServletRequest request, Model model) {
		System.out.println("======== sign_in_insert method ===========");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String user_name = request.getParameter("user_name");
		String address = request.getParameter("address");
		String post_code = request.getParameter("post_code");
		String phone_number = request.getParameter("phone_number");
		
		userDTO.setUser_id(email);
		userDTO.setPassword(password);
		userDTO.setName(user_name);
		userDTO.setAddress(address);
		userDTO.setPost_code(post_code);
		userDTO.setPhone(phone_number);
		
		bookService.createUser(userDTO);
		
		return "redirect:sign_in";
	}
	
	@RequestMapping(value = "/sign_up", method = RequestMethod.GET)
	public String sign_up(Model model) {
		System.out.println("======== sign_up method ===========");
		
		return "sign_up";
	}
	
	@RequestMapping(value = "/sign_out", method = RequestMethod.GET)
	public String sign_out(HttpServletRequest request) throws Exception {
		System.out.println("======== sign_out method ===========");
		request.getSession().removeAttribute("sessionID");
		request.getSession().removeAttribute("userName");
		
		return "sign_out";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search_book(HttpServletRequest request, Model model) {
		System.out.println("======== search_book method ===========");
		String search = request.getParameter("search");
		List<BookDTO> searchList = bookService.searchBook(search);
		model.addAttribute("list", searchList);
		
		return "search";
	}
	
	@RequestMapping(value = "/searchSubject", method = RequestMethod.GET)
	public String book_category(HttpServletRequest request, Model model) {
		System.out.println("======== book_category method ===========");
		int category_id = Integer.parseInt(request.getParameter("category_id"));
		String category_name = request.getParameter("category_name");
		List bookCategory = bookService.bookCategory(category_id);
		model.addAttribute("list", bookCategory);
		model.addAttribute("category_name", category_name);
		
		return "book_category";
	}
	
	@RequestMapping(value = "/google_books_api", method = RequestMethod.GET)
	public String google_books_api(Model model) {
		System.out.println("======== google_books_api method ===========");
		
		return "google_books_api";
	}
	
	@RequestMapping(value = "/google_books_api_insert", method = RequestMethod.POST)
	public String google_books_api_insert(HttpServletRequest request, Model model) {
		System.out.println("======== google_books_api_insert method ===========");
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String publishedDate = request.getParameter("publishedDate");
		String description = request.getParameter("description");
		int page = Integer.parseInt(request.getParameter("page"));
		String isbn = request.getParameter("isbn");
		String img = request.getParameter("img");
		String categories = request.getParameter("categories");
		
		CategoryDTO searchCategory = bookService.searchCategory(categories);
		
		if(searchCategory == null) {
			categoryDTO.setCategory_name(categories);
			bookService.insertCategory(categoryDTO);
			searchCategory = bookService.searchCategory(categories);
		}
		
		bookDTO.setTitle(title);
		bookDTO.setAuthor(author);
		bookDTO.setPublisher(publisher);
		bookDTO.setPublished_date(publishedDate);
		bookDTO.setDescription(description);
		bookDTO.setPage(page);
		bookDTO.setIsbn(isbn);
		bookDTO.setImage(img);
		bookDTO.setCategory_id(searchCategory.getCategory_id());

		bookService.insertBook(bookDTO);
		
		return "google_books_api";
	}
	
}
