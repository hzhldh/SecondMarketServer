package com.hzh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzh.dao.ShoppingCarDao;
import com.hzh.entity.ShoppingCar;
import com.hzh.service.ShoppingCarService;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService{
	@Autowired
    private ShoppingCarDao shoppingCarDao;

	//物品加入购物车
	@Transactional
	public boolean addShoppingCar(ShoppingCar shoppingCar) {
		return shoppingCarDao.addShoppingCar(shoppingCar);
	}

	//删除购物车物品
	@Transactional
	public boolean delShoppingCar(int shopping_id) {
		return shoppingCarDao.delShoppingCar(shopping_id);
	}

	//显示某用户购物车内的物品
	public List<ShoppingCar> selectCarByUsername(String username) {
		return shoppingCarDao.selectCarByUsername(username);
	}

	//查询物品是否重复加入购物车
	public int selectRepeatCount(ShoppingCar shoppingCar) {
		return shoppingCarDao.selectRepeatCount(shoppingCar);
	}

	public int selectSelfGoods(ShoppingCar shoppingCar) {
		return shoppingCarDao.selectSelfGoods(shoppingCar);
	}

}
