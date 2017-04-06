package com.hzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzh.dao.BookDao;
import com.hzh.entity.Book;
import com.hzh.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	// 注入Service依赖
    @Autowired
    private BookDao bookDao;
	
	public Book getById(long bookId) {
		return bookDao.queryById(bookId);
	}

}
