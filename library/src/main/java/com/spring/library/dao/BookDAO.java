package com.spring.library.dao;

import java.util.List;

import com.spring.library.dto.BookDTO;

public interface BookDAO {
	List<BookDTO> listBook();
}
