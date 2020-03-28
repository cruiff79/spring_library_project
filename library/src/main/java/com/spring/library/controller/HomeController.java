package com.spring.library.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.library.common.paging.Criteria;
import com.spring.library.common.paging.PageMaker;
import com.spring.library.service.BookService;
import com.spring.library.vo.Book;
import com.spring.library.vo.Category;
import com.spring.library.vo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BookService bookService;
	
	@Autowired
	Book book;
	
	@Autowired
	Category category;
	
	@Autowired
	User user;
	
	@Autowired
	Criteria criteria;
	
	@Autowired
	PageMaker pageMaker;
	
	String sessionID;
	
	/**
	 * index page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("======== index ===========");
		List<Book> bookList = bookService.listBook();
		model.addAttribute("list", bookList);
		
		return "index";
	}
	
	// book info
	@RequestMapping(value = "/bookInfo", method = RequestMethod.GET)
	public String book_info(HttpServletRequest request, Model model) {
		System.out.println("======== book_info ===========");
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		Book bookInfo = bookService.bookInfo(book_id);
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
		List<Category> categoryList = bookService.allCategory();
		model.addAttribute("list" , categoryList);
		
		return "subjects";
	}
	
	@RequestMapping(value = "/myBooks", method = RequestMethod.POST)
	public String myBook_list(HttpServletRequest request, Model model) {
		System.out.println("======== myBook_list method ===========");
		String user_id = request.getParameter("user_id");
		List<Book> myBookList = bookService.myBookList(user_id);
		model.addAttribute("list", myBookList);
		
		return "myBooks";
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
		
		user.setUser_id(email);
		user.setPassword(password);
		
		User loginUser = bookService.user(user);
		
		// login and password decrypt
		if(loginUser != null && BCrypt.checkpw(password, loginUser.getPassword())) {
			request.getSession().setAttribute("user_id", loginUser.getUser_id());
			request.getSession().setAttribute("user_name", loginUser.getName());
			model.addAttribute("user", loginUser);
			
			url = "redirect:/";
		} else {
			model.addAttribute("", "Login Fail");
			url = "redirect:sign_in";
		}
		
		return url;
	}
	
	@RequestMapping(value = "/sign_up_insert", method = RequestMethod.POST)
	public String sign_up_insert(HttpServletRequest request, Model model) {
		System.out.println("======== sign_up_insert method ===========");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String user_name = request.getParameter("user_name");
		String address = request.getParameter("address");
		String post_code = request.getParameter("post_code");
		String phone_number = request.getParameter("phone_number");
		// password encrypt
		password = BCrypt.hashpw(password, BCrypt.gensalt());
		
		user.setUser_id(email);
		user.setPassword(password);
		user.setName(user_name);
		user.setAddress(address);
		user.setPost_code(post_code);
		user.setPhone(phone_number);
		
		bookService.createUser(user);
		
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
		request.getSession().removeAttribute("user_id");
		request.getSession().removeAttribute("user_name");
		
		return "sign_out";
	}
	
	@RequestMapping(value = "/update_user", method = RequestMethod.GET)
	public String update_user(HttpServletRequest request, Model model) {
		System.out.println("======== update_user method ===========");
		String email = request.getSession().getAttribute("user_id").toString();
		user.setUser_id(email);
		
		User loginUser = bookService.user(user);
		model.addAttribute("user", loginUser);
		
		return "update_user";
	}
	
	@RequestMapping(value = "/update_user_process", method = RequestMethod.POST)
	public String update_user_process(HttpServletRequest request, Model model) {
		System.out.println("======== update_user_process method ===========");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String user_name = request.getParameter("user_name");
		String address = request.getParameter("address");
		String post_code = request.getParameter("post_code");
		String phone_number = request.getParameter("phone_number");
		// password encrypt
		password = BCrypt.hashpw(password, BCrypt.gensalt());
		
		user.setUser_id(email);
		user.setPassword(password);
		user.setName(user_name);
		user.setAddress(address);
		user.setPost_code(post_code);
		user.setPhone(phone_number);
		
		bookService.updateUser(user);
		model.addAttribute("user", user);
		
		request.getSession().setAttribute("user_name", user.getName());
		
		return "update_user";
	}
	
	@RequestMapping(value = "/search_book", method = RequestMethod.GET)
	public String search_book(HttpServletRequest request, Model model) {
		System.out.println("======== search_book method ===========");
		
		String searchBook = request.getParameter("searchBook");
		String page = request.getParameter("page");
		int pageNum = 1;
		
		if(page == null) {
			pageNum = 1;
		} else {
			pageNum = Integer.parseInt(page);
		}
		
		criteria.setPage(pageNum);
		criteria.setPerPageNum(8);
		criteria.setSearchBook(searchBook);
		List<Book> searchList = bookService.searchBook(criteria);
		
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(searchList.get(0).getTotCnt());
		
		model.addAttribute("list", searchList);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("searchBook", criteria.getSearchBook());
		
		return "search_book";
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
		
		Category searchCategory = bookService.searchCategory(categories);
		
		if(searchCategory == null) {
			category.setCategory_name(categories);
			bookService.insertCategory(category);
			searchCategory = bookService.searchCategory(categories);
		}
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPublished_date(publishedDate);
		book.setDescription(description);
		book.setPage(page);
		book.setIsbn(isbn);
		book.setImage(img);
		book.setCategory_id(searchCategory.getCategory_id());

		bookService.insertBook(book);
		
		return "google_books_api";
	}
	
}
