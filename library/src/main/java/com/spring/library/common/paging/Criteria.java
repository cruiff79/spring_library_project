package com.spring.library.common.paging;

import org.springframework.stereotype.Repository;

@Repository
public class Criteria {
	private int page;
	private int perPageNum;
	private int pageStart;
	private int pageEnd;
	private String searchBook;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 12;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0) {
			this.perPageNum = 12;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	public String getSearchBook() {
		return searchBook;
	}

	public void setSearchBook(String searchBook) {
		this.searchBook = searchBook;
	}

	public int getPageStart() {
		return (this.page - 1) * this.perPageNum;
	}
	
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return this.page * this.perPageNum;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
}
