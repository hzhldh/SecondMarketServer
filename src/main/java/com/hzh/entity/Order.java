package com.hzh.entity;

public class Order {
	private int order_id;
	private int goods_id;
	private String publisher;
	private String order_people;
	private double final_price;
	private String order_time;
	private String order_status;
	private String close_reason;
	
	private User publisher_obj;//发布人对象
	
	private User order_obj;//下单人对象

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getOrder_people() {
		return order_people;
	}

	public void setOrder_people(String order_people) {
		this.order_people = order_people;
	}

	public double getFinal_price() {
		return final_price;
	}

	public void setFinal_price(double final_price) {
		this.final_price = final_price;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getClose_reason() {
		return close_reason;
	}

	public void setClose_reason(String close_reason) {
		this.close_reason = close_reason;
	}

	public User getPublisher_obj() {
		return publisher_obj;
	}

	public void setPublisher_obj(User publisher_obj) {
		this.publisher_obj = publisher_obj;
	}

	public User getOrder_obj() {
		return order_obj;
	}

	public void setOrder_obj(User order_obj) {
		this.order_obj = order_obj;
	}
	
}
