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
import com.spring.library.vo.UserType;

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
	UserType userType;
	
	@Autowired
	Criteria criteria;
	
	@Autowired
	PageMaker pageMaker;
	
	/**
	 * index page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("======== index ===========");
		List<Book> listBestBook = bookService.listBestBook();
		List<Book> listNewBook = bookService.listNewBook();
		model.addAttribute("listBestBook", listBestBook);
		model.addAttribute("listNewBook", listNewBook);
		
		return "index";
	}
	
	
	/**
	 * @Method Name : book_info
	 * @Description : show book information
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/bookInfo", method = RequestMethod.GET)
	public String book_info(HttpServletRequest request, Model model) {
		System.out.println("======== book_info ===========");
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		Book bookInfo = bookService.bookInfo(book_id);
		model.addAttribute("bookInfo", bookInfo);
		
		return "bookInfo";
	}
	
	/**
	 * @Method Name : book_list
	 * @Description : list books page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String book_list(Model model) {
		System.out.println("======== book_list ===========");
		
		return "books";
	}
	
	/**
	 * @Method Name : subject_list
	 * @Description : list all subjects
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public String subject_list(Model model) {
		System.out.println("======== subject_list method ===========");
		List<Category> categoryList = bookService.allCategory();
		model.addAttribute("list" , categoryList);
		
		return "subjects";
	}
	
	/**
	 * @Method Name : myBook_list
	 * @Description : list my borrowed books
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/myBooks", method = RequestMethod.GET)
	public String myBook_list(HttpServletRequest request, Model model) {
		System.out.println("======== myBook_list method ===========");
		String user_id = request.getSession().getAttribute("user_id").toString();
		List<Book> myBookList = bookService.myBookList(user_id);
		model.addAttribute("list", myBookList);
		
		return "myBooks";
	}
	
	/**
	 * @Method Name : borrow_book
	 * @Description : process borrowing book
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/borrow_book", method = RequestMethod.GET)
	public String borrow_book(HttpServletRequest request) {
		System.out.println("======== borrow_book method ===========");
		String user_id = request.getSession().getAttribute("user_id").toString();
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_id", user_id);
		map.put("book_id", book_id);
		
		bookService.borrowBook(map);
		
		return "redirect:myBooks";
	}
	
	/**
	 * @Method Name : sign_in
	 * @Description : log in page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sign_in", method = RequestMethod.GET)
	public String sign_in(Model model) {
		System.out.println("======== sign_in method ===========");
		
		return "sign_in";
	}
	
	/**
	 * @Method Name : sign_in_process
	 * @Description : process log in
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sign_in_process", method = RequestMethod.POST)
	public String sign_in_process(HttpServletRequest request, Model model) {
		System.out.println("======== sign_in_process method ===========");
		String url = "";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		user.setUser_id(email);
		user.setPassword(password);
		
		User loginUser = bookService.loginUser(user);
		
		// login and password decrypt
		if(loginUser != null && BCrypt.checkpw(password, loginUser.getPassword())) {
			request.getSession().setAttribute("user_id", loginUser.getUser_id());
			request.getSession().setAttribute("user_name", loginUser.getName());
			request.getSession().setAttribute("user_type", loginUser.getUser_type());
			model.addAttribute("user", loginUser);
			
			url = "redirect:/";
		} else {
			model.addAttribute("", "Login Fail");
			url = "redirect:sign_in";
		}
		
		return url;
	}
	
	/**
	 * @Method Name : sign_up
	 * @Description : user register page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sign_up", method = RequestMethod.GET)
	public String sign_up(Model model) {
		System.out.println("======== sign_up method ===========");
		
		return "sign_up";
	}
	
	/**
	 * @Method Name : sign_up_insert
	 * @Description : process user register
	 * @param request
	 * @param model
	 * @return
	 */
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
	
	/**
	 * @Method Name : sign_out
	 * @Description : process log out
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sign_out", method = RequestMethod.GET)
	public String sign_out(HttpServletRequest request) throws Exception {
		System.out.println("======== sign_out method ===========");
		request.getSession().removeAttribute("user_id");
		request.getSession().removeAttribute("user_name");
		request.getSession().removeAttribute("user_type");
		
		return "sign_out";
	}
	
	/**
	 * @Method Name : update_user
	 * @Description : update user page
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update_user", method = RequestMethod.GET)
	public String update_user(HttpServletRequest request, Model model) {
		System.out.println("======== update_user method ===========");
		String email = request.getSession().getAttribute("user_id").toString();
		user.setUser_id(email);
		
		User loginUser = bookService.loginUser(user);
		model.addAttribute("user", loginUser);
		
		return "update_user";
	}
	
	/**
	 * @Method Name : update_user_process
	 * @Description : process update user
	 * @param request
	 * @param model
	 * @return
	 */
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
	
	/**
	 * @Method Name : search_book
	 * @Description : process search books
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search_book", method = RequestMethod.GET)
	public String search_book(HttpServletRequest request, Model model) {
		System.out.println("======== search_book method ===========");
		
		String searchBook = request.getParameter("searchBook");
		String page = request.getParameter("page");
		int pageNum = 1;
		List<Book> searchList = null;
		
		if(page == null) {
			pageNum = 1;
		} else {
			pageNum = Integer.parseInt(page);
		}
		
		try {
			criteria.setPage(pageNum);
			criteria.setPerPageNum(8);
			criteria.setSearchBook(searchBook);
			searchList = bookService.searchBook(criteria);
			pageMaker.setCriteria(criteria);
			
			if(searchList.isEmpty()) {
				pageMaker.setTotalCount(0);
			} else {
				pageMaker.setTotalCount(searchList.get(0).getTotCnt());
			}
		} catch(IndexOutOfBoundsException e) {
			e.getStackTrace();
		}
		
		model.addAttribute("list", searchList);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("searchBook", searchBook);
		
		return "search_book";
	}
	
	/**
	 * @Method Name : book_category
	 * @Description : list books selected category
	 * @param request
	 * @param model
	 * @return
	 */
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
	
	@RequestMapping(value = "/all_user", method = RequestMethod.GET)
	public String list_all_user(Model model) {
		System.out.println("======== list_all_user method ===========");
		List<User> allUser = bookService.list_all_user();
		model.addAttribute("allUser", allUser);
		
		return "all_user";
	}
	
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(HttpServletRequest request, Model model) {
		System.out.println("======== userInfo method ===========");
		String user_id = request.getParameter("user_id");
		User userInfo = bookService.userInfo(user_id);
		List<UserType> userType = bookService.userType();
		model.addAttribute("user", userInfo);
		model.addAttribute("userType", userType);
		
		return "update_user_admin";
	}
	
	/**
	 * @Method Name : update_user_admin_process
	 * @Description : update user info as admin
	 * @return
	 */
	@RequestMapping(value = "/update_user_admin_process", method = RequestMethod.POST)
	public String update_user_admin_process(HttpServletRequest request) {
		System.out.println("======== update_user_admin_process method ===========");
		
		user.setUser_id(request.getParameter("email"));
		user.setName(request.getParameter("user_name"));
		user.setAddress(request.getParameter("address"));
		user.setPost_code(request.getParameter("post_code"));
		user.setPhone(request.getParameter("phone_number"));
		user.setUser_type(request.getParameter("user_type"));
		bookService.updateUserAdmin(user);
		
		return "redirect:all_user";
	}
	
	/**
	 * @Method Name : google_books_api
	 * @Description : google books api page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/google_books_api", method = RequestMethod.GET)
	public String google_books_api(HttpServletRequest request) {
		System.out.println("======== google_books_api method ===========");
		try {
			if(request.getSession().getAttribute("user_type").equals("1")) {
				return "google_books_api";
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	/**
	 * @Method Name : google_books_api_insert
	 * @Description : get books information from google api and insert them into database
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/google_books_api_insert", method = {RequestMethod.POST, RequestMethod.GET})
	public String google_books_api_insert(HttpServletRequest request) {
		System.out.println("======== google_books_api_insert method ===========");
		
		if(request.getMethod().equals("GET")) {
			return "redirect:/";
		}
		
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
