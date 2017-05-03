package com.hzh.entity;

public class Collect {
	private int collect_id;
	private int goods_id;
	private String username;
	
	private Goods goods;

	public int getCollect_id() {
		return collect_id;
	}

	public void setCollect_id(int collect_id) {
		this.collect_id = collect_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	
}
