package com.hzh.dao;

import java.util.List;

import com.hzh.entity.ShoppingCar;

public interface ShoppingCarDao {
	//物品加入购物车
	boolean addShoppingCar(ShoppingCar shoppingCar);
	
	//删除购物车物品
	boolean delShoppingCar(int shopping_id);
	
	//显示某用户购物车内的物品
	List<ShoppingCar> selectCarByUsername(String username);
	
}
