package com.hzh.entity;

public class Book {
	private long bookId;// 图书ID

    private String name;// 图书名称

    private int number;// 馆藏数量

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

    // 省略构造方法，getter和setter方法，toString方法
    
}
