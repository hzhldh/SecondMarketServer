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
	public String addShoppingCar(@ModelAttribute ShoppingCar shoppingCar,HttpServletRequest request) {	
	   shoppingCarService.addShoppingCar(shoppingCar); 
       return "0";
	}
	
	//删除购物车的物品
	@ResponseBody 
    @RequestMapping(value="/delShoppingCar",produces = {"text/javascript;charset=UTF-8"})  
	public String delShoppingCar(int shopping_id) {
        if (shoppingCarService.delShoppingCar(shopping_id)) {
        	return "物品删除成功";
		} else {
			return "物品删除失败";
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
