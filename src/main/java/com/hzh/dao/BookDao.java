package com.hzh.dao;

import com.hzh.entity.Book;

public interface BookDao {
	/**
     * 通过ID查询单本图书
     * 
     * @param id
     * @return
     */
    Book queryById(long id);
}
