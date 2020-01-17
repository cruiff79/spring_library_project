package com.spring.library.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.library.dto.BookDTO;
import com.spring.library.service.BookListService;
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
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<BookDTO> list = bookService.listBook();
		model.addAttribute("list", list);
		
		return "index";
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
	
}
