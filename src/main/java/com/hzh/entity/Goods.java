package com.hzh.entity;

public class Goods {
	private int goods_id;
	private String source_type;//来源类型
	private String goods_name;
	private String publisher;//发布者
	private String description;
	private String type;//类别
	private int popularity;//人气值
	private int auction_num;//参与竞拍人数
	private String goods_img;
	private double original_price;//原价
	private double second_price;//二手价
	private String old_degree;//折旧程度
	private String publish_time;//发布时间
	private String goods_status;//物品状态
	
	private User user;//一对一关联，发布者相关信息
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getSource_type() {
		return source_type;
	}
	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public double getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(double original_price) {
		this.original_price = original_price;
	}
	public double getSecond_price() {
		return second_price;
	}
	public void setSecond_price(double second_price) {
		this.second_price = second_price;
	}
	public String getOld_degree() {
		return old_degree;
	}
	public void setOld_degree(String old_degree) {
		this.old_degree = old_degree;
	}
	public String getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}
	public String getGoods_status() {
		return goods_status;
	}
	public void setGoods_status(String goods_status) {
		this.goods_status = goods_status;
	}	
	public int getAuction_num() {
		return auction_num;
	}
	public void setAuction_num(int auction_num) {
		this.auction_num = auction_num;
	}
	
	public Goods() {
		super();
	}
	public Goods(String source_type, String goods_name, String publisher,
			String description, String type, String goods_img,
			double original_price, double second_price, String old_degree) {
		super();
		this.source_type = source_type;
		this.goods_name = goods_name;
		this.publisher = publisher;
		this.description = description;
		this.type = type;
		this.goods_img = goods_img;
		this.original_price = original_price;
		this.second_price = second_price;
		this.old_degree = old_degree;
	}
	
	
}
