package com.hzh.controller;



import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzh.entity.Book;
import com.hzh.service.BookService;



@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookservice;
	
	
	@ResponseBody  
    @RequestMapping("/list")  
	public List<Book> list() {  
		long bookId=1000;
		Book book =bookservice.getById(bookId);
		List<Book> list=new LinkedList<>();
		list.add(book);
		System.out.println(book.getName());
	      
	    return list;
	  }  
}
