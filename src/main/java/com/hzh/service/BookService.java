package com.hzh.service;

import com.hzh.entity.Book;

public interface BookService {
	/**
     * 查询一本图书
     * 
     * @param bookId
     * @return
     */
    Book getById(long bookId);
}
