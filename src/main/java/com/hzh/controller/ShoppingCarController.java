package com.hzh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzh.entity.ShoppingCar;
import com.hzh.service.ShoppingCarService;

@Controller
@RequestMapping("/shoppingCar")
public class ShoppingCarController {
	@Autowired
	private ShoppingCarService shoppingCarService;
	
	//物品加入购物车
	@ResponseBody 
    @RequestMapping(value="/addShoppingCar",produces = {"text/javascript;charset=UTF-8"})  
	public String addShoppingCar(@ModelAttribute ShoppingCar shoppingCar) {	
		//判断物品是否重复添加
		if (shoppingCarService.selectRepeatCount(shoppingCar)>0) {
			return "1";
		}else if (shoppingCarService.selectSelfGoods(shoppingCar)>0) {//是否为自己发布物品
			return "100";
		}else {
			shoppingCarService.addShoppingCar(shoppingCar); 
	        return "0";
		}
	}
	
	//删除购物车的物品
	@ResponseBody 
    @RequestMapping(value="/delShoppingCar",produces = {"text/javascript;charset=UTF-8"})  
	public String delShoppingCar(int shopping_id) {
        if (shoppingCarService.delShoppingCar(shopping_id)) {
        	return "0";
		} else {
			return "1";
		}
	}
	
	//显示某用户购物车内的物品
	@ResponseBody  
    @RequestMapping(value="/selectCarByName")  
	public List<ShoppingCar> selectCarByName(String username) {  
		List<ShoppingCar> list=shoppingCarService.selectCarByUsername(username);
	    return list;
	}
		
}
