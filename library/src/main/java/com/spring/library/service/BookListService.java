package com.spring.library.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.spring.library.dao.BookDAO;
import com.spring.library.dto.BookDTO;

public class BookListService implements BookService {
	
	@Autowired
	BookDAO bookDAO;

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		ArrayList<BookDTO> bookDTO = bookDAO.selectAllList();
		
		model.addAttribute("list", bookDTO);
	}

}
